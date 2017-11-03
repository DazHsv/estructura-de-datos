package me.hugosv.piles.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.log4j.Logger;
import me.hugosv.piles.parser.objects.AnalysisResult;
import me.hugosv.piles.parser.objects.Brace;
import me.hugosv.piles.parser.objects.ObjectQuantity;

/**
 * BraceAnalyzer, checks if the given string have equal number of open braces and close braces.
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since Unidad 2
 * */
public class BraceAnalyzer {
	
	private static final Logger logger = Logger.getLogger(BraceAnalyzer.class);
	
	private final Character[] openBraces = {'(', '{', '['};
	private final Character[] closeBraces = {')', '}', ']'};
	private final Brace[] braces;
	
	public BraceAnalyzer() {
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
		logger.trace("CONSTRUCTOR: Finished initialization");
	}
	
	/**
	 * Analyze the given string to ensure that is balanced.
	 * 
	 * @param target The string to be analyzed.
	 * @return An object that contains the analyze results.
	 * @author Hugo Sanchez V
	 * @since BraceAnalyzer 1.0.0
	 * */
	public AnalysisResult<ObjectQuantity> analyze(String target) {
		logger.info("METHOD: Starting method - analyze");
		Stack<Character> toClose = new Stack<Character>();
		Stack<Character> toOpen = new Stack<Character>();
		
		/* Example
		 * ...[] ...{...
		 * ...(... {
		 *   ...(...])...
		 * }
		 *  open  = {, (, {
		 *  close = ]
		 *  
		 *  ) = 1
		 *  } = 1
		 *  [ = 1
		 * */
		logger.debug("- Starting target analize");
		for (Character c : target.toCharArray()) {
			logger.trace(" - Analyzing character: " + c);
			if(isCharacterIn(c, openBraces)) {
				logger.trace("  - Open brace found");
				toClose.push(c);
				logger.trace("  - Pushed brace to toClose stack");
			} else if (isCharacterIn(c, closeBraces)) {
				logger.trace("  - Close brace found");
				Character openBrace = this.getOpposite(c);
				logger.trace("  - Open brace match: " + openBrace);
				if(toClose.contains(openBrace)) {
					logger.trace("   - Found " + openBrace + " in open stack");
					toClose.remove(openBrace);					
					logger.trace("   - Brace removed from toClose stack");
				} else {
					logger.trace("   - Open brace not in toClose stack");
					toOpen.push(c);
					logger.trace("   - Close brace pushed to toOpen stack");
				}
			}
		}
		logger.debug("- Target analized");
		logger.debug("- Generating results");
		AnalysisResult<ObjectQuantity> analysisResult = new AnalysisResult<ObjectQuantity>();
		if(toClose.isEmpty() && toOpen.isEmpty()) {
			logger.debug(" - Target passed");
			analysisResult.setPassed(true);
			analysisResult.setMessage("String is balanced.");
		} else {
			logger.warn(" - Target not passed");
			analysisResult.setMessage("String unbalanced.");
			logger.debug(" - Adding results");
			List<ObjectQuantity> results = this.countResults(toClose, toOpen);
			analysisResult.setResults(results);
		}
		logger.info("METHOD: Ending method - analyze");
		return analysisResult;
	}
	
	/**
	 * Counts how many open and close braces where left.
	 * 
	 * @param open An stack with the open braces left.
	 * @param close An stack with the close left braces.
	 * @return A list that contains how many braces where left.
	 * @author Hugo Sanchez V
	 * @since BraceAnalyzer 1.0.0
	 * */
	private List<ObjectQuantity> countResults(Stack<Character> open, Stack<Character> close) {
		logger.info("METHOD: Starting method - countResults");
		List<ObjectQuantity> results = new ArrayList<ObjectQuantity>();
		for (Brace brace : braces) {
			Character openBrace = brace.getOpen();
			Character closeBrace = brace.getClose();
			
			logger.trace(" - Creating open braces results for: " + openBrace);
			ObjectQuantity openQuantity = new ObjectQuantity(closeBrace);
			openQuantity.searchAndIncrement(openBrace, open);
			if(openQuantity.getQuantity() > 0)
				results.add(openQuantity);
			
			logger.trace(" - Creating close braces results for: " + closeBrace);
			ObjectQuantity closeQuantity = new ObjectQuantity(openBrace);			
			closeQuantity.searchAndIncrement(closeBrace, close);
			if(closeQuantity.getQuantity() > 0)
				results.add(closeQuantity);
		}
		logger.info("METHOD: Ending method - countResults");
		return results;
	}
	
	/**
	 * Checks if the given character is in the given array.
	 * 
	 * @param c The character to find.
	 * @param braceType An array that contains the posibles matches.
	 * @author Hugo Sanchez V
	 * @since BraceAnalyzer 1.0.0
	 * */
	private boolean isCharacterIn(Character c, Character[] braceType) {
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
	
	/**
	 * Gets the opposite character of the given one.
	 * 
	 * @param c The character to get opposite.
	 * @return The opposite character.
	 * @author Hugo Sanchez V
	 * @since BraceAnalyzer 1.0.0
	 * */
	private Character getOpposite(Character c) {
		Character opposite = null;
		for (Brace brace : braces) {
			if(brace.getClose() == c) {
				opposite = brace.getOpen();
				break;
			}
		}
		return opposite;
	}
}
