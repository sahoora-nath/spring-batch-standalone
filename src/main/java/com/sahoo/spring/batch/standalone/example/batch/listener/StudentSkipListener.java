package com.sahoo.spring.batch.standalone.example.batch.listener;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.oxm.XmlMappingException;

import com.sahoo.spring.batch.standalone.example.model.Student;

public class StudentSkipListener<T, S> implements SkipListener<Exception, Student> {

	final static Logger logger = LoggerFactory.getLogger(StudentSkipListener.class);
	private StaxEventItemWriter<Student> errorItemWriter;
	@Override
	public void onSkipInRead(Throwable t) {
		logger.error("StudentSkipListener:onSkipRead - > SKIPPED - "+t.getMessage());
	}

	@Override
	public void onSkipInWrite(Student item, Throwable t) {
		logger.info("StudentSkipListener:onSkipInWrite -> SKIPPED - "+item.getStudentName());
		List<Student> items = new ArrayList<>();
		items.add(item);
		try {
			errorItemWriter.write(items);
		} catch (XmlMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void onSkipInProcess(Exception item, Throwable t) {
		logger.info("StudentSkipListener:onSkipInProcess -> SKIPPED - "+item.getMessage());
	}

	public StaxEventItemWriter<Student> getErrorItemWriter() {
		return errorItemWriter;
	}

	public void setErrorItemWriter(StaxEventItemWriter<Student> errorItemWriter) {
		this.errorItemWriter = errorItemWriter;
	}
}
