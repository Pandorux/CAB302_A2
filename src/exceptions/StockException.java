package exceptions;

public class StockException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String issue;
	
	public StockException(String issue) {
		this.issue = issue;
	}
	
	public StockException() { }
	
	public void PrintException() {
		System.out.println("StockException Thrown: "+ issue);
	}
	
}
