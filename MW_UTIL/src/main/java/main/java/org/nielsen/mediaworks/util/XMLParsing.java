package main.java.org.nielsen.mediaworks.util;

import java.io.*;
import java.sql.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class XMLParsing {
	
	public String databaseURL;
	public String username;
	public String password;
	
	public void parsajDatoteko(String pot) {
		try {
			FileInputStream file = new FileInputStream(new File(pot));
			
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder =  builderFactory.newDocumentBuilder();
			
			Document xmlDocument = builder.parse(file);

			XPath xPath =  XPathFactory.newInstance().newXPath();
			
			String expression = "/server/profile/subsystem/datasources/datasource/connection-url";
			
			databaseURL = xPath.compile(expression).evaluate(xmlDocument);
			
			//username
			expression = "/server/profile/subsystem/datasources/datasource/security/user-name";
			
			username = xPath.compile(expression).evaluate(xmlDocument);
			
			//password
			expression = "/server/profile/subsystem/datasources/datasource/security/password";
			
			password = xPath.compile(expression).evaluate(xmlDocument);
			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	//za povezavo z bazo
	public void poveziDatabase() {
		try {
			Connection db = DriverManager.getConnection(databaseURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
