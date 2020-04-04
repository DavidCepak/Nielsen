package main.java.org.nielsen.mediaworks.util;

import java.io.*;
import java.net.*;
import java.sql.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XMLParsing {
	
	public String databaseURL;
	public String http;
	public String username;
	public String password;
	
	public void parsajDatoteko(String pot) {
		try {
			FileInputStream file = new FileInputStream(new File(pot));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =  builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath =  XPathFactory.newInstance().newXPath();
			
			//URL
			String expression = "/server/profile/subsystem/datasources/datasource/connection-url";
			databaseURL = xPath.compile(expression).evaluate(xmlDocument);
			
			//username
			expression = "/server/profile/subsystem/datasources/datasource/security/user-name";
			username = xPath.compile(expression).evaluate(xmlDocument);
			
			//password
			expression = "/server/profile/subsystem/datasources/datasource/security/password";
			password = xPath.compile(expression).evaluate(xmlDocument);
			
			
			expression = "/server/system-properties/property[@name = 'nanocollectionfacilityURL']/@value";
			http = xPath.compile(expression).evaluate(xmlDocument);
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	//za povezavo z bazo
	public void poveziDatabase() {
		try {
			Connection db = DriverManager.getConnection(databaseURL, username, password);
			
			if (db != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//povezava s HTTP
	public void poveziHTTP() {
		URL obj;
		HttpURLConnection con;
		try {
			obj = new URL(http);
			con = (HttpURLConnection) obj.openConnection();
			
			System.out.println(con.getResponseCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
