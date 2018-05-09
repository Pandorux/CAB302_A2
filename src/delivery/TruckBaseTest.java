package delivery;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import store.Item;

/**
 * 
 * @author Jared Carey
 *
 */
abstract class TruckBaseTest {
	
	TruckBase dummyTruck = null;
	
	
	/**
	 * 
	 * @author Jared Carey
	 *
	 * Mock Class for testing the abstract class TruckBase
	 *
	 */
	private class dummyTruckBase extends TruckBase { 
		
		dummyTruckBase(int id, int capacity) {
			super(int id, int capacity);
		}
	}
	
	/**
	 * 
	 * @author Jared Carey
	 *
	 * Enumerated Mock of Item
	 * 
	 */
	static enum DummyItem {
		MILK(4.0),
		BREAD(2.0),
		EGGS(6.0),
		CEREAL(10.5),
		WATER(0.75),
		RICE(3.6),
		BACON(45.2);
		
		private double cost;

		DummyItem(double cost) {
			this.cost = cost;
		}
		
		public double getCost() {
			return cost;
		}	
	}
	
	/**
	 * 
	 * @author Jared Carey
	 * 
	 * Class used for creating dynamic dummy cargo for unit tests
	 *
	 */
	public static class DummyCargoCreator {
		
		public static ArrayList<DummyItem> CreateCargo(int amount) {
			
			ArrayList<DummyItem> cargo = new ArrayList<DummyItem>();
			
			for(int i = 0; i < amount; i++) {
				cargo.add(GetItem());
			}
			
			return cargo;
		}
		
		private static DummyItem GetItem() {
			Random rand = new Random();
			
			switch(rand.nextInt(DummyItem.values().length)) {
				case 0:
					return DummyItem.MILK;
					
				case 1:
					return DummyItem.BREAD;
					
				case 2:
					return DummyItem.EGGS;
					
				case 3:
					return DummyItem.CEREAL;
					
				case 4:
					return DummyItem.WATER;
					
				case 5:
					return DummyItem.RICE;
					
				case 6:
					return DummyItem.BACON;
			}
			
			return null;
			
		}
	}
	
	@BeforeAll
	void beforeEachTest() {
		dummyTruck = new dummyTruckBase(0, 1000);	
	}
	
	@Test
	void testGetCapacity_00() {
		assertEquals(1000, dummyTruck.capacity);
	}
	
	@Test
	void testGetCapacity_01() {
		dummyTruck.capacity(34567);
		assertEquals(34567, dummyTruck.capacity);
	}
	
	@Test
	void testTruckCost_00() {
		assertEquals(1000, dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_01() {
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
