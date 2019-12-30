package com.ads.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTasks {

	@Async
	public Future<Boolean> task1() throws Exception {
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("task1 执行。。。" + (end - start) + "毫秒");
		return new AsyncResult<Boolean>(true);
	}

	@Async
	public Future<Boolean> task2() throws Exception {
		long start = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("task2 执行。。。" + (end - start) + "毫秒");
		return new AsyncResult<Boolean>(true);
	}

}
