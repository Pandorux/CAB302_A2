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
	
	@Test(expected = DeliveryExpection.class)
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
	void testTruckCost_00() {
		dummyTruck.addItems(cargoMaker.CreateCargo(500));
		assertEquals(900 + (0.25 * 500) * (Math.pow(0.7, dummyTruck.getTemp() / 5)), dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_01() {
		dummyTruck.addItems(cargoMaker.CreateCargo(1000));
		assertEquals(900 + (0.25 * 500) * (Math.pow(0.7, dummyTruck.getTemp() / 5)), dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_02() {
		dummyTruck.capacity = 2000;
		dummyTruck.addItems(cargoMaker.CreateCargo(2000));
		assertEquals(900 + (0.25 * 500) * (Math.pow(0.7, dummyTruck.getTemp() / 5)), dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_03() {
		dummyTruck.capacity = 5000;
		dummyTruck.addItems(cargoMaker.CreateCargo(5000));
		assertEquals(900 + (0.25 * 500) * (Math.pow(0.7, dummyTruck.getTemp() / 5)), dummyTruck.getCost());
	}
	
	@Test
	void testAddItemsInTempRange() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
	}
}
