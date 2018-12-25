package com.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 通过定位扫包，可以跳过无用的包，提高启动速度<br>
 * 初始化堆内存与最大堆相同以减少垃圾回收次数<br>
 * 使用Undertow替换Tomcat容器以提升吞吐量(使用apache-jmeter监测)<br>
 */
// @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan
@ComponentScan(basePackages = { "com.ads.controller", "com.ads.dataSource" }) // 扫描注入的：controller、service
@EnableAutoConfiguration
public class SpringBoot2_0 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2_0.class, args);
	}
}
