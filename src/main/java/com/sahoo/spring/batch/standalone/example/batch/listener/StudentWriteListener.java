package com.sahoo.spring.batch.standalone.example.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.oxm.XmlMappingException;

import com.sahoo.spring.batch.standalone.example.model.Student;

public class StudentWriteListener<T> implements ItemWriteListener<Student> {
	final static Logger logger = LoggerFactory.getLogger(StudentSkipListener.class);
	private StaxEventItemWriter<Student> successItemWriter;
	
	@Override
	public void beforeWrite(List<? extends Student> items) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterWrite(List<? extends Student> items) {
		try {
			successItemWriter.write(items);
		} catch (XmlMappingException e) {
			logger.error("StudentWriteListener: XmlMappingException - "+ e.getMessage());
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("StudentWriteListener: Exception - "+ e.getMessage());
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Student> items) {
		logger.error("StudentWriteListener: onWriteError - "+ exception.getMessage());
		logger.error(items.toString());
	}

	public StaxEventItemWriter<Student> getSuccessItemWriter() {
		return successItemWriter;
	}

	public void setSuccessItemWriter(StaxEventItemWriter<Student> successItemWriter) {
		this.successItemWriter = successItemWriter;
	}	
}
