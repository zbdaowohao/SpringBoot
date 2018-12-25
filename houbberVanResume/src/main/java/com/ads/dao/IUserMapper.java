package com.ads.dao;

import com.ads.model.UserModel;

public interface IUserMapper extends IBasicMapper<UserModel> {

	void addOne(UserModel user);

	String findByUser(UserModel user);

	String findByUserName(String userName);

}
