package exceptions;

public class CSVFormatException extends RuntimeException {

	private String issue;
	
	public CSVFormatException(String issue) {
		this.issue = issue;
	}
	
	public CSVFormatException() { }
	
	public void PrintException() {
		System.out.println("CSVFormatException Thrown: "+ issue);
	}
	
}
