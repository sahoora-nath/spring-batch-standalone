package com.sahoo.spring.batch.standalone.example.batch;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class StudentJobListener implements JobExecutionListener {
	final static Logger logger = LoggerFactory.getLogger(StudentJobListener.class);
	LocalDateTime startTime, stopTime;

	@Override
	public void beforeJob(JobExecution jobExcecution) {
		startTime = LocalDateTime.now();
		logger.info("Job starts at :"+ startTime);
	}
	
	@Override
	public void afterJob(JobExecution jobExcecution) {
		stopTime = LocalDateTime.now();
		logger.info("Job stops at : {}", stopTime);
		logger.info("Total time take in millis : {}", ChronoUnit.MILLIS.between(startTime, stopTime));
	}
}
