package store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.*;
import exceptions.DeliveryException;

class StoreTest {

	@Test
	void testSingleton_00()
	{
		assertTrue(Store.instance == store);
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
	void testSetCapital()
	{
		Store.instance.setCapital(100.00);//capital is now 100 from what it was initially
		assertEquals(100, Store.instance.getCapital());
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
	
	@Test (expected = IndexOutOfBoundsException.class)
	void testAddNegitiveCapital()
	{
		Store.instance.AddCapital(-100.50);
	}
	
	@Test 
	void testRemoveCapital()
	{
		Store.instance.removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50, Store.instance.getCaptial());
	}	

	@Test (expected = IndexOutOfBoundsException.class)
	void testRemoveNegitiveCapital()
	{
		Store.instance.removeCapital(-10.50);
	}	
	
	//item tests from store
	
	
	@Before
	private void Setup()//create a stores info
	{
		Store store = new Store("bob", 50);

	}
	
	@After
	private void clearAll()
	{
		Store.instance.renameStore(null);//remove name
		Store.instance.setCapital(Double.NaN);//makes the capital to not a number
		Store.instance.clearInventory();//removes all the elements of the inventory
	}
	
	
}
