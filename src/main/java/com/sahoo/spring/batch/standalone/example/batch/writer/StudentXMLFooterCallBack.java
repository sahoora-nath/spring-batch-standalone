package com.sahoo.spring.batch.standalone.example.batch.writer;

import java.io.IOException;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.springframework.batch.item.xml.StaxWriterCallback;

public class StudentXMLFooterCallBack implements StaxWriterCallback {

	@Override
	public void write(XMLEventWriter writer) throws IOException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();

		XMLEvent event = eventFactory.createEndElement("", "", "StudentsList");
		try {
			writer.add(event);
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
