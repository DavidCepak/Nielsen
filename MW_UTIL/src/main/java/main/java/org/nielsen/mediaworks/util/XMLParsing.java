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

			
			String expression = "/server/management/security-realms[@name = 'ManagementRealm']/secirity-realm";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			System.out.println(expression);
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println(i);
			    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
			}
			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
