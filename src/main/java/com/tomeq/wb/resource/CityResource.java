package com.tomeq.wb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tomeq.wb.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomeq.wb.persistence.entity.City;


@Path("/city")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CityResource {

	protected final Logger logger = LoggerFactory.getLogger(CityResource.class);
	private CityService cityService;

	@GET
	public String getCites(){
		logger.info("Getting all cities");
		return "All cities";
	}

	@GET
	@Path("/{id}")
	public City getCity(@PathParam("id") String id){
		logger.info("Getting city with id: {}", id);
		return cityService.getCity(id);
	}

	@POST
	@Path("/")
	public String createCity(City city){
		logger.info("Creating city {}", city.getName());
		City tempCity = cityService.createCity(city.getOwner(), city.getName());
		logger.info("Successfully created city {} with id: {}", city.getName(), city.getId());
		return String.valueOf(tempCity.getId());
	}

	public void setCityService(CityService cityService){
		this.cityService = cityService;
	}
}
