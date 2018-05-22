package store.Reagan_assesment_supermart;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.rules.ExpectedException;

import delivery.DeliveryException;

class StoreTest {

	public Store testStore;
	
	@Rule 
	public final ExpectedException e = ExpectedException.none();
	
	
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
	
	@Test
	void testAddNegitiveCapital()
	{
		e.expect(DeliveryException.class);//cant have -ve increase
		Store.instance.AddCapital(-100.50);
	}
	
	void testRemoveCapital()
	{
		Store.instance.removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50, Store.instance.getCaptial());
	}	

	void testRemoveNegitiveCapital()
	{
		e.expect(DeliveryException.class);//cant have -ve increase
		Store.instance.removeCapital(10.50);
	}	
	
	//item tests from store
	
	
	@BeforeAll
	private void Setup()//create a stores info
	{
		Store store = new Store("bob", 50);

	}
	
}
