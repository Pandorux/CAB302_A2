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
		Truck truck = (Truck) testFactory.createTruck("Ordinary"); 
		assertTrue(truck != null);
	}
	
	@Test
	public void testCreateRefrigeratedTruck_00() {
		RefrigeratedTruck truck = (RefrigeratedTruck) testFactory.createTruck("Refrigerated"); 
		assertTrue(truck != null);
	}
	
}
