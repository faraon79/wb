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

	public City create(City city){
		return cityDao.create(city);
	}

	public City get(String id){
		return cityDao.findById(id);
	}

}
