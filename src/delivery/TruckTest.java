package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TruckTest extends TruckBaseTest {
	
	@BeforeAll
	void beforeEachTest() {
		// id, capacity
		dummyTruck = new Truck(0, 1000);	
	}
	
	// TODO: Name of GetItems should be TempLessThan
	@Test
	void testCargoIsOnlyDryItems() {
		dummyTruck.getItems(10);
	}

}
