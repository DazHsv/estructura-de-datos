package me.hugosv.piles.parser.objects;

import java.util.List;

public class AnalyzeResult {
	private boolean passed;
	private String message;
	private List<ResultQuantity> results;
	
	public boolean getPassed() {
		return passed;
	}
	
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<ResultQuantity> getResults() {
		return results;
	}
	
	public void setResults(List<ResultQuantity> results) {
		this.results = results;
	}
}