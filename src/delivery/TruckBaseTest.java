package delivery;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

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
		
		// id, capacity
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
	void testTruckRemoveItem_Item() {
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(false, dummyTruck.getItem(item));
	}
	
	@Test
	void testTruckRemoveItem_Name() {
		dummyTruck.addItems(new DummyItem("Milk", 0));
		dummyTruck.removeItem("Milk");
		assertEquals(null, dummyTruck.getItem("Milk"));
	}
	
	@Test
	void testTruckAddItem() {
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItem(item));
	}
	
	@Test
	void testTruckGetItems_Name() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Iterator i = items.iterator(); i.hasNext();) {
			i.next();
			if(i.name == "Milk") {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, dummyTruck.getItems("Milk").length);
	}
	
	// TODO: Fix GetItem Name
	@Test
	void testTruckGetItems_TempEqual() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Iterator i = items.iterator(); i.hasNext();) {
			i.next();
			if(i.temp == -20) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, dummyTruck.getItems(-20).length);
	}
	
	// TODO: Fix GetItem Name
	@Test
	void testTruckGetItems_TempLessOf() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Iterator i = items.iterator(); i.hasNext();) {
			i.next();
			if(i.temp <= 0) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, dummyTruck.getItems(-20).length);
	}
	
	// TODO: Fix GetItem Name
	@Test
	void testTruckGetItems_TempMoreThan() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Iterator i = items.iterator(); i.hasNext();) {
			i.next();
			if(i.temp >= 0) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, dummyTruck.getItems(-20).length);
	}
	
	@Test
	void testTruckGetItem_Name() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItem("Milk"));
	}
	
	@Test
	void testTruckGetItem_Temp() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItem(0));
	}
	
	@Test
	void testTruckGetItem_Item() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItem(item));
	}
	
	@Test
	void testTruckRemoveItems_Items() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(items);
		assertEquals(0, dummyTruck.totalItems);
	}
	
	@Test
	void testTruckRemoveItems_Name() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems("Milk");
		
		assertEquals(null, dummyTruck.getItem("Milk"));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	void testTruckRemoveItems_TempEqual() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	void testTruckRemoveItems_TempLessThan() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	void testTruckRemoveItems_TempMoreThan() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	@Test
	void testTruckEmptyTruck() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.empty();
		
		assertEquals(0, dummyTruck.totalItems);
	}
	
	@Test(expected = DeliveryException.class)
	void testCapacityCannotExceedMax() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(2000);
	}
}
