package me.hugosv.piles.parser.objects;

/**
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since BraceAnalyzer 1.0.0
 * */
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