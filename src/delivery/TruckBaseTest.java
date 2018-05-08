package delivery;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import store.Item;

/**
 * 
 * @author Jared Carey
 *
 */
class TruckBaseTest {
	
	/**
	 * 
	 * @author Jared Carey
	 *
	 */
	class dummyTruckBase extends TruckBase { 
		
		dummyTruckBase(int id, int capacity) {
			super(id, capacity);
		}
	}
	
	TruckBase dummyTruck = null;
	
	@Before
	void beforeEachTest() {
		dummyTruck = new TruckBase(0, 1000);	
	}
	
	@Test
	void testGetCapacity_00() {
		assertEquals(1000, dummyTruck.getMaxCargo());
	}
	
	@Test
	void testSetCapacity() {
		dummyTruck.setMaxCargo(2000);
		assertEquals(2000, dummyTruck.getMaxCargo());
	}
	
	@Test
	void testGetCapacity_01() {
		dummyTruck.setMaxCargo(34567);
		assertEquals(34567, dummyTruck.getMaxCargo());
	}
	
	@Test
	void testTruckCost_00() {
		dummyTruck.setMaxCargo(1000);
		assertEquals(1000, dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_01() {
		dummyTruck.setMaxCargo(5000);
		assertEquals(2000, dummyTruck.getCost());
	}
	
	@Test
	void testTruckRemoveItem_00() {
		dummyTruck.removeItem(item);
		assertEquals(false, dummyTruck.getItem(item));
	}
	
	@Test
	void testTruckRemoveItem_01() {
		dummyTruck.removeItem(itemName);
		assertEquals(false, dummyTruck.getItem(itemName));
	}
	
	@Test
	void testTruckAddItem_00() {
		dummyTruck.addItem(item);
		assertEquals(true, dummyTruck.getItem(item));
	}
	
	@Test
	void testTruckGetItem() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
	}
	
	@Test
	void testTruckGetItems() {
		// TODO: Get all items from truck cargo that mets a certain criteria (name, temperature, etc)
	}
	
	@Test
	void testTruckRemoveItems() {
		// TODO: Input collection of items to remove from truck cargo
	}
	
	@Test
	void testTruckAddItems() {
		// TODO: Input collection of items to add to truck cargo
	}
	
	@Test
	void testTruckRemoveAllItems() {
		// TODO: Reset Truck Cargo
	}
	
	@Test
	void testCapacityCannotExceedMax() {
		// TODO: An exception should be thrown if
		//   	 max is exceeded
	}
}
