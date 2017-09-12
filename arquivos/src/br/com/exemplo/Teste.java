package br.com.exemplo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.exemplo.sax.FornecedorSax;

public class Teste {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		try {
			prop.setProperty("forn_xml", System.getProperty("user.home") + "/Downloads/fornecedores.xml");
			prop.setProperty("forn_csv", System.getProperty("user.home") + "/fornecedor.csv");
			prop.setProperty("ameri_csv", System.getProperty("user.home") + "/americanas.csv");
			prop.setProperty("xml_path", System.getProperty("user.home") + "/Downloads/studants.xml");
			prop.setProperty("pdf_path",
					System.getProperty("user.home") + "/Downloads/1462_TabeladeRemuneração2017.pdf");
			prop.setProperty("pdf_csv", System.getProperty("user.home") + "/pdf.csv");
			prop.store(new FileOutputStream(System.getProperty("user.home") + "/config.properties"), null);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// procurando produtos nas americanas
		// Find find = new Find();
		// find.procurarProdutos();
		//prop.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));

		//PDF pdf = new PDF();
		//pdf.gerarCsv(prop.getProperty("pdf_path"), 10);
		// prop.load(new FileInputStream(System.getProperty("user.home") +
		// "/config.properties"));
		// XSDValidator valid = new XSDValidator();
		// valid.verificar(prop.getProperty("xml_path"));
		// Utilizando o sax para extrair dados do xml
		FornecedorSax sa = new FornecedorSax();

		sa.extrairDados();

	}

}
