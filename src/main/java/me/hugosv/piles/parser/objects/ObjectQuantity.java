package me.hugosv.piles.parser.objects;

import java.util.Stack;
import org.apache.log4j.Logger;

/**
 * An object that contains how many of the given char are.
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since BraceAnalyzer 1.0.0
 * */
public class ObjectQuantity {
	
	private static final Logger logger = Logger.getLogger(ObjectQuantity.class);
	
	private final Character brace;
	private int quantity;

	/**
	 * Initialize the object with the given char.
	 * 
	 * @param brace The char to store.
	 * */
	public ObjectQuantity(Character brace) {
		this.quantity = 0;
		this.brace = brace;
	}

	/**
	 * @return This object char.
	 * */
	public Character getBrace() {
		return brace;
	}
	
	/**
	 * @return This char amount.
	 * */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * */
	public void searchAndIncrement(Character target, Stack<Character> stack) {
		logger.debug("METHOD: Starting method - searchAndIncrement");
		for (Character c : stack) {
			if(c == target) {
				this.quantity++;
			}
		}
	}
}