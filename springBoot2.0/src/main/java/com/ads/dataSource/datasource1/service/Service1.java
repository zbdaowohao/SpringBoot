package com.ads.dataSource.datasource1.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ads.dataSource.datasource1.mapper.Mapper1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class Service1 {

	@Autowired
	private Mapper1 mapper;

	public Page<Map<String, Object>> selectDataSource1() {
		int pageNum = 1;
		int pageSize = 10;
		PageHelper.startPage(pageNum, pageSize);
		Page<Map<String, Object>> list = mapper.findUser();
		return list;
	}

	@Transactional(transactionManager = "datasource1TransactionManager")
	public void insertDataSource1() {
		mapper.insertUser("houbberVan1", "25");
		// int i = 1 / 0;
	}

}
