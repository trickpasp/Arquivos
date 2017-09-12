package br.com.exemplo.validaxml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidator {
	private ProcurandoSchema find;
	
	public XSDValidator() {
		find = new ProcurandoSchema();
	}
	
	public void verificar(String xmlPath) {
		if(validateXMLSchema(xmlPath)) System.out.println("It's valid");
		else System.out.println("It isn't valid");
	}

	 public boolean validateXMLSchema(String xmlPath){
	        try {

	            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(this.find.getSchema(xmlPath)));

	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(xmlPath)));

	        } catch (IOException e){
	            System.out.println("Exception: "+ e.getMessage());
	            return false;
	        }catch(SAXException e1){
	            System.out.println("SAX Exception: "+ e1.getMessage());
	            return false;
	        }

	        return true;

	    }


}
