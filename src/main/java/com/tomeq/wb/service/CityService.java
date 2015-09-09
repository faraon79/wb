package com.tomeq.wb.service;

import com.tomeq.wb.persistence.common.DaoFactory;
import com.tomeq.wb.persistence.dao.CityDao;
import com.tomeq.wb.persistence.entity.City;

public class CityService {

	private CityDao cityDao;

	public CityService() {
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		cityDao = (CityDao)daoFactory.getDao(CityDao.class);
	}

	public City createCity(String owner, String name){
		City city = new City();
		city.setName(name);
		city.setOwner(owner);
		return cityDao.create(city);
	}

	public City getCity(String id){
		return cityDao.findById(id);
	}

}
