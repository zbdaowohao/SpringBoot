package com.ads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.dao.IUserMapper;
import com.ads.model.UserModel;

@Service
public class UserService {

	@Autowired
	private IUserMapper iUserMapper;

	public void addUser(UserModel user) {
		iUserMapper.addOne(user);
	}

	public int count(UserModel user) {
		return iUserMapper.count(user);
	}

	public String findByUser(UserModel user) {
		return iUserMapper.findByUser(user);
	}
	
	public String findByUserName(String userName) {
		return iUserMapper.findByUserName(userName);
	}
}
