package com.tomeq.wb.resource;

import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.BeforeClass;

public class AcceptanceTestsBase {

	private static String BaseURI = "http://localhost";
	private static int port = 8088;
	private static String basePath = "/wb-services/service/";

	private static final String AUTHORIZATION_STRING = "Basic Sm9obiBTbWl0aDpwYXNzd29yZA==";

	@BeforeClass
	public static void setup(){
		RestAssured.baseURI = BaseURI;
		RestAssured.port = port;
		RestAssured.basePath = basePath;
	}

	protected JsonPath sendPostRequest(String resource, Object body){
		System.out.println("POST uri: " + resource);
		return given()
				.header("Authorization", AUTHORIZATION_STRING)
				.contentType(MediaType.APPLICATION_JSON)
				.body(body, ObjectMapperType.JACKSON_1)
				.expect()
				.statusCode(200)
				.contentType(MediaType.APPLICATION_JSON)
				.when()
				.post(resource)
				.jsonPath();
	}

	protected JsonPath sendGetRequest(String resource, String id){
		String uri = resource + "/" + id;
		System.out.println("GET uri: " + uri);
		return given()
				.header("Authorization", AUTHORIZATION_STRING)
				.contentType(MediaType.APPLICATION_JSON)
				.expect()
				.statusCode(200)
				.contentType(MediaType.APPLICATION_JSON)
				.when()
				.get(uri)
				.jsonPath();
	}

	protected JsonPath sendDeleteRequest(String resource, String id){
		String uri = resource + "/" + id;
		System.out.println("DELETE uri: " + uri);
		return given()
				.header("Authorization", AUTHORIZATION_STRING)
				.contentType(MediaType.APPLICATION_JSON)
				.expect()
				.statusCode(200)
				.contentType(MediaType.APPLICATION_JSON)
				.when()
				.delete(uri)
				.jsonPath();
	}
}
