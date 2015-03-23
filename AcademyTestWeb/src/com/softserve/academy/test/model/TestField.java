//package com.softserve.academy.test.model;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//
//import javax.xml.stream.XMLOutputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamWriter;
//
//public class TestField {
//
//	public static void main(String[] args) throws Exception {
//		//TestField tf = new TestField(); Competition c = tf.createComp();
//		//File source = new File("D:\\YhimWorkspace\\repository\\AcademyTest\\src\\NewFile.xml");
//		//File destination = new File("D:\\YhimWorkspace\\repository\\AcademyTest\\src\\NewFile1.xml");
//		
//		//CompetitionXML CXML = new CompetitionXML();
//		//Competition c = CXML.processXML(source);			
//		//CXML.createXML(destination, c);
//		
//		//System.out.println(c);
//		//new CompetitionDB().writeToDB(c);
//		CompetitionDB cdb = CompetitionDB.getInstance();
//		Competition c = cdb.readFromDB(15);
//		System.out.println(c);
//
//	}
//
//	public Competition createComp() {
//		Problem p1 = new Problem("Easy", "Problem 1", "Easy Problem");
//		Problem p2 = new Problem("Medium", "Problem 2", "Medium Problem");
//		Problem p3 = new Problem("Hard", "Problem 3", "Hard Problem");
//		ArrayList<Problem> ps = new ArrayList<Problem>();
//		ps.add(p1);
//		ps.add(p2);
//		ps.add(p3);
//		Competition c = new Competition();
//		c.setId(15);
//		try {
//			DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
//			Date startDate = df.parse("11 20 25 10 2015");
//			c.setStartTime(startDate);
//
//			Date endDate = df.parse("12 30 31 11 2015");
//			c.setEndTime(endDate);
//
//		} catch (Exception ex) {
//		}
//		c.setAllProblems(ps);
//		return c;
//	}
//
//}