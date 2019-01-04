package com.ushine.dao;

import java.io.Serializable;

public interface IUserDao<T> {
	
	void save(T entity);
	
	void update(T entity);
	
	void delete(Serializable... ids);
	
	T find(Serializable id);
}
