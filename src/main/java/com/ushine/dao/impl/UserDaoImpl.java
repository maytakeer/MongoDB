package com.ushine.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.ushine.dao.IUserDao;

public abstract class UserDaoImpl<T> implements IUserDao<T>{
	
	protected abstract Class<T> getEntityClass();
	
	@Autowired
	protected MongoTemplate mgt;

	@Override
	public void save(T entity) {
		mgt.save(entity);
	}

	@Override
	public void update(T entity) {
		//反向解析对象
		/*Map<String, Object> map = null;
		try {
			map = parseEn
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}

	@Override
	public void delete(Serializable... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
