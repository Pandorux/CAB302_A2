package io;

public class CSVFormatException extends Exception {

	private String issue;
	
	CSVFormatException(String issue) {
		this.issue = issue;
	}
	
	public void PrintException() {
		System.out.println("CSVFormatException Thrown: "+ issue);
	}
	
}
