package store;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import exceptions.DeliveryException;
import exceptions.StockException;

class StockTest {

	
	@Test
	void testHasStock()
	{
		assertTrue("milk", Stock.item.getName(milk));//
	}
	
	@Test
	void testHasManyStock()
	{
		assertTrue(50, Stock.item.getQuantity(milk));//find how many of item one you have
	}
	
	@Test
	void testAddStock()
	{
		Stock potato = new Stock("potato", 100);
		Stock.addItem(potato);//add potatos
		assertEquals(potato == Stock.item.getItem(potato));//did u add potatos?
	}
	
	@Test
	void testIncreaseStock()
	{
		Stock.IncreaseAmount(100);//add potatos
		assertEquals(150 == Stock.item.getQuantity(milk));//did u add more milk
	}
	

	@Test (expected = IndexOutOfBoundsException.class)
	void testNegitiveIncreaseStock()
	{
		Stock.IncreaseAmount(milk, -100);//add potatos
	}
	
	@Test
	void testDecreaseStock()
	{
		Stock.DecreaseAmount(20);//add potatos
		assertEquals(30 == Stock.item.getQuantity(milk));//did u add more milk
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	void testNegitiveDecreaseStock()
	{
		Stock.DecreaseAmount(-20);//add potatos
		assertEquals(30 == Stock.item.getQuantity(milk));//did u add more milk
	}
	
	@Test (expected = StockException.class)
	void testRemoveStock()
	{
		Stock.removeItem(milk);//no milk left
		Stock.removeItem(milk);//cant remove a item that doesnt exist
	}
	
	@Test (expected = StockException.class)
	void testNegitaveStock()
	{
		Stock potato = new Stock("potato", -50);//cant have negitive stock
	}
	
	@Test
	void testRemoveAll()
	{
		Stock.addItem("potato", 100);//add potatos
		Stock.addItem("carrots", 100);//add potatos
		Stock.removeAll();//no stock now exists
		assertTrue(null ,Stock.item.getAllStock());//there should be no items in stock
	}
	

	@Test (expected = StockException.class)
	void testInitialInventory()
	{
		assertEquals("potato", 50 == Item.findItem(milk));//a potato is not milk
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
		Stock.removeItem(potato);
		assertEquals("dolls", 100 == Stock.findItem(dolly));//dolls become the first item
	}
	
	
	@Before
	private void setup()//give the store a sale
	{
		Stock milk = new Stock("milk", 50);//50 milk in stock
		//name, manufacture cost, sell cost, reorder point, reorder amount
		
	}
	
}
