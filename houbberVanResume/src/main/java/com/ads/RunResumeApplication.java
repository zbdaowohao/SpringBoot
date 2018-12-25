package com.ads;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ads.dao")
public class RunResumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunResumeApplication.class, args);
	}
}
