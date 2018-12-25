package com.ads.dataSource.datasource2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Mapper2 {

	@Select("SELECT * FROM tb_user")
	List<Map<String, Object>> findPerson();

	@Insert("INSERT INTO tb_user (userName, role) VALUES (#{name}, #{age})")
	void insertUser(@Param("name") String name, @Param("age") String age);
}
