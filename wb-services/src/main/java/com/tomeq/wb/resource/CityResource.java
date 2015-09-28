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
	public String createCity(){
		throw new UnsupportedOperationException("Unsupported operation!");
	}

	@PUT
	@Path("/")
	public City updateCity(){
		throw new UnsupportedOperationException("Unsupported operation!");
	}

	@DELETE
	@Path("/{id}")
	public String deleteCity(@PathParam("id") String id) {
		throw new UnsupportedOperationException("Unsupported operation!");
	}

	public void setCityService(CityService cityService){
		this.cityService = cityService;
	}
}
