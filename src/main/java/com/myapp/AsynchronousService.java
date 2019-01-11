package com.myapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousService.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private TaskExecutor taskExecutor;

	@PostConstruct
	private void init() {
		LOGGER.info("post construct method called.........");
		specificThreadRunner();
	}

	@PreDestroy
	private void preDestroy() {
		LOGGER.info("pre destroy method called.........");
	}

	public void executeAsynchronously() {

		RunnableThread runnable = applicationContext.getBean(RunnableThread.class);
		
		for (int i = 0; i < 50; i++) {
			taskExecutor.execute(runnable);
		}
	}

	
	@Async("specificTaskExecutor")
	public void specificThreadRunner() {
		LOGGER.info("running specificThreadRunner.........");
	}

}
