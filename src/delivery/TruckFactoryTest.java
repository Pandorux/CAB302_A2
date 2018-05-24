package delivery;

import static org.junit.Assert.assertTrue;
import org.junit.*;

class TruckFactoryTest {
	
	public TruckFactory testFactory;
	
	@Before
	void beforeEachTest() {
		testFactory = new TruckFactory();
	}
	
	@Test
	void testCreateOrdinaryTruck_00() {
		Truck truck = testFactory.createTruck("Ordinary", 1000); 
		assertTrue(truck != null);
	}
	
	@Test
	void testCreateRefrigeratedTruck_00() {
		RefrigeratedTruck truck = testFactory.createTruck("Refrigerated", 1000); 
		assertTrue(truck != null);
	}
	
}
