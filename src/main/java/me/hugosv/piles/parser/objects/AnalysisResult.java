package me.hugosv.piles.parser.objects;

import java.util.List;

/**
 * An object that is used for storing analysis results.
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since BraceAnalyzer 1.0.0
 * */
public class AnalysisResult<T> {
	private boolean passed;
	private String message;
	private List<T> results;
	
	/**
	 * @return Return the analysis status.
	 * */
	public boolean getPassed() {
		return passed;
	}
	
	/**
	 * @param passed The status of the analysis.
	 */
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	/**
	 * @return An optional message of the analysis.
	 * */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message An optional message.
	 * */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return A list with the analysis results.
	 * */
	public List<T> getResults() {
		return results;
	}
	
	/**
	 * @param results The analysis results.
	 * */
	public void setResults(List<T> results) {
		this.results = results;
	}
}