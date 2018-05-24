package delivery;

import static org.junit.Assert.assertTrue;
import org.junit.*;

public class TruckFactoryTest {
	
	public TruckFactory testFactory;
	
	@Before
	public void beforeEachTest() {
		testFactory = new TruckFactory();
	}
	
	@Test
	public void testCreateOrdinaryTruck_00() {
		Truck truck = testFactory.createTruck("Ordinary", 1000); 
		assertTrue(truck != null);
	}
	
	@Test
	public void testCreateRefrigeratedTruck_00() {
		RefrigeratedTruck truck = testFactory.createTruck("Refrigerated", 1000); 
		assertTrue(truck != null);
	}
	
}
