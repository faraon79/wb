package com.tomeq.wb.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/city")
@Produces({MediaType.APPLICATION_JSON})
public class City {

	protected final Logger logger = LoggerFactory.getLogger(City.class);

	@GET
	public String getCites(){
		logger.info("Getting all cities");
		return "All cities";
	}

	@GET
	@Path("/{id}")
	public String getCity(@PathParam("id") String id){
		logger.info("Getting city with id: {}", id);
		return "City id: " + id;
	}


}
