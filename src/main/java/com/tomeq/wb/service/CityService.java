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

	public List<City> getAll(String owner) {
		return cityDao.findByOwner(owner);
	}

	public City get(String id){
		return cityDao.findById(id);
	}

	public City create(City city){
		return cityDao.create(city);
	}

	public City update(City city) {
		return cityDao.update(city);
	}

	public String delete(String id) {
		City city = get(id);
		cityDao.delete(city);
		return id;
	}
}
