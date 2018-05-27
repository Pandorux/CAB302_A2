package exceptions;

public class StockException extends RuntimeException {
	
	private String issue;
	
	public StockException(String issue) {
		this.issue = issue;
	}
	
	public void PrintException() {
		System.out.println("DeliveryException Thrown: " + issue);
	}
	
}
