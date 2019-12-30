package com.ads.dao;


import java.sql.SQLException;

import com.ads.model.UserModel;
import com.github.pagehelper.Page;

public interface IBasicMapper<T> {
	
	void addOne(T t) throws SQLException;
	
	Page<UserModel> findList() throws SQLException;

}
