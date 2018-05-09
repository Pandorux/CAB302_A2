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

import javafx.util.Pair;
import store.Item;

/**
 * 
 * @author Jared Carey
 *
 */
abstract class TruckBaseTest {
	
	TruckBase dummyTruck = null;
	DummyCargoCreator cargoMaker = new DummyCargoCreator();
	
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
	 * Mock of Item
	 * 
	 */
	public class DummyItem extends Item {
		
		String name;
		double temp;
		
		DummyItem(String name, double temp) {
			this.name = name;
			this.temp = temp;
		}
		
	}
	
	/**
	 * 
	 * @author Jared Carey
	 * 
	 * Class used for creating dynamic dummy cargo for unit tests
	 *
	 */
	public class DummyCargoCreator {
		
		public ArrayList<DummyItem> CreateCargo(int amount) {
			
			ArrayList<DummyItem> cargo = new ArrayList<DummyItem>();
			Pair<String, Integer> item;
			DummyItem dummy;
			
			for(int i = 0; i < amount; i++) {
				item = GetItem();
				dummy = new DummyItem(item.getKey(), item.getValue());
				cargo.add(dummy);    
			}
			
			return cargo;
		}
		
		private Pair<String, Integer> GetItem() {
			Random rand = new Random();
			
			switch(rand.nextInt(2)) {

				case 0:
					return new Pair<String, Integer>("Milk", -20);
					
				case 1:
					return new Pair<String, Integer>("Bread", 20);
					
				case 2:
					return new Pair<String, Integer>("Eggs", 6);
					
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
	void testTruckCost_Empty() {
		assertEquals((750), dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_01() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(1000);
		dummyTruck.addItems(items);
		assertEquals((750 + 0.25 * 1000), dummyTruck.getCost());
	}
	
	@Test
	void testTruckCost_02() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(5000);
		dummyTruck.addItems(items);
		assertEquals((750 + 0.25 * 5000), dummyTruck.getCost());
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
