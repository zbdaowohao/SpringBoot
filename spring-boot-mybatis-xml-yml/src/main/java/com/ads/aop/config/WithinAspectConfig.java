package com.ads.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 匹配ProductService类里头的所有方法 @Pointcut("within(com.imooc.service.ProductService)")
 * 匹配com.imooc包及子包下所有类的方法 @Pointcut("within(com.imooc..*)")
 * 拦截service包下及其全部子包下全部类的全部方法 @Pointcut("within(com.ads.service..*)")
 */

@Aspect
@Component
public class WithinAspectConfig {

	// 拦截包下全部类的全部方法
	@Pointcut("within(com.ads.aop.service.*)")
	public void matchWithin() {
	}

	@Before("matchWithin()")
	public void before() {
		System.out.println("###before matchWithin()");
	}
}
