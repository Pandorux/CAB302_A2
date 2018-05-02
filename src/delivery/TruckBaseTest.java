package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jared Carey
 *
 */
class TruckBaseTest {
	
	/**
	 * 
	 * @author Jared Carey
	 *
	 */
	class TruckTester extends TruckBase { }
	
	@Test
	void testTruckConstruction() {
		TruckTester tester = new TruckTester();
	}
	
	@Test
	void testCapacityCannotExceedMax() {
		TruckTester tester = new TruckTester();	
	}
	
	@Test
	void testTruckCost() {
		TruckTester tester = new TruckTester();
	}
	
	
}
