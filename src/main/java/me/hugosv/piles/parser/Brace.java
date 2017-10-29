package me.hugosv.piles.parser;


public class Brace {
	private final Character open;
	private final Character close;
	
	public Brace(Character open, Character close) {
		super();
		this.open = open;
		this.close = close;
	}
	
	public Character getOpen() {
		return open;
	}

	
	public Character getClose() {
		return close;
	}
}