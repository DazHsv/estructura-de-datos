package me.hugosv.piles.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import org.apache.log4j.Logger;
import me.hugosv.recursive.utils.Input;

public class ParentesisParser {
	
	private static final Logger logger = Logger.getLogger(ParentesisParser.class);
	
	private final Character[] openBraces = {'(', '{', '['};
	private final Character[] closeBraces = {')', '}', ']'};
	private final Brace[] braces;
	
	public ParentesisParser() {
		logger.trace("CONSTRUCTOR: Initializing Parser");
		Integer length = this.openBraces.length;
		logger.trace(" - length: " + length);
		this.braces = new Brace[length];
		for (int i = 0; i < length; i++) {
			Character open = this.openBraces[i];
			Character close = this.closeBraces[i];
			logger.trace("- Adding characters: " + open + " " + close);
			this.braces[i] = new Brace(open, close);
		}
		logger.trace("CONTRUCTOR: Finished initialization");
	}
	
	public AnalyzeResult analyze(String target) {
		logger.info("METHOD: Starting method - analyze");
		Stack<Character> open = new Stack<Character>();
		Stack<Character> close = new Stack<Character>();
		
		/* Example
		 * ...[] ...{...
		 * ...(... {
		 *   ...(...])...
		 * }
		 *  open  = {, (, {
		 *  close = ]
		 *  
		 *  ( = 1
		 *  { = 2
		 *  ] = 1
		 * */
		logger.debug("- Starting target analize");
		for (Character c : target.toCharArray()) {
			logger.trace(" - Analyzing character: " + c);
			if(isCharacterIn(c, openBraces)) {
				logger.trace("  - Open brace found");
				open.push(c);
				logger.trace("  - Pushed brace to open stack");
			} else if (isCharacterIn(c, closeBraces)) {
				logger.trace("  - Close brace found");
				for (Brace brace : braces) {
					if(c == brace.getClose()) {
						Character openBrace = brace.getOpen();
						logger.trace("  - Open brace match: " + openBrace);
						if(open.contains(openBrace)) {
							logger.trace("   - Found " + openBrace + " in open stack");
							open.remove(openBrace);						
							logger.trace("   - Brace removed from open stack");
						}
						else {
							logger.trace("   - Open brace not in open stack");
							close.push(c);
							logger.trace("   - Close brace pushed to close stack");
						}
					}
				}
			}
		}
		
		logger.debug("- Generating results");
		AnalyzeResult analyzeResult = new AnalyzeResult();
		if(open.isEmpty() && close.isEmpty()) {
			logger.debug(" - Target passed");
			analyzeResult.setPassed(true);
			analyzeResult.setMessage("String is balanced.");
		} else {
			logger.debug(" - Target not passed");
			analyzeResult.setMessage("String unbalanced.");
			logger.trace(" - Adding results");
			List<ResultQuantity> results = this.countResults(open, close);
			analyzeResult.setResults(results);
		}
		logger.info("METHOD: Ending method - analyze");
		return analyzeResult;
	}
	
	private List<ResultQuantity> countResults(Stack<Character> open, Stack<Character> close) {
		logger.info("METHOD: Starting method - countResults");
		List<ResultQuantity> results = new ArrayList<ResultQuantity>();
		for (Brace brace : braces) {
			Character openBrace = brace.getOpen();
			Character closeBrace = brace.getClose();
			
			logger.trace(" - Creating open braces results for: " + openBrace);
			ResultQuantity openQuantity = new ResultQuantity(closeBrace);
			openQuantity.searchAndIncrement(openBrace, open);
			if(openQuantity.getQuantity() > 0)
				results.add(openQuantity);
			
			logger.trace(" - Creating close braces results for: " + closeBrace);
			ResultQuantity closeQuantity = new ResultQuantity(openBrace);			
			closeQuantity.searchAndIncrement(closeBrace, close);
			if(closeQuantity.getQuantity() > 0)
				results.add(closeQuantity);
		}
		logger.info("METHOD: Ending method - countResults");
		return results;
	}
	
	private Boolean isCharacterIn(Character c, Character[] braceType) {
		logger.debug("METHOD: Starting method - isCharacterIn");
		logger.trace(" - c: " + c);
		for (Character brace : braceType) {
			if(c == brace) {
				logger.debug("METHOD: Ending method - isCharacterIn: true");
				return true;
			}
		}
		logger.debug("METHOD: Ending method - isCharacterIn: false");
		return false;
	}
		
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
