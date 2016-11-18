package com.sahoo.spring.batch.standalone.example.batch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/batch-context.xml", "/test-context.xml"})
public class EndToEndStudentJobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Rollback(true)
	@Test	
	public void lunchJobTest() throws Exception {
		//launching a job test
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}
}
