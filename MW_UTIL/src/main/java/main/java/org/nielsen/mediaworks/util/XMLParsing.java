package main.java.org.nielsen.mediaworks.util;

import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class XMLParsing {
	
	public static boolean enKlik = false;
	
	public void parsajDatoteko(String pot) {
		try {
			FileInputStream file = new FileInputStream(new File(pot));
			
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder =  builderFactory.newDocumentBuilder();
			
			Document xmlDocument = builder.parse(file);

			XPath xPath =  XPathFactory.newInstance().newXPath();

			
			String expression = "/Employees/Employee[@emplid='1111']/email";
			String email = xPath.compile(expression).evaluate(xmlDocument);
			System.out.println(email);
			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
