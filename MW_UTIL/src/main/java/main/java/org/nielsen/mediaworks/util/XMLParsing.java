package main.java.org.nielsen.mediaworks.util;

public class XMLParsing {
	
	public static boolean enKlik = false;
	
	public static void povleciDatoteko(boolean btnPressed) {
		if(btnPressed && !enKlik) {
			System.out.println("dela");
			enKlik = true;
		}
	}
	
	
}
