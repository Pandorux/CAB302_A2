package store.Reagan_assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testRemoveStock()
	{
		Stock.removeItem(milk);//remove 50 of the first item
		assertTrue(StockException.PrintException() , Stock.item.getItem(milk));//there is no item one so there should be a exception
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
		Stock potato = new Stock("potato", 50);//item name and quantity
		assertEquals("potato", 50 == Item.findItem(Sherbert));//find second item
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
