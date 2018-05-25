package store;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import exceptions.DeliveryException;
import exceptions.StockException;

public class StockTest {

	private Stock milk;
	
	@Before
	public void setup()//give the store a sale
	{
		Stock milk = new Stock("milk", 50);//50 milk in stock
		//name, manufacture cost, sell cost, reorder point, reorder amount
		
	}
	
	@Test
	public void testHasStock()
	{
		assertTrue("milk", milk.getName());//
	}
	
	@Test
	public void testHasManyStock()
	{
		assertTrue(50, milk.getQuantity());//find how many of item one you have
	}
	
	@Test
	public void testAddStock()
	{
		Stock potato = new Stock("potato", 100);
		potato.addItem();//add potatos
		assertEquals(potato == potato.getItem());//did u add potatos?
	}
	
	@Test
	public void testIncreaseStock()
	{
		milk.IncreaseAmount(100);//add potatos
		assertEquals(150 == milk.getQuantity());//did u add more milk
	}
	

	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegitiveIncreaseStock()
	{
		milk.IncreaseAmount(-100);//add potatos
	}
	
	@Test
	public void testDecreaseStock()
	{
		milk.DecreaseAmount(20);//add potatos
		assertEquals(30, milk.getQuantity());//did u add more milk
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegitiveDecreaseStock()
	{
		milk.DecreaseAmount(-20);//add potatos
		assertEquals(30 == milk.getQuantity());//did u add more milk
	}
	
	@Test (expected = StockException.class)
	public void testRemoveStock()
	{
		milk.removeItem();//no milk left
		milk.removeItem();//cant remove a item that doesnt exist
	}
	
	@Test (expected = StockException.class)
	public void testNegitaveStock()
	{
		Stock potato = new Stock("potato", -50);//cant have negitive stock
	}
	
	@Test
	public void testRemoveAll()
	{
		Stock potato = new Stock("potato", 100);
		Stock carrot = new Stock("carrots", 100);
		potato.addItem();//add potatos
		carrot.addItem();//add potatos
		Stock.removeAll();//no stock now exists
		assertTrue(null , getAllStock());//there should be no items in stock
	}
	

	@Test (expected = StockException.class)
	public void testInitialInventory()
	{
		assertEquals("potato", 50 == milk.findItem());//a potato is not milk
	}
	
	@Test
	public void testAddItem()
	{
		Stock dolly = new Stock("dolls", 100);
		Stock potato = new Stock("potato", 50);
		dolly.addItem();	
		potato.addItem();
		assertEquals(dolly == dolly.findItem());//find second item
	}
	
	@Test
	public void testRemoveItem()
	{
		Stock dolly = new Stock("dolls", 100);
		Stock potato = new Stock("potato", 50);
		dolly.addItem();	
		potato.addItem();
		potato.removeItem();
		assertEquals("dolls", 100 == dolly.findItem());//dolls become the first item
	}
	
	
	
	
}
