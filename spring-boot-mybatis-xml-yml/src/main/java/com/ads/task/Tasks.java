package com.ads.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tasks {
	
	//@Scheduled(fixedRate = 3000)// 每隔3s执行
	@Scheduled(cron = "5-10 * * * * ?")// http://cron.qqe2.com/
	public void cirrentTime() {
		System.out.println("当前时间: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}

}
