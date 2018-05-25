package store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.*;
import exceptions.DeliveryException;

public class StoreTest {

	private Store store;
	
	@Before
	public void Setup()//create a stores info
	{
		Store store = new Store("bob", 50.00);
	}
	
	
	public void testResetSingleton_Inventory()
	{
		Store.deconstructor();//this resets the singleton;
		assertEquals("",store.getInventory());//shouldnt have a inventory
	}
	
	public void testResetSingleton_Capital()
	{
		Store.deconstructor();//this resets the singleton;
		assertEquals(Double.NaN ,store.getCapital());//shouldnt have a capital
		
	}
	
	public void testResetSingleton_Name()
	{
		Store.deconstructor();//this resets the singleton;
		assertEquals(null ,store.getName());//shouldnt have a name
	}
	
	/*
	@Test
	public void testSingleton_00()
	{
		assertTrue(Store.instance == store);
	}
	
	@Test
	public void testSingleton_01()////////////////////////////////////////////////////////////////////////////
	{
		Store store2 = new Store();
		assertTrue(testStore.instance == store2.instance);
	}
	*/
	
	@Test
	public void testEmptyStore()
	{
		assertTrue(0 == Store.getInstance().inventory.length());
	}
	
	@Test
	public void testGetName()
	{
		assertEquals("bob",  Store.getInstance().getName());
	}
	
	@Test
	public void testGetCapital()
	{
		assertEquals(50.00,  Store.getInstance().getCapital());
	}
	
	@Test 
	public void testSetCapital()
	{
		 Store.getInstance().setCapital(100.00);//capital is now 100 from what it was initially
		assertEquals(100.00,  Store.getInstance().getCapital());
	}
	
	@Test
	public void testRenameStore()
	{
		Store.getInstance().renameStore("bills");
		assertTrue("bills" ==  Store.getInstance().getName());
	}
	
	@Test
	public void testAddCapital()
	{
		 Store.getInstance().AddCapital(100.50);
		assertTrue(150.50,  Store.getInstance().getCapital());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddNegitiveCapital()
	{
		 Store.getInstance().AddCapital(-100.50);
	}
	
	@Test 
	public void testRemoveCapital()
	{
		 Store.getInstance().removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50,  Store.getInstance().getCaptial());
	}	

	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveNegitiveCapital()
	{
		 Store.getInstance().removeCapital(-10.50);
	}	
	
	
	@After
	public void resetSingleton()
	{
		 Store.getInstance().renameStore(null);//remove name
		 Store.getInstance().setCapital(Double.NaN);//makes the capital to not a number
		 Store.getInstance().clearInventory();//removes all the elements of the inventory
	}
	
	
}
