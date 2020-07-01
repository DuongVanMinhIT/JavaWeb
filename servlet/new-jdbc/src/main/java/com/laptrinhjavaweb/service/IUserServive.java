package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserServive {
	UserModel FindByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
