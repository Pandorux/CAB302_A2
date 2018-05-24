package store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.*;
import exceptions.DeliveryException;

public class StoreTest {

	@Test
	public void testSingleton_00()
	{
		assertTrue(Store.instance == store);
	}
	
	@Test
	public void testSingleton_01()
	{
		Store store2 = new Store();
		assertTrue(testStore.instance == store2.instance);
	}
	
	@Test
	public void testEmptyStore()
	{
		assertTrue(Store.instance.inventory.length == 0);
	}
	
	@Test
	public void testGetName()
	{
		assertEquals("bob", Store.instance.getName());
	}
	
	@Test
	public void testGetCapital()
	{
		assertEquals(50, Store.instance.getCapital());
	}
	
	@Test 
	public void testSetCapital()
	{
		Store.instance.setCapital(100.00);//capital is now 100 from what it was initially
		assertEquals(100, Store.instance.getCapital());
	}
	
	@Test
	public void testRenameStore()
	{
		Store.renameStore("bills");
		assertTrue("bills" == Store.instance.getName());
	}
	
	@Test
	public void testAddCapital()
	{
		Store.instance.AddCapital(100.50);
		assertTrue(150.50, Store.instance.getCapital());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddNegitiveCapital()
	{
		Store.instance.AddCapital(-100.50);
	}
	
	@Test 
	public void testRemoveCapital()
	{
		Store.instance.removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50, Store.instance.getCaptial());
	}	

	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveNegitiveCapital()
	{
		Store.instance.removeCapital(-10.50);
	}	
	
	//item tests from store
	
	
	@Before
	public void Setup()//create a stores info
	{
		Store store = new Store("bob", 50);
	}
	
	@After
	public  void clearAll()
	{
		Store.instance.renameStore(null);//remove name
		Store.instance.setCapital(Double.NaN);//makes the capital to not a number
		Store.instance.clearInventory();//removes all the elements of the inventory
	}
	
	
}
