package store.Reagan_assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockTest {

	
	@Test
	void testHasStock()
	{
		assertTrue("milk", Stock.item.getName());//get the first items name
	}
	
	@Test
	void testHasManyStock()
	{
		assertTrue(50, Stock.item.getQuantity());//find how many of item one you have
	}
	
	@Test
	void testAddStock()
	{
		Stock potato = new Stock("potato", 100);
		Stock.addItem(potato);//add potatos
		assertEquals(potato == Stock.item.getItem());//did u add potatos?
	}

	@Test 
	void testRemoveStock()
	{
		Stock.removeItem(milk);//remove 50 of the first item
		assertTrue(StockException.PrintException() , Stock.item.getItem());//there is no item one so there should be a exception
	}
	
	@Test
	void testRemoveAll()
	{
		Stock.addItem("potato", 100);//add potatos
		Stock.addItem("carrots", 100);//add potatos
		Stock.removeAll();
		assertTrue(StockException.PrintException() ,Stock.item.getItem());//there should be no items in stock
	}
	
	@BeforeAll
	private void setup()//give the store a sale
	{
		Stock milk = new Stock("milk", 50);//50 milk in stock	
	}
	
}
