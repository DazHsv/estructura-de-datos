package me.hugosv.utils;


public class TestResult {
	private boolean passed;
	private String message;
	
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

	@Override
	public String toString() {
		return "TestResult {passed=" + this.passed + ", message=" + this.message + "}";
	}
	
}
