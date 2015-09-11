package com.tomeq.wb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.tomeq.wb.persistence.entity.City;
import com.tomeq.wb.security.BasicAuthenticator;
import com.tomeq.wb.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/city")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CityResource {

	protected final Logger logger = LoggerFactory.getLogger(CityResource.class);
	private CityService cityService;

	@GET
	public List<City> getAllCities(@Context HttpHeaders headers){
		String user = BasicAuthenticator.authenticate(headers);
		logger.info("Getting all cities for user: {}", user);
			return cityService.getAll(user);
	}

	@GET
	@Path("/{id}")
	public City getCity(@Context HttpHeaders headers, @PathParam("id") String id){
		BasicAuthenticator.authenticate(headers);
		logger.info("Getting city with id: {}", id);
		return cityService.get(id);
	}

	@POST
	@Path("/")
	public String createCity(@Context HttpHeaders headers, City city){
		BasicAuthenticator.authenticate(headers);
		logger.info("Creating city {}", city.getName());
		city = cityService.create(city);
		logger.info("Successfully created city {} with id: {}", city.getName(), city.getId());
		return String.valueOf(city.getId());
	}

	@PUT
	@Path("/")
	public City updateCity(@Context HttpHeaders headers, City city){
		BasicAuthenticator.authenticate(headers);
		logger.info("Updating city {}", city.getName());
		city = cityService.update(city);
		logger.info("Successfully updated city {} with id: {}", city.getName(), city.getId());
		return city;
	}

	@DELETE
	@Path("/{id}")
	public String deleteCity(@Context HttpHeaders headers, @PathParam("id") String id) {
		BasicAuthenticator.authenticate(headers);
		logger.info("Deleting city {}", id);
		id = cityService.delete(id);
		logger.info("Successfully deleted city with id: {}", id);
		return id;
	}

	public void setCityService(CityService cityService){
		this.cityService = cityService;
	}
}
