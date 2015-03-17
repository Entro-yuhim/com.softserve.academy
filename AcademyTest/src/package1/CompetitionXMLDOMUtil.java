package package1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;

public class CompetitionXMLDOMUtil {
	public void writeToXML(String fileName, Competition comp) {
				
	}

	public Competition readFromXML(String filePath) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setNamespaceAware(true);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		builder.setErrorHandler(new org.xml.sax.ErrorHandler() {
			public void fatalError(SAXParseException spex) throws SAXException {
				// output error and exit
				spex.printStackTrace();
				System.exit(0);
			}

			public void error(SAXParseException spex) throws SAXParseException {
				// output error and continue
				spex.printStackTrace();
			}

			public void warning(SAXParseException spex)
					throws SAXParseException {
				// output warning and continue
				spex.printStackTrace();
			}
		});
		
		
		Document doc = builder.parse(new File(filePath));
		Element root = doc.getDocumentElement();
		String startTime = doc.getElementsByTagName("startTime").item(0).getTextContent();
		String endTime = doc.getElementsByTagName("endTime").item(0).getTextContent();
		NodeList problemList = doc.getElementsByTagName("problem");
		
		
		ArrayList<Problem> problems = new ArrayList<Problem>();
		
		for (int i = 0; i < problemList.getLength(); i++) {
			Node problem = problemList.item(i);
			Element e = (Element) problem;
			
			String diff = e.getElementsByTagName("difficulty").item(0).getTextContent();
			String name = e.getElementsByTagName("name").item(0).getTextContent();
			String description = e.getElementsByTagName("description").item(0).getTextContent();
			Problem problem1 = new Problem(diff, name, description);
			problems.add(problem1);
		}
		DateFormat df = new SimpleDateFormat("MM DD yyyy");
		
		Date startDate = df.parse(startTime);
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		
		Date endDate = df.parse(endTime);
		Calendar endCalendar = Calendar.getInstance();
		startCalendar.setTime(endDate);
		
		
		return new Competition(problems, startCalendar, endCalendar);
	}

}
