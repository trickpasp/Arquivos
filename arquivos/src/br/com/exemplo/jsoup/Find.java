package br.com.exemplo.jsoup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Find {
	
	private Document doc;
	private Elements elem;
	private static PrintStream print;
	private Properties prop;
	
	public Find() {
		prop = new Properties();
	}
	
	public void procurarProdutos() {
		try {
			doc = Jsoup.connect("https://www.americanas.com.br/").get();
			elem = doc.select(".card-product-name");
			prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
			print = new PrintStream(prop.getProperty("ameri_csv")); 
			
			for (Element element : elem) {
				print.println(element.text());				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
