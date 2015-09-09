package com.tomeq.wb.service;

import java.util.List;

import com.tomeq.wb.persistence.common.DaoFactory;
import com.tomeq.wb.persistence.dao.CityDao;
import com.tomeq.wb.persistence.entity.City;

public class CityService {

	private CityDao cityDao;

	public CityService() {
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		cityDao = (CityDao)daoFactory.getDao(CityDao.class);
	}

	public City create(City city){
		return cityDao.create(city);
	}

	public City get(String id){
		return cityDao.findById(id);
	}

	public List<City> getAll(String owner) {
		return cityDao.findByOwner(owner);
	}
}
