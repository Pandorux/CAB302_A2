package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import delivery.TruckBaseTest.TruckTester;

/**
 * 
 * @author Jared Carey
 *
 */
class RefrigeratedTruckTest extends TruckBaseTest {
	
	
	
	@Test
	void testTemperatureStaysInRange() {
		fail("Not yet implemented");
	}
	
	// TODO: Need to check if this is a new method
	@Test
	void testTruckCost() {
		TruckTester tester = new TruckTester();
		// TODO: Check if tester returns the correct cost
	}
	
	@Test
	void testItemsInTemperatureRange() {
		// TODO: Check if every item in collection is in
		//		 the temperature range
	}
}
