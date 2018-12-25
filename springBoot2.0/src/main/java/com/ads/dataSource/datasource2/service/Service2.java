package com.ads.dataSource.datasource2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ads.dataSource.datasource2.mapper.Mapper2;

@Service
public class Service2 {

	@Autowired
	private Mapper2 mapper;

	public List<Map<String, Object>> selectDataSource2() {
		return mapper.findPerson();
	}

	@Transactional(transactionManager = "datasource2TransactionManager")
	public void insertDataSource2() {
		mapper.insertUser("houbberVan2", "25");
		//int i = 1 / 0;
	}

}
