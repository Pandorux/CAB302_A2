package delivery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TruckFactoryTest {
	
	public TruckFactory testFactory;
	
	@BeforeAll
	void beforeEachTest() {
		testFactory = new TruckFactory();
	}
	
	@Test
	void testCreateOrdinaryTruck_00() {
		Truck truck = testFactory.CreateTruck("Ordinary", 1000); 
		assertTrue(truck != null);
	}
	
	@Test
	void testCreateRefrigeratedTruck_00() {
		RefrigeratedTruck truck = testFactory.CreateTruck("Refrigerated", 1000); 
		assertTrue(truck != null);
	}
	
}
