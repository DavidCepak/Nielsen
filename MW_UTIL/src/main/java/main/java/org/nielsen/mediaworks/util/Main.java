package main.java.org.nielsen.mediaworks.util;

public class Main {
	
	public static void main(String[] args) {
		XMLParsing parsaj = new XMLParsing();
		
		String pot = "C:\\Users\\frank\\eclipse-workspace\\ProjektNiealsen\\Nielsen\\MW_UTIL\\res\\standalone-full.xml";
		parsaj.parsajDatoteko(pot);
		
		parsaj.poveziDatabase();
		
	}

}
