package com.ads.controller;

import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ads.aop.service.AopService;
import com.ads.enums.ResultEnum;
import com.ads.exception.model.MyException;
import com.ads.model.UserModel;
import com.ads.service.UserService;
import com.ads.utils.ResultData;

@Controller
public class WelcomeController {

	private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AopService aopService;

	@RequestMapping(value = { "/aop" })
	@ResponseBody
	// http://127.0.0.1:8088/resume/aop
	public String aop() {
		aopService.noArgsMethod();
		aopService.oneArgsMethod(1L);
		aopService.towArgsMethod(1L, "1");
		aopService.MethodOnly();
		try {
			aopService.exceptionMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "AOP SUCCESS!";
	}

	@RequestMapping(value = { "/save" })
	@ResponseBody
	public String save() throws SQLException {
		userService.addUser(new UserModel("houbberVan", "admin"));
		return "Save success !!!!";
	}

	// http://127.0.0.1:8088/demo/find?params=test
	@RequestMapping(value = { "/find" })
	@ResponseBody
	public ResultData<Map<String, Object>> find(String params) throws SQLException {
		logger.info("获取用户列表  >>>> params={}", params);
		
		/*if (true) {
			throw new MyException(ResultEnum.ERROR);
		}*/
		
		try {
			return ResultData.success(userService.findList());
		} catch (Exception e) {
			return ResultData.sysError();
		}
	}
	
	@RequestMapping(value = { "/filter" })
	@ResponseBody
	public String filter() throws SQLException {
		return "filter";
	}

}
