package xml_file;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFile {
	String fileName;
	Document document = null;
	
	public XMLFile(String fileName) {
		super();
		this.fileName = fileName;
		readDocument();
	}
	
	private void readDocument() {
    File file = new File(fileName);
    DocumentBuilder db = null;    
    DocumentBuilderFactory dbf = getDocumentFactory();
    
    try {
			db = dbf.newDocumentBuilder();
			document = db.parse(file);
		} catch (SAXException | ParserConfigurationException | IOException e) {			
			e.printStackTrace();
		}    
	}

	public NodeList getNodes(String nodeName) {
		return document.getElementsByTagName(nodeName);
	}
	
	public Element getElement(String name) {
		NodeList nList = document.getElementsByTagName(name);
		return (Element) nList.item(0);		
	}
		
	private DocumentBuilderFactory getDocumentFactory() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    try {
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}    
    return dbf;
	}
}
