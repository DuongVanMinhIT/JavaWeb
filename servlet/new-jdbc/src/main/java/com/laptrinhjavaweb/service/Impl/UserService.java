package com.laptrinhjavaweb.service.Impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserServive;

public class UserService implements IUserServive{

	@Inject
	private IUserDao userDao;
	
	@Override
	public UserModel FindByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {

		return userDao.FindByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
