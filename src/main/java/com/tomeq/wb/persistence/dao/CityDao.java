package com.tomeq.wb.persistence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tomeq.wb.persistence.entity.City;

public class CityDao extends BaseDao{

	public static final String QUERY_KEY_OWNER = "owner";

	public City create(City o) {
		return (City)super.create(o);
	}

	public City update(City o) {
		return (City)super.update(o);
	}

	public void delete(City o) {
		super.delete(o);
	}

	public City findById(String id) {
		return (City)super.findByPk(City.class, Integer.valueOf(id));
	}

	public List<City> findByOwner(String owner){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(QUERY_KEY_OWNER, owner);
		return (List<City>)super.findByQuery("City.findByOwner", map);
	}
}
