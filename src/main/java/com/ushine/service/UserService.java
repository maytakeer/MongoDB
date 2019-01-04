package com.ushine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ushine.dao.IUserDao;
import com.ushine.dao.impl.UserDaoImpl;
import com.ushine.entity.UserInfo;

public class UserService extends UserDaoImpl<UserInfo>{



	
	
	@Override
	protected Class<UserInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
