package store.Reagan_assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import delivery.DeliveryException;

class StockTest {

	@Rule 
	public final ExpectedException e = ExpectedException.none();
	
	
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
		Stock.IncreaseAmount(milk, 100);//add potatos
		assertEquals(150 == Stock.item.getQuantity(milk));//did u add more milk
	}
	
	@Test
	void testDecreaseStock()
	{
		Stock.DecreaseAmount(milk, 20);//add potatos
		assertEquals(30 == Stock.item.getQuantity(milk));//did u add more milk
	}
	
	@Test
	void testIncreaseStock()
	{
		e.expect(DeliveryException.class);//cant have -ve increase
		Stock.DecreaseAmount(milk, -100);//add potatos
	}
	
	
	
	@Test
	void testIncreaseNegitiveStock()
	{
		e.expect(DeliveryException.class);//cant have -ve increase
		Stock.IncreaseAmount(milk, -100);//add potatos
	}
	

	@Test 
	void testRemoveStock()
	{
		Stock.removeItem(milk);//remove 50 of the first item
		assertTrue(StockException.PrintException() , Stock.item.getItem(milk));//there is no item one so there should be a exception
	}
	
	@Test
	void testNegitaveStock()
	{
		Stock.removeItem(milk);
		Stock potato = new Stock("potato", -50);
		assertTrue(StockException.PrintException(), Stock.item.getItem(potato));//cant get -ve potatos
	}
	
	@Test
	void testRemoveAll()
	{
		Stock.addItem("potato", 100);//add potatos
		Stock.addItem("carrots", 100);//add potatos
		Stock.removeAll();
		assertTrue(StockException.PrintException() ,Stock.item.getItem(milk));//there should be no items in stock
	}
	

	@Test
	void testInitialInventory()
	{
		assertEquals("potato", 50 == Item.findItem(milk));//find second item
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
		Stock.removeItem(dolly);
		assertEquals("dolls", 100 == Stock.findItem(dolly));//dolls become the first item
	}
	
	
	@BeforeAll
	private void setup()//give the store a sale
	{
		Stock milk = new Stock("milk", 50);//50 milk in stock
		//name, manufacture cost, sell cost, reorder point, reorder amount
		
	}
	
}
