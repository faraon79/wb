package com.tomeq.wb.resource;

import com.tomeq.wb.persistence.entity.City;
import com.tomeq.wb.service.CityService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CityResourceTest {

	private CityResource objectUnderTest;
	@Mock
	private CityService cityService;
	@Mock
	private City city;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new CityResource();
		objectUnderTest.setCityService(cityService);
	}

	@Test
	public void can_create_city(){
		String expectedId = "99";
	}
}