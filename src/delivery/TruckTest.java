package delivery;

import org.junit.*;


class TruckTest extends TruckBaseTest {
	
	@Before
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
