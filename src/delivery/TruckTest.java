package delivery;

import org.junit.*;


public class TruckTest extends TruckBaseTest {
	
	@Before
	public void beforeEachTest() {
		// id, capacity
		dummyTruck = new Truck(0, 1000);	
	}
	
	// TODO: Name of GetItems should be TempLessThan
	@Test
	public void testCargoIsOnlyDryItems() {
		dummyTruck.getItems(10);
	}

}
