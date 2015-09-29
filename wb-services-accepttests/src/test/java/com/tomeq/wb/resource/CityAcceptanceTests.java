package com.tomeq.wb.resource;

import com.jayway.restassured.path.json.JsonPath;
import com.tomeq.wb.persistence.entity.City;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class CityAcceptanceTests extends AcceptanceTestsBase {

	public static final String RESOURCE = "city";
	public static final String OWNER = "John Smith";
	public static final String TEST_NAME = "Some_name";

	@Before
	public void before() {
		JsonPath jsonPath = sendGetRequest(RESOURCE, "");
		List<Integer> ids = jsonPath.getList("id");
		for (int id : ids) {
			sendDeleteRequest(RESOURCE, String.valueOf(id));
		}
	}

	@Test
	public void can_get_city() {
		String id = createCity(TEST_NAME);

		JsonPath jsonPath = sendGetRequest(RESOURCE, id);
		assertEquals(TEST_NAME, jsonPath.get("name"));
	}

	@Test
	public void can_get_all_cities() {
		createCities(5);
		JsonPath jsonPath = sendGetRequest(RESOURCE, "");
		assertEquals(5, jsonPath.getList("name").size());
	}

	private void createCities(int number) {
		for (int i = 0; i < number; i++) {
			createCity(TEST_NAME + "_" + i);
		}
	}

	private String createCity(String name) {
		City city = new City();
		city.setName(name);
		city.setOwner(OWNER);
		int id = sendPostRequest(RESOURCE, city).get("id");
		return String.valueOf(id);
	}
}
