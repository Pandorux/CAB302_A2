package exceptions;

public class CSVFormatException extends Exception {

	private String issue;
	
	public CSVFormatException(String issue) {
		this.issue = issue;
	}
	
	public CSVFormatException() { }
	
	public void PrintException() {
		System.out.println("CSVFormatException Thrown: "+ issue);
	}
	
}
