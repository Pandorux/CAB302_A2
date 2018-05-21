package store.Reagan_assesment_supermart;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

class StoreTest {

	public Store testStore;
	
	@Test
	void testSingleton_00()
	{
		assertTrue(Store.instance == testStore);
	}
	
	@Test
	void testSingleton_01()
	{
		Store store2 = new Store();
		assertTrue(testStore.instance == store2.instance);
	}
	
	@Test
	void testEmptyStore()
	{
		assertTrue(Store.instance.inventory.length == 0);
	}
	
	@Test
	void testGetName()
	{
		assertEquals("bob", Store.instance.getName());
	}
	
	@Test
	void testGetCapital()
	{
		assertEquals(50, Store.instance.getCapital());
	}
	
	@Test
	void testRenameStore()
	{
		Store.renameStore("bills");
		assertTrue("bills" == Store.instance.getName());
	}
	
	@Test
	void testAddCapital()
	{
		Store.instance.AddCapital(100.50);
		assertTrue(150.50, Store.instance.getCapital());
	}
	
	void testRemoveCapital()
	{
		Store.instance.removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50, Store.instance.getCaptial());
	}	
	
	
	//item tests from store
	
	@Test
	void testInitialInventory()
	{
		Stock potato = new Stock("potato", 50);//item name and quantity
		assertEquals("potato", 50 == Item.findItem(Sherbert));//find second item
	}
	
	@Test
	void testAddItem()
	{
		Stock dolly = new Stock("dolls", 100);
		Stock potato = new Stock("potato", 50);
		Stock.addItem(dolly);	
		Stock.addItem(potato);
		assertEquals(dolly == Stock.findItem(dolly));//find second item
	}
	
	@Test
	void testRemoveItem()
	{
		Stock dolly = new Stock("dolls", 100);
		Stock potato = new Stock("potato", 50);
		Stock.addItem(dolly);	
		Stock.addItem(potato);
		Stock.removeItem(dolly);
		assertEquals("dolls", 100 == Stock.findItem(dolly));//dolls become the first item
	}
	
	@BeforeAll
	private void Setup()//create a stores info
	{
		Store store = new Store("bob", 50);

	}
	
}
