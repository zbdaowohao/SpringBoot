package com.ads.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1.捕获返回json 
 * 2.捕获返回页面
 */
// 扫包范围:controller
@ControllerAdvice(basePackages = "com.ads.controller")
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public Map<String, Object> errorResult() {
		Map<String, Object> errorResultMap = new HashMap<String, Object>();
		errorResultMap.put("errorCode", "500");
		errorResultMap.put("errorMsg", "系统异常");
		return errorResultMap;
	}

}
