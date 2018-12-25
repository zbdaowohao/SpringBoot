package com.ads.dataSource.datasource1.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

public interface Mapper1 {

	@Select("SELECT * FROM tb_user")
	Page<Map<String, Object>> findUser();

	@Insert("INSERT INTO tb_user (userName, role) VALUES (#{name}, #{age})")
	void insertUser(@Param("name") String name, @Param("age") String age);
}
