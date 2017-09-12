package br.com.exemplo.sax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.exemplo.model.Fornecedor;

public class FornecedorSax extends DefaultHandler {

	private String tempVal;
	private Fornecedor tempForn;
	private List<Fornecedor> listFornecedor;
	private PrintStream print;
	private Properties prop;
	
	public FornecedorSax() {
		listFornecedor = new ArrayList<Fornecedor>();
		prop = new Properties();
	}
	
	public void parseDocument() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
			SAXParser sp = spf.newSAXParser();
			sp.parse(prop.getProperty("forn_xml"), this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// reset
		tempVal = "";
		if (qName.equalsIgnoreCase("resource")) {
			// create a new instance of employee
			
			tempForn = new Fornecedor();			
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("resource")) {			
			listFornecedor.add(tempForn);
		} else if (qName.equalsIgnoreCase("id")) {			
			tempForn.setId(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("cnpj") || qName.equalsIgnoreCase("cpf")) {
			tempForn.setCnpj(tempVal);
		}else if (qName.equalsIgnoreCase("nome")) {
			tempForn.setNome(tempVal);
		} else if (qName.equalsIgnoreCase("recadastrado")) {
			tempForn.setRecadastrado(Boolean.parseBoolean(tempVal));
		} else if (qName.equalsIgnoreCase("id_municipio")) {
			tempForn.setIdMunicipio(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("uf")) {
			tempForn.setUf(tempVal);
		} else if (qName.equalsIgnoreCase("id_natureza_juridica")) {
			tempForn.setIdNaturezaJuridica(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("id_porte_empresa")) {
			tempForn.setIdPorteEmpresa(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("id_ramo_negocio")) {
			tempForn.setIdRamoNegocio(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("id_unidade_cadastradora")) {
			tempForn.setIdUnidadeCadastradora(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("id_cnae")) {
			tempForn.setIdCnae(Integer.parseInt(tempVal));
		} else if (qName.equalsIgnoreCase("habilitado_licitar"))
			tempForn.setHabilitadoLicitar(Boolean.parseBoolean(tempVal));
	}

	public void extrairDados() throws IOException {
		parseDocument();
		prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
		print = new PrintStream(prop.getProperty("forn_csv"));
		for (Fornecedor fornecedor : listFornecedor) {
			print.println(fornecedor.toString());
		}
		
	}
	
	
}
