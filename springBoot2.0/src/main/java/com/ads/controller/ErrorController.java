package com.ads.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局捕获异常
 */
@RestController
public class ErrorController {

	@RequestMapping("/getError")
	public String getError() {
		int i = 1 / 0;
		return "is error" + i;
	}
	
}
