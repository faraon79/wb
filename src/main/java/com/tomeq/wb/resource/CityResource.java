package com.tomeq.wb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.tomeq.wb.exception.NotAuthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomeq.wb.service.CityService;
import com.tomeq.wb.persistence.entity.City;

@Path("/city")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CityResource {

	protected final Logger logger = LoggerFactory.getLogger(CityResource.class);
	private CityService cityService;

	@GET
	public List<City> getCites(@Context HttpHeaders headers){
		String user = getAuthenticatedUserOrThrowException(headers);
		logger.info("Getting all cities for user: {}", user);
			return cityService.getAll(user);
	}

	@GET
	@Path("/{id}")
	public City getCity(@PathParam("id") String id){
		logger.info("Getting city with id: {}", id);
		return cityService.get(id);
	}

	@POST
	@Path("/")
	public String createCity(City city){
		logger.info("Creating city {}", city.getName());
		city = cityService.create(city);
		logger.info("Successfully created city {} with id: {}", city.getName(), city.getId());
		return String.valueOf(city.getId());
	}

	private String getAuthenticatedUserOrThrowException(HttpHeaders headers) {
		if(headers.getRequestHeader("user").size() > 0 )
			return headers.getRequestHeader("user").get(0);
		throw new NotAuthorizedException("You are not authorized!");
	}

	public void setCityService(CityService cityService){
		this.cityService = cityService;
	}
}
