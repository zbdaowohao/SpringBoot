package com.ads.aop.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ads.controller.WelcomeController;

/**
 * 匹配任何以find开头而且只有一个Long参数的方法 @Pointcut("execution(* *..find*(Long))")
 * 匹配任何以find开头的而且第一个参数为Long型的方法 @Pointcut("execution(* *..find*(Long,..))")
 * 匹配任何公共方法 @Pointcut("execution(public * com.imooc.service.*.*(..))")
 * 匹配com.imooc包及子包下Service类中无参方法 @Pointcut("execution(* com.imooc..*Service.*())")
 * 匹配com.imooc包及子包下Service类中的任何只有一个参数的方法 @Pointcut("execution(* com.imooc..*Service.*(*))")
 * 匹配com.imooc包及子包下任何类的任何方法 @Pointcut("execution(* com.imooc..*.*(..))")
 * 匹配com.imooc包及子包下返回值为String的任何方法 @Pointcut("execution(String com.imooc..*.*(..))")
 * 匹配异常 execution(public * com.imooc.service.*.*(..) throws java.lang.IllegalAccessException)
 * 
 */
@Aspect
@Component
public class ExecutionAspectConfig {

	private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	// 修饰符、返回值、包名、方法名、(方法参数)、抛出异常
	// 拦截public修饰的任意返回值的在service包下及其子包中全部类下的全部方法中任意参数且抛出NullPointerException异常的方法
	@Pointcut("execution(public * com.ads.aop.service..*.*(..) throws java.lang.NullPointerException)")
	public void matchExecution() {
	}

	@Before("matchExecution()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURL());
		//method
		logger.info("method={}", request.getMethod());
		//ip
		logger.info("ip={}", request.getRemoteAddr());
		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		//参数
		logger.info("args={}", joinPoint.getArgs());
		
		System.out.println("###before matchExecution");
	}
	
	@AfterReturning(pointcut = "matchExecution()", returning = "obj")
	public void doAfterReturning(Object obj){
		logger.info("response={}" ,obj.toString());
	}

}
