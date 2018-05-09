package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TruckTest extends TruckBaseTest {
	
	@BeforeAll
	void beforeEachTest() {
		dummyTruck = new Truck(0, 1000);	
	}
	
	@Test
	void testCargoIsOnlyDryItems() {
		fail("Not yet implemented");
		
		// TODO: Check if every item in collection is a dry item
		// Test fails if there is a wet item in cargo
		
	}

}
