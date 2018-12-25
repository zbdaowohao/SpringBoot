package com.ads.dao;


import java.util.List;

public interface IBasicMapper<T> {
	
	int count(T t);
	
	void addOne(T t);
	
	List<T>findList();
	
	void updateById(Integer id);
	
	void delById(Integer id);

}
