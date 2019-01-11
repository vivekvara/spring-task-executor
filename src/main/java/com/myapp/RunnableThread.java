package com.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RunnableThread implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunnableThread.class);

	@Override
	public void run() {
		LOGGER.info("Runnable thread is called and running....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
