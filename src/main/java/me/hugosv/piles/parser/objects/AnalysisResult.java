package me.hugosv.piles.parser.objects;

import java.util.List;
import me.hugosv.utils.TestResult;

/**
 * An object that is used for storing analysis results.
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since BraceAnalyzer 1.0.0
 * */
public class AnalysisResult<T> extends TestResult{
	private List<T> results;
	
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