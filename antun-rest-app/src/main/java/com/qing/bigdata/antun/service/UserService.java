package com.qing.bigdata.antun.service;

import java.util.List;

import com.qing.bigdata.antun.domain.User;
import com.qing.bigdata.antun.web.model.UserAdd;
import com.qing.bigdata.antun.web.model.UserUpdate;

public interface UserService {

	List<User> findAll();

	int addUser(UserAdd userAdd);

	User getUser(Long id);

	int updateUser(Long id, UserUpdate userUpdate);

	int deleteUser(Long id);

	User findByPhone(String phone);

	
}
