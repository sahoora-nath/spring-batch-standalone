package com.sahoo.spring.batch.standalone.example.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.sahoo.spring.batch.standalone.example.model.Student;

/**
 * This is Optional, and called after item read but before item write.
 * It gives us the opportunity to perform a business logic on each item.
 * @author sahoora-nath
 *
 */
public class StudentItemProcessor implements ItemProcessor<Student, Student> {

	final static Logger logger = LoggerFactory.getLogger(StudentItemProcessor.class);
	@Override
	public Student process(Student student) throws Exception {
		/*
         * Only return students which are equal or more than 60%
         *
         */
        if(student.getPercentage() < 60){
            return null;
        }
        logger.info("processing student {} ", student.getStudentName());
        return student;
	}
}
