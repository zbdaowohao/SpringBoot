package com.ads.aop.service;

import org.springframework.stereotype.Service;

import com.ads.aop.annotation.MethodOnly;

@Service
public class AopService {

	public void noArgsMethod() {
		System.out.println("noArgsMethod");
	}

	public void oneArgsMethod(Long age) {
		System.out.println("oneArgsMethod");
	}

	public void towArgsMethod(Long age, String name) {
		System.out.println("towArgsMethod");
	}

	@MethodOnly
	public void MethodOnly() {
		System.out.println("MethodOnly");
	}
	
	public String exceptionMethod() throws NullPointerException {
		System.out.println("exceptionMethod");
		return "returnString";
	}

}
