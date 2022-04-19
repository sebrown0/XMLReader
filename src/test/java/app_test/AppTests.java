package app_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import xml_file.XMLFile;

class AppTests {
	private static XMLFile xmlFile;
	
	@BeforeAll
	static void setup() {
		xmlFile = new XMLFile("./src/test/java/app_test/config.xml");		
	}
	
	@Test
	void webDriverName() {		
		String content = xmlFile.getElement("WebDriver").getTextContent();
		assertEquals("Google", content);
	}

	@Test
	void reportingStrategy() {
		String content = xmlFile.getElement("Strategy").getTextContent();
		assertEquals("Log", content);		
	}
	
	@Test
	void uri() {
		String content = xmlFile.getElement("URI").getTextContent();
		assertEquals("http://deploy.dakarhr.com/DakarHR.php", content);		
	}
}
