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
	/*
	@Test
	void testInitialInventory()
	{
		assertEquals("potato", 50, 60, "Brisbane", 70 == Item.findItem(1));//find second item
	}
	
	@Test
	void testAddItem()
	{
		Item dolly = new Item("dolls", 100, 200, "Perth", 10);
		Item.addItem(dolly);				
		assertEquals(dolly == Item.findItem(2));//find second item
	}
	
	@Test
	void testRemoveItem()
	{
		Item.addItem("dolls", 100, 200, "Perth", 10);//adds dolls to item 2
		Item.removeItem(1);
		assertEquals("dolls", 100, 200, "Perth", 10 == Item.findItem(1));//dolls become the first item
	}
	*/
	@BeforeAll
	private void Setup()//create a stores info
	{
		Store store = new Store("bob", 50);

	}
	
}
