package com.tomeq.wb.persistence.dao;

import javax.persistence.EntityManager;

public interface Dao {

	Object create(Object o);

	Object update(Object o);

	void delete(Object o);

	void init(EntityManager em);
}
