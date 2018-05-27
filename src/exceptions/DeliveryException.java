package exceptions;

public class DeliveryException extends RuntimeException {

	private String issue;
	
	public DeliveryException(String issue) {
		this.issue = issue;
	}
	
	public void PrintException() {
		System.out.println("DeliveryException Thrown: "+ issue);
	}
	
}
