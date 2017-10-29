package me.hugosv.piles.parser;

import java.util.Scanner;
import org.apache.log4j.Logger;
import me.hugosv.recursive.utils.Input;

public class MainParser {
	
	private static final Logger logger = Logger.getLogger(MainParser.class);

	public static void main(String[] args) {
		logger.info("METHOD: Starting method - main");
		Scanner s = Input.getInstance();
		ParentesisParser parentesisParser = new ParentesisParser();
		System.out.print("String: ");
		String str = s.nextLine();
		
		logger.trace("- Prepare to analyze string");
		AnalyzeResult result = parentesisParser.analyze(str);
		logger.trace("- String analyzed");
		logger.trace("- Printing results");
		System.out.println(result.getMessage());
		if(!result.getPassed()) {
			System.out.println("Faltantes:");
			for (ResultQuantity resultQuantity : result.getResults()) {
				System.out.println(resultQuantity.getBrace() + ": " + resultQuantity.getQuantity());
			}
		}
		
		if(s != null) {
			logger.debug("- Closing Scanner...");
			s.close();	
		}
		logger.info("METHOD: Ending method - main");
	}
}
