package com.sahoo.spring.batch.standalone.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main Application to start batch Job.
 *
 */
public class App {
	private static ClassPathXmlApplicationContext context;
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("batch-context.xml");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("studentsJob");

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			logger.info("Job Exit Status : " + execution.getStatus());
		} catch (JobExecutionException e) {
			logger.error("Job ExamResult failed");
			logger.error(e.getMessage(), e);
		} finally {
			if(context != null) {
				context.close();
			}
		}
	}
}
