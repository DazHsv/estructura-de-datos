package me.hugosv.piles.parser.objects;

import java.util.Stack;
import org.apache.log4j.Logger;

public class ResultQuantity {
	
	private static final Logger logger = Logger.getLogger(ResultQuantity.class);
	
	private final Character brace;
	private int quantity;

	public ResultQuantity(Character brace) {
		this.quantity = 0;
		this.brace = brace;
	}

	public Character getBrace() {
		return brace;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void searchAndIncrement(Character target, Stack<Character> stack) {
		logger.debug("METHOD: Starting method - searchAndIncrement");
		for (Character c : stack) {
			if(c == target) {
				this.quantity++;
			}
		}
	}
}