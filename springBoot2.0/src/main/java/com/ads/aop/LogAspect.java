package com.ads.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

	@Pointcut("execution(public * com.ads.controller.*.*(..))")
	public void webLog() {

	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求,记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		String url = "REQUEST: " + request.getRequestURL().toString();
		String inputArgs = "  INPUTARGS: " + JSON.toJSONString(request.getParameterMap());
		String ip = "  IP: " + request.getRemoteAddr();
		log.info(url + inputArgs + ip);
	}

	@AfterReturning(pointcut = "webLog()", returning = "obj")
	public void doAfterReturning(Object obj) throws Throwable {
		// 处理完请求,返回内容
		log.info("Response: " + obj);
	}

}
