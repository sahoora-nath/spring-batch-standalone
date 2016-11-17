package com.sahoo.spring.batch.standalone.example.batch.writer;

import java.io.IOException;
import java.util.Collections;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;

import org.springframework.batch.item.xml.StaxWriterCallback;

public class StudentXMLHeaderCallBack implements StaxWriterCallback {

	@Override
	public void write(XMLEventWriter writer) throws IOException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		StartElement event = eventFactory.createStartElement("", "", "StudentsList", 
				Collections.emptyList().iterator(), Collections.emptyList().iterator());
		try {
			writer.add(event);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
