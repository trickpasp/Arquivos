package br.com.exemplo.tabula;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.pdfbox.pdmodel.PDDocument;

import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.writers.CSVWriter;

public class PDF {
	private Properties prop;
	public PDF() {
		prop = new Properties();
	}

	public void gerarCsv(String pdfPath, int numberPage, float top, float left, float bottom, float right) {
		  try {
	            PDDocument document = PDDocument.load(new File(pdfPath));
	            ObjectExtractor oe = new ObjectExtractor(document);
	            Page page = oe.extract(numberPage);//numero da pagina que vai extrair
	            //page.getArea();
	            
	           
	            BasicExtractionAlgorithm bea = new BasicExtractionAlgorithm();
	            									  //top, left, bottom, right
	            Table table = bea.extract(page.getArea(top, left, bottom, right)).get(0);
	     
	            
	            CSVWriter pp = new CSVWriter();
	            prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
	            pp.write(new PrintStream(prop.getProperty("pdf_csv")), table);
	            oe.close();
	        }catch (Exception e) {
	        		e.printStackTrace();
	        }
	}
	public void gerarCsv(String pdfPath, int numberPage) {
		  try {
	            PDDocument document = PDDocument.load(new File(pdfPath));
	            ObjectExtractor oe = new ObjectExtractor(document);
	            Page page = oe.extract(numberPage);//numero da pagina que vai extrair
	            //page.getArea();
	            
	           
	            BasicExtractionAlgorithm bea = new BasicExtractionAlgorithm();
	            									  //top, left, bottom, right
	            Table table = bea.extract(page).get(0);
	     
	            
	            CSVWriter pp = new CSVWriter();
	            prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
	            pp.write(new PrintStream(prop.getProperty("pdf_csv")), table);
	            oe.close();
	        }catch (Exception e) {
	        		e.printStackTrace();
	        }
	}
}
