package delivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import exceptions.DeliveryException;
import javafx.util.Pair;
import store.Item;

/**
 * 
 * JUnit Test Case for the functionality held within the 
 * abstract class TruckBase.
 * 
 * @author Jared Carey
 *
 */
public class TruckBaseTest {
	
	TruckBase dummyTruck = null;
	DummyCargoCreator cargoMaker = new DummyCargoCreator();
	
	/**
	 * 
	 * Mock Class for testing the abstract class TruckBase
	 * 
	 * @author Jared Carey
	 *
	 */
	protected class dummyTruckBase extends TruckBase { 
		
		dummyTruckBase(int capacity) {
			super(capacity);
		}
		
		dummyTruckBase() {
			super();
		}
	}
	
	/**
	 * 
	 * Mock class of Item
	 * 
	 * @author Jared Carey
	 *
	 */
	protected class DummyItem extends Item {
		
		DummyItem(String name, double temperature) {
			super(name, 0.0, 0.0, "NoneOfYourBusiness", 0, temperature);
		}
		
	}
	
	/**
	 * 
	 * @author Jared Carey
	 * 
	 * Class used for creating dynamic dummy cargo for unit tests
	 *
	 */
	protected class DummyCargoCreator {
		
		public ArrayList<Item> CreateCargo(int amount) {
			
			ArrayList<Item> cargo = new ArrayList<Item>();
			Pair<String, Integer> item;
			DummyItem dummy;
			
			for(int i = 0; i < amount; i++) {
				item = GetItem();
				dummy = new DummyItem(item.getKey(), item.getValue());
				cargo.add(dummy);    
			}
			
			return cargo;
		}
		
		protected Pair<String, Integer> GetItem() {
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
	
	@Before
	public void beforeEachTest() {
		dummyTruck = new dummyTruckBase();	
	}
	
	@Test // Double Check Test Functionality
	public void testTruckId_00() {
		assertTrue(1 == dummyTruck.getId());
	}
	
	@Test // Double Check Test Functionality
	public void testTruckId_01() {
		dummyTruckBase dummy00 = new dummyTruckBase();
		dummyTruckBase dummy01 = new dummyTruckBase();
		assertTrue(3 == dummy01.getId());
	}
	
	@Test
	public void testGetCapacity_00() {
		assertTrue(1000 == dummyTruck.getCapacity());
	}
	
	@Test
	public void testGetCapacity_01() {
		dummyTruck = new dummyTruckBase(34567);
		assertTrue(34567 == dummyTruck.getCapacity());
	}
	
	@Test
	public void testTruckCost_Empty() {
		assertTrue((750) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_01() {
		ArrayList<Item> items = cargoMaker.CreateCargo(1000);
		dummyTruck.addItems(items);
		assertTrue((750 + 0.25 * 1000) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_02() {//this is gonna error coz the max capasity for a normal truck is 1000 not 5000
		ArrayList<Item> items = cargoMaker.CreateCargo(5000);
		dummyTruck.addItems(items);
		assertTrue((750 + 0.25 * 5000) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckRemoveItem_Item() {
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.removeItem(item);
		assertTrue(false == dummyTruck.getItems(item));
	}
	
	@Test
	public void testTruckRemoveItem_Name() {
		dummyTruck.addItems(new DummyItem("Milk", 0));
		dummyTruck.removeItems("Milk");
		assertTrue(null == dummyTruck.getItems("Milk"));
	}
	
	@Test
	public void testTruckAddItem() {
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertTrue(item == dummyTruck.getItems(item).get(0));
	}
	
	@Test
	public void testTruckGetItems_Name() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Item i: items) {
			if(i.getName() == "Milk") {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, dummyTruck.getItems("Milk").size());
	}
	
	// TODO: Fix GetItem Name
	@Test
	public void testTruckGetItems_TempEqual() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Item i: items) {
			if(i.getTemperature() == -20) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, (dummyTruck.getItemsWithTemp(-20)).size());
	}
	
	// TODO: Fix GetItem Name
	@Test
	public void testTruckGetItems_TempLessOf() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Item i: items) {
			if(i.getTemperature() <= 0) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, (dummyTruck.getItemsWithTempUnder(-20)).size());
	}
	
	// TODO: Fix GetItem Name
	@Test
	public void testTruckGetItems_TempMoreThan() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		int totalItems = 0;
		
		for(Item i: items) {
			if(i.getTemperature() >= 0) {
				totalItems++;
			}
		}
		
		assertEquals(totalItems, (dummyTruck.getItemsWithTempOver(-20)).size());
	}
	
	@Test
	public void testTruckGetItem_Name() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItems("Milk"));
	}
	
	@Test
	public void testTruckGetItem_Temp() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItems(0));
	}
	
	@Test
	public void testTruckGetItem_Item() {
		// TODO: Get one item from truck cargo that mets a certain criteria (name, temperature, etc)
		DummyItem item = new DummyItem("Milk", 0);
		dummyTruck.addItems(item);
		assertEquals(item, dummyTruck.getItems(item));
	}
	
	@Test
	public void testTruckRemoveItems_Items() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(items);
		assertTrue(0 == dummyTruck.getTotalItems());
	}
	
	@Test
	public void testTruckRemoveItems_Name() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems("Milk");
		
		assertEquals(null, dummyTruck.getItem("Milk"));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	public void testTruckRemoveItems_TempEqual() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	public void testTruckRemoveItems_TempLessThan() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	// TODO: Fix GetItem and RemoveItems Name
	@Test
	public void testTruckRemoveItems_TempMoreThan() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.removeItems(-20);
		assertEquals(null, dummyTruck.getItem(-20));
	}
	
	@Test
	public void testTruckEmptyTruck() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
		dummyTruck.empty();
		assertTrue(0 == dummyTruck.getTotalItems());
	}
	
	@Test(expected = DeliveryException.class)
	public void testCapacityCannotExceedMax() {
		ArrayList<Item> items = cargoMaker.CreateCargo(2000);
		dummyTruck.addItems(items);
	}
}
