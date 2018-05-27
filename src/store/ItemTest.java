package store;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.StockException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.EOFException;
import java.util.ArrayList;



/**
 * 
 * @author n9999884
 *
 */
public class ItemTest {
	
	public Item potato;
	
	@Before
	public void setup()//give the store a sale
	{
		potato = new Item("potato", 50.00, 60.00, "Brisbane", 70);
		//name, manufacture cost, sell cost, reorder point, reorder amount
	}
	
	@Test
	public void testIncreaseManufactureCost()
	{
		potato.increaseManufactureCost(80);//now worth $80
		assertTrue(130 == potato.findItemManufactureCost());//find second item
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegativeIncreaseManufactureCost()
	{
		potato.increaseManufactureCost(-80);//now worth $80
	}
	
	@Test
	public void testDecreaseManufactureCost()
	{
		potato.decreaseManufactureCost(10);//now worth $40
		assertTrue(40 == potato.findItemManufactureCost());//find second item
	}
	
	@Test
	public void testNegativeDecreaseManufactureCost()
	{
		potato.decreaseManufactureCost(-10);//now worth $40
		assertTrue(40 == potato.findItemManufactureCost());
	}
	
	@Test
	public void testIncreaseItemSalesCost()
	{
		potato.increaseRetailPrice(90);//now costs a extra $90 dollars to buy potatos with base of 50
		assertTrue(150 == potato.findRetailPrice());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegativeIncreaseItemSalesCost()
	{
		potato.increaseRetailPrice(-90);//now costs a extra $90 dollars to buy potatos with base of 50
	}
	
	@Test
	public void testDecreaseItemSalesCost()
	{
		potato.decreaseRetailPrice(5);//now costs a $5 less to buy potatos base 60
		assertTrue(55 == potato.findRetailPrice());
	}
	
	@Test
	public void testNegativeDecreaseItemSalesCost() 
	{
		potato.decreaseRetailPrice(-5);//now costs a $5 less to buy potatos base 60
		assertTrue(55 == potato.findRetailPrice());
	}
	

	@Test
	public void testChangeImportPoint()
	{
		potato.changeReorderPoint("Zimbabwe");//now getting items from zimbabwe
		assertTrue("Zimbabwe" == potato.findItemImportPoint());
	}
	
	@Test
	public void testIncreaseReorderAmount()
	{
		potato.increaseReorderAmount(100);//now a extra getting 100 potato from 70
		assertTrue(170 == potato.findItemReorderAmount());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegitiveIncreaseReorderAmount() 
	{
		potato.increaseReorderAmount(-100);//now a extra getting 100 potato from 70
	}
	
	@Test
	public void testDecreaseReorderAmount()
	{
		potato.decreaseReorderAmount(70);//now getting 70 less potatos from 70
		assertTrue(0 == potato.findItemReorderAmount());
	}
	
	@Test
	public void testAddTempControlItem()
	{
		Item ice_cream = new Item("ice cream", 100, 200, "Brisbane", 10, -30);			
		assertTrue(-30 == ice_cream.getTemperature());//find icecream and its temp should be -30 
	}
	
	@Test 
	public void testItemTempControlNotCooled()
	{
		assertFalse(potato.checkTemperature()); //NaN if there is not a temp control
	}//potatos arn't temp controlled
		
}