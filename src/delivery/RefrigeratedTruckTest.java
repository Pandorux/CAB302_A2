package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jared Carey
 *
 */
class RefrigeratedTruckTest extends TruckBaseTest {
	
	@BeforeAll
	void beforeEachTest() {
		dummyTruck = new RefrigeratedTruck(0, 1000);	
	}
	
	@Test
	void testTemperatureStaysInRange() {
		fail("Not yet implemented");
	}
	
	// TODO: Need to check if this is a new method
	@Test
	void testTruckCost() {
		// TODO: Check if tester returns the correct cost
	}
	
	@Test
	void testItemsInTemperatureRange() {
		// TODO: Check if every item in collection is in
		//		 the temperature range
	}
}
