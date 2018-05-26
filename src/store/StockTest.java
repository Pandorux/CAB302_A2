package store;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import exceptions.DeliveryException;
import exceptions.StockException;

public class StockTest {

	private Stock inventory;
	private ArrayList<Item> milk;
	
	@Before
	public void setup()//give the store a sale
	{
		for (int  i = 0; i < 500; i++)
		{
			milk.add(new Item("Milk", 10.00, 10.00, "Zimbabwe", 50, -20));
		}
		Stock inventory = new Stock();
		inventory.addItems(milk);
		//50 milk in stock
		//name, manufacture cost, sell cost, reorder point, reorder amount
		
	}
	
	
	@Test
	public void testItemQuantity_SameCase()
	{
		assertTrue(500 == inventory.getQuantity("Milk"));//find how many of item one you have
	}
	
	@Test
	public void testItemQuantity_LowerCase()
	{
		assertTrue(500 == inventory.getQuantity("milk"));//find how many of item one you have
	}
	
	@Test
	public void testItemQuantity_UpperCase()
	{
		assertTrue(500 == inventory.getQuantity("MILK"));//find how many of item one you have
	}
	
	@Test
	public void testAddStock()
	{
		ArrayList<Item> potato;
		for (int  i = 0; i < 1000; i++)
		{
			potato.add(new Item("Potato", 10.00, 10.00, "Zimbabwe", 50));
		}
		inventory.addItems(potato);//add potatos
		assertTrue(1000 == inventory.getQuantity("Potato"));//did u add potatos?
	}
	
	@Test
	public void testIncreaseStock()
	{
		inventory.IncreaseAmount("milk", 100);
		assertTrue(600 == inventory.getQuantity("milk"));//did u add more milk
	}
	

	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegitiveIncreaseStock()
	{
		inventory.IncreaseAmount("milk", -100);
	}
	
	@Test (expected = StockException.class)
	public void testIncreaseStock_ItemDoesntExist()
	{
		inventory.IncreaseAmount("sherbert", 100);
	}
	
	
	@Test 
	public void testRemoveAllStock_NoExistingItem()
	{
		assertTrue(null == inventory.removeItems("sherbert"));//sherbert doesnt exist
	}
	
	@Test 
	public void testRemoveAllStock()
	{
		ArrayList<Item> milk02 = inventory.removeItems("milk");//sherbert doesnt exist
		assertTrue(milk == milk02);//did u add more milk
	}
	
	@Test 
	public void testRemoveSomeStock_NoExistingItem()
	{
		assertTrue(null == inventory.removeItems("sherbert", 90));//sherbert doesnt exist
	}
	
	@Test 
	public void testRemoveSomeStock()
	{
		ArrayList<Item> milk02 = inventory.removeItems("milk", 200);//sherbert doesnt exist
		assertTrue(300 == milk02.size());//did u add more milk
	}
	
	@Test (expected = StockException.class)
	public void testRemoveStock_MoreThanStored()
	{
		ArrayList<Item> milk02 = inventory.removeItems("milk", 2000);//sherbert doesnt exist
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegitaveStock()
	{
		Stock potato = new Stock("potato", -50);//cant have negitive stock
	}
	

	@Test (expected = StockException.class)
	public void testInitialInventory()
	{
		Stock invetory = new Stock();//50 milk in stock
		assertTrue(0 == inventory.length());//a potato is not milk
	}
	
	@Test
	public void testRemoveAll()
	{
		inventory.removeAll();
		assertTrue(0 == inventory.length());//
	}
	
}
