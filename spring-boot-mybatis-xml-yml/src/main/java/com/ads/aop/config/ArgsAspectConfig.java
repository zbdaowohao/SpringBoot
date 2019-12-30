package com.ads.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 匹配任何只有一个Long参数的方法 @Pointcut("within(com.imooc..*) && args(Long)")
 * 匹配第一个参数为Long型的方法 @Pointcut("within(com.imooc..*) && args(Long,..)")
 */
@Aspect
@Component
public class ArgsAspectConfig {

	// 拦截service包下全部类的全部方法且参数第一个是Long、参数第二个是String的全部方法
	@Pointcut("args(Long,String) && within(com.ads.aop.service.*)")
	public void matchTwoArgs() {
	}

	@Before("matchTwoArgs()")
	public void before() {
		System.out.println("###before matchTwoArgs()");
	}
}
