package store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.*;
import exceptions.DeliveryException;

public class StoreTest {

	public Store store;
	
	@Before
	public void Setup()//create a stores info
	{
		Store.getInstance().renameStore("bob");
		Store.getInstance().addCapital(50);
	}
	
	@After
	public void resetSingleton()
	{
		Store.getInstance().deconstruct();
	}
	
	@Test
	public void testResetSingleton_Inventory()
	{
		Store.getInstance().deconstruct();//this resets the singleton;
		assertTrue(0 == Store.getInstance().getInventory().length());//shouldnt have a inventory
	}
	
	@Test
	public void testResetSingleton_Capital()
	{
		Store.getInstance().deconstruct();//this resets the singleton;
		assertTrue(0 == Store.getInstance().getCapital());//shouldnt have a capital
		
	}
	
	@Test
	public void testResetSingleton_Name()
	{
		Store.getInstance().deconstruct();//this resets the singleton;
		assertTrue("" == Store.getInstance().getName());//shouldnt have a name
	}
	
	@Test
	public void testEmptyStore()
	{
		assertTrue(0 == Store.getInstance().getInventory().length());
	}
	
	@Test
	public void testGetName()
	{
		assertTrue("bob" ==  Store.getInstance().getName());
	}
	
	@Test
	public void testGetCapital()
	{
		assertTrue(50.00 == Store.getInstance().getCapital());
	}
	
	@Test 
	public void testSetCapital()
	{
		 Store.getInstance().addCapital(50.00);//capital is now 100 from what it was initially
		 assertTrue(100.00 == Store.getInstance().getCapital());
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
		 Store.getInstance().addCapital(100.50);
		assertTrue(150.50 == Store.getInstance().getCapital());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddNegitiveCapital()
	{
		Store.getInstance().addCapital(-100.50);
	}
	
	@Test 
	public void testRemoveCapital()
	{
		Store.getInstance().removeCapital(10.50);//50 - 10 = 39.50
		assertTrue(39.50 ==  Store.getInstance().getCapital());
	}	

	@Test
	public void testRemoveNegitiveCapital()
	{
		 Store.getInstance().removeCapital(-10.50);
		 assertTrue(39.50 == Store.getInstance().getCapital());
	}		
	
	
	
	
	// TODO: Is it possble for capital to below $0.00?
	
}
