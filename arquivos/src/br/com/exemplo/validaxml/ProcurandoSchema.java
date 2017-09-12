package br.com.exemplo.validaxml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProcurandoSchema extends DefaultHandler{
	@SuppressWarnings("unused")
	private String tempVal;
	private String meusquema;
	
	
	public ProcurandoSchema() {
		
	}
	
	public void parseDocument(String path) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(path, this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startDocument() {
        System.out.println("\nIniting the Parsing...\n");
    }

	// Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// reset
		tempVal = "";		
		for (int i = 0; i < attributes.getLength(); i++) {
			if (attributes.getQName(i).equalsIgnoreCase("xsi:schemaLocation")) {
				meusquema = attributes.getValue(i);
				break;
			}	
		}
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		 System.out.println("\nIniting the Parsing...\n");
	}

	public String getSchema(String xml) {
		parseDocument(xml);
		return meusquema;
	}

}
