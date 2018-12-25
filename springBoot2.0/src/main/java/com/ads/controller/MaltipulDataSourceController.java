package com.ads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.dataSource.datasource1.service.Service1;
import com.ads.dataSource.datasource2.service.Service2;

/**
 * 多数据源
 */
@RestController
public class MaltipulDataSourceController {

	@Autowired
	private Service1 service1;

	@Autowired
	private Service2 service2;

	// http://localhost:8080/getDatasFromDataSources
	@RequestMapping("/getDatasFromDataSources")
	public String getDatas() {
		return "数据库1：" + service1.selectDataSource1().toString() + "<br/>数据库2："
				+ service2.selectDataSource2().toString();
	}

	@RequestMapping("/insertDatasToDataSources")
	public String insertDatas() {
		service1.insertDataSource1();
		service2.insertDataSource2();
		return "success";
	}

}
