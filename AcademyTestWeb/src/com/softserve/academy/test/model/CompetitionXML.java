package com.softserve.academy.test.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.helpers.DefaultHandler;

public class CompetitionXML extends DefaultHandler {

	private static boolean startDateFlag = false;
	private static boolean endDateFlag = false;
	private static boolean difficultyFlag = false;
	private static boolean nameFlag = false;
	private static boolean descriptionFlag = false;

	public Competition createCompetitionFromXML(File f) throws Exception {
		String diffty = null;
		String name = null;
		String descr = null;
		ArrayList<Problem> problems = new ArrayList<Problem>();
		String startDate1 = null;
		String endDate1 = null;
		Problem prob = null;
		int id = 0;
		int compId = 0;
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
				.createXMLStreamReader(new FileInputStream(f));
		while (xmlStreamReader.hasNext()) {
			int xmlEvent = xmlStreamReader.next();
			switch (xmlEvent) {
			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("startDate")) {
					compId = Integer.parseInt(xmlStreamReader
							.getAttributeValue(0));
				} else if (xmlStreamReader.getLocalName().equals("startDate")) {
					startDateFlag = true;
				} else if (xmlStreamReader.getLocalName().equals("endDate")) {
					endDateFlag = true;
				} else if (xmlStreamReader.getLocalName().equals("difficulty")) {
					difficultyFlag = true;
				} else if (xmlStreamReader.getLocalName().equals("name")) {
					nameFlag = true;
				} else if (xmlStreamReader.getLocalName().equals("description")) {
					descriptionFlag = true;
				} else if (xmlStreamReader.getLocalName().equals("problem")) {
					id = Integer.parseInt(xmlStreamReader.getAttributeValue(0));
				}

				break;
			case XMLStreamConstants.CHARACTERS:
				if (startDateFlag) {
					startDate1 = xmlStreamReader.getText();
					startDateFlag = false;
				} else if (endDateFlag) {
					endDate1 = xmlStreamReader.getText();
					endDateFlag = false;
				} else if (difficultyFlag) {
					diffty = xmlStreamReader.getText();
					difficultyFlag = false;
				} else if (nameFlag) {
					name = xmlStreamReader.getText();
					nameFlag = false;
				} else if (descriptionFlag) {
					descr = xmlStreamReader.getText();
					descriptionFlag = false;
				}

				break;
			case XMLStreamConstants.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("problem")) {
					prob = new Problem(id, diffty, name, descr);
					problems.add(prob);
					break;

				}
			}
		}

		DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");

		Date startDate = df.parse(startDate1);
		Date endDate = df.parse(endDate1);

		Competition c = new Competition(problems, startDate, endDate);
		return c;

	}

	public void createXMLFromCompetition(File file, Competition c) {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		try {

			DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
			XMLStreamWriter writer = factory.createXMLStreamWriter(
					new FileOutputStream(file), "UTF-8");
			writer.writeStartDocument("utf-8", "1.0");
			writer.writeStartElement("competition");
			writer.writeAttribute("id", new Integer(c.getId()).toString());
			writer.writeStartElement("startDate");
			writer.writeCharacters(df.format(c.getStartTime().getTime()));
			writer.writeEndElement();
			writer.writeStartElement("endDate");
			writer.writeCharacters(df.format(c.getEndTime().getTime()));
			writer.writeEndElement();
			writer.writeStartElement("problems");
			ArrayList<Problem> problems = c.getAllProblems();
			for (Problem problem : problems) {
				writer.writeStartElement("problem");
				writer.writeAttribute("id",
						new Integer(problem.getId()).toString());
				writer.writeStartElement("difficulty");
				writer.writeCharacters(problem.getDifficultyName());
				writer.writeEndElement();
				writer.writeStartElement("name");
				writer.writeCharacters(problem.getName());
				writer.writeEndElement();
				writer.writeStartElement("description");
				writer.writeCharacters(problem.getDescription());
				writer.writeEndElement();
				writer.writeEndElement();
			}
			writer.writeEndElement();
			writer.writeEndElement();
			writer.flush();
			writer.close();
		} catch (XMLStreamException tex) {
			tex.printStackTrace();
		} catch (IOException iex) {
			iex.printStackTrace();
		}

	}
}