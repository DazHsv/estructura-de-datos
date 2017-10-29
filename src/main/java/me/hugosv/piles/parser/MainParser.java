package me.hugosv.piles.parser;

import java.util.Scanner;
import org.apache.log4j.Logger;
import me.hugosv.piles.parser.objects.AnalysisResult;
import me.hugosv.piles.parser.objects.ObjectQuantity;
import me.hugosv.recursive.utils.Input;

/**
 * Brace Analyzer - Main
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since Unidad 2
 * */
public class MainParser {

	private static final Logger logger = Logger.getLogger(MainParser.class);

	public static void main(String[] args) {
		logger.info("METHOD: Starting method - main");
		Scanner s = Input.getInstance();
		ParentesisParser parentesisParser = new ParentesisParser();
		System.out.print("String: ");
		String str = s.nextLine();
		Long startTime = System.currentTimeMillis();
		
		logger.trace("- Prepare to analyze string");
		AnalysisResult<ObjectQuantity> result = parentesisParser.analyze(str);
		logger.trace("- String analyzed");
		logger.trace("- Printing results");
		System.out.println(result.getMessage());
		if(!result.getPassed()) {
			System.out.println("Missing:");
			for (ObjectQuantity objectQuantity : result.getResults()) {
				System.out.println(objectQuantity.getBrace() + ": " + objectQuantity.getQuantity());
			}
		}
		
		logger.info("Parser took: " + (System.currentTimeMillis() - startTime) + " ms.");
		
		if(s != null) {
			logger.debug("- Closing Scanner...");
			s.close();	
		}
		logger.info("METHOD: Ending method - main");
	}
}
