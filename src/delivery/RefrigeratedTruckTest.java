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
		// id, capacity, temp
		dummyTruck = new RefrigeratedTruck(0, 800, 10);	
	}
	
	@Test(expected = DeliveryExpection.class)
	void testTemperatureStaysInRange_00() {
		dummyTruck.setTemperature(50);
	}
	
	@Test(expected = DeliveryExpection.class)
	void testTemperatureStaysInRange_01() {
		dummyTruck.setTemperature(-50);
	}
	
	@Test
	void testTemperatureStaysInRange_02() {
		dummyTruck.setTemperature(-50);
	}
	
	@Test(expected = DeliveryException.class)
	void testAddItemOutOfTempRange_00() {
		dummyTruck.addItem("Milk", 30);
	}
	
	@Test(expected = DeliveryException.class)
	void testAddItemOutOfTempRange_01() {
		dummyTruck.addItem("Milk", -30);
	}
	
	@Test
	void testTruckCost_Empty() {
		assertEquals(900, dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_Empty() {
		assertEquals(900, dummyTruck.getCost());
	}
	
	@Test
	void testAddItemsInTempRange() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
	}
}
