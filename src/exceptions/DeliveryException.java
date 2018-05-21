package exceptions;

public class DeliveryException extends Exception {

	private String issue;
	
	DeliveryException(String issue) {
		this.issue = issue;
	}
	
	public void PrintException() {
		System.out.println("DeliveryException Thrown: "+ issue);
	}
	
}
