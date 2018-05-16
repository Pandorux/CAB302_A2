package store;

public class StockException extends Exception {
	
	private String issue;
	
	StockException(String issue) {
		this.issue = issue;
	}
	
	public void PrintException() {
		System.out.println("StockException Thrown: "+ issue);
	}
	
}
