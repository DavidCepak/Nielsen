package main.java.org.nielsen.mediaworks.util;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XMLParsing {
	
	public String databaseURL;
	public String http;
	public String username;
	public String password;
	
	public ArrayList<String> vse = new ArrayList<String>();
	
	//to je cačasno ampak vse sparsano od system-properties
	private String[] podatki = {"portal.rest.restbridgeurl", "collections.multicountry.support.debug", "fromqueue", "upmulticountriessupport.concconsumer", "4", "8", "6", "3", "9", "mcs.root.url", "mcs.root.path", "mcs.root.resource.path", "metermanagement.gr.url"};
	
	public void getData(String pot) {
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
			
			//http
			expression = "/server/system-properties/property[@name = 'nanocollectionfacilityURL']/@value";
			http = xPath.compile(expression).evaluate(xmlDocument);
			
			//od tle naprej je zacasen arraylist
			for(int i = 0; i < podatki.length; i++) {
				expression = "/server/system-properties/property[@name = '"+ podatki[i] +"']/@value";
				vse.add(xPath.compile(expression).evaluate(xmlDocument));
				System.out.println(vse.get(i));
			}
			
			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	//za povezavo z bazo
	public void poveziDatabase() {
		try {
			Connection db = DriverManager.getConnection(databaseURL, username, password);
			
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
