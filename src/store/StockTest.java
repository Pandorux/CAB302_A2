package store;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import exceptions.DeliveryException;
import exceptions.StockException;

public class StockTest {

	public Stock inventory;
	public ArrayList<Item> milk;
	public ArrayList<Item> potato;
	
	@Before
	public void setup()//give the store a sale
	{
		milk = new ArrayList<Item>();
		potato = new ArrayList<Item>();
		
		milk = new ArrayList<Item>();
		for (int  i = 0; i < 500; i++)
		{
			milk.add(new Item("Milk", 10.00, 10.00, "Zimbabwe", 50, -20));
		}

		
		for (int  i = 0; i < 1000; i++)
		{
			potato.add(new Item("Potato", 10.00, 10.00, "Zimbabwe", 50));
		}
		
		inventory = new Stock();
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
	public void testItemQuantity_00()
	{
		assertTrue(500 == inventory.length());//find how many of item one you have
	}
	
	@Test
	public void testAddStock()
	{
		inventory.addItems(potato);//add potatos
		assertTrue(1000 == inventory.getQuantity("Potato"));//did u add potatos?
	}
	
	@Test
	public void testIncreaseStock()
	{
		//inventory.addItems("milk", 100);
		assertTrue(600 == inventory.getQuantity("milk"));//did u add more milk
	}
	

	@Test 
	public void testAddItem_ExistingItem()
	{
		inventory.addItem(new Item("Milk", 10.00, 10.00, "Zimbabwe", 50, -20));
		assertTrue(501 == inventory.getQuantity("Milk"));
	}
	
	@Test 
	public void testAddItem_NotExistingItem()
	{
		inventory.addItem(new Item("Potato", 10.00, 10.00, "Zimbabwe", 50));
		assertTrue(1 == inventory.getQuantity("Potato"));
	}
	
	@Test (expected = StockException.class)
	public void testIncreaseStock_ItemDoesntExist()
	{
		inventory.addItems(potato);
	}
	
	
	@Test (expected = StockException.class)
	public void testRemoveAllStock_NoExistingItem()
	{
		inventory.removeItems("sherbert");//sherbert doesnt exist
	}
	
	@Test 
	public void testRemoveAllStock()
	{
		ArrayList<Item> milk02 = inventory.removeItems("Milk");//sherbert doesnt exist
		System.out.println(milk02);
		assertTrue(500 == milk02.size());//did u add more milk
	}
	
	@Test (expected = StockException.class)
	public void testRemoveSomeStock_NoExistingItem()
	{
		inventory.removeItems("sherbert", 90);//sherbert doesnt exist
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
	
	// TODO: Fix this Unit Test
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegativeStock()
	{
		Stock potato = new Stock();//cant have negitive stock
	}
	

	@Test
	public void testInitialInventory()
	{
		inventory = new Stock();//50 milk in stock
		assertTrue(0 == inventory.length());//a potato is not milk
	}
	
	@Test
	public void testRemoveAll()
	{
		inventory.removeAll();
		assertTrue(0 == inventory.length());//
	}
	
}
