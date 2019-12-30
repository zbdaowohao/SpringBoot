package com.ads.task;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/async")
public class DoAsyncTask {

	@Autowired
	private AsyncTasks asyncTasks;

	// http://127.0.0.1:8088/demo/async/doTask
	@RequestMapping("/doTask")
	@ResponseBody
	private String runAsyncTask() throws Exception {
		long start = System.currentTimeMillis();

		Future<Boolean> task1 = asyncTasks.task1();
		Future<Boolean> task2 = asyncTasks.task2();

		while (!task1.isDone() || !task2.isDone()) {
			if (task1.isDone() && task2.isDone()) {
				break;
			}
		}

		long end = System.currentTimeMillis();

		String times = "任务耗时:" + (end - start) + "毫秒";
		System.out.println(times);
		return times;
	}

}
