package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import delivery.DeliveryException;
import exceptions.StockException;

import static org.junit.jupiter.api.Assertions.*;

import java.io.EOFException;
import java.util.ArrayList;

	import org.junit.jupiter.api.Test;



		/**
		 * 
		 * @author n9999884
		 *
		 */
	
	
	
		class ItemTest {

			@Rule 
			public final ExpectedException e = ExpectedException.none();
			
			
			@Test
			void testIncreaseManufactureCost()
			{
				Item.increasePrice(80);//now worth $80
				assertEquals("potato", 130 == Item.findItemManufactureCost());//find second item
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveIncreaseManufactureCost()
			{
				Item.increasePrice(-80);//now worth $80
			}
			
			@Test
			void testDecreaseManufactureCost()
			{
				Item.decreasePrice(10);//now worth $80
				assertEquals("potato", 40 == Item.findItemManufactureCost());//find second item
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveDecreaseManufactureCost()
			{
				Item.decreasePrice(-10);//now worth $80
			}
			
			@Test
			void testIncreaseItemSalesCost()
			{
				Item.increaseCost(90);//now costs a extra $90 dollars to buy potatos with base of 50
				assertEquals("potato", 150 == Item.findItemCost());
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveIncreaseItemSalesCost()
			{
				Item.increaseCost(-90);//now costs a extra $90 dollars to buy potatos with base of 50
			}
			
			@Test
			void testDecreaseItemSalesCost()
			{
				Item.decreaseCost(5);//now costs a $5 less to buy potatos base 60
				assertEquals("potato", 55 == Item.findItemCost());
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveDecreaseItemSalesCost()
			{
				Item.decreaseCost(-5);//now costs a $5 less to buy potatos base 60
			}
			
		
			@Test
			void testChangeImportPoint()
			{
				Item.changeReorderPoint("Zimbabwe");//now getting items from zimbabwe
				assertEquals("potato", "Zimbabwe" == Item.findItemImportPoint());
			}
			
			@Test
			void testIncreaseReorderAmount()
			{
				Item.IncreaseReorderAmount(100);//now a extra getting 100 potato from 70
				assertEquals(170 == Item.findItemReorderAmount());
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveIncreaseReorderAmount()
			{
				Item.IncreaseReorderAmount(-100);//now a extra getting 100 potato from 70
			}
			
			@Test
			void testDecreaseReorderAmount()
			{
				Item.DecreaseReorderAmount(70);//now getting 70 less potatos from 70
				assertEquals(0 == Item.findItemReorderAmount());
			}
			
			@Test (expected = IndexOutOfBoundsException.class)
			void testNegitiveDecreaseReorderAmount()
			{
				Item.DecreaseReorderAmount(-70);//now getting 70 less potatos from 70
			}
			
			@Test
			void testAddTempControlItem()
			{
				Item ice_cream = new Item("ice cream", 100, 200, "Brisbane", 10, -30);//assume only 1 item can exist at a time				
				assertEquals(-30 == Item.findItem().getTemperature());//find icecream and its temp should be -30 
			}
			
			@Test 
			void testItemTempControlNotCooled()
			{
				assertEquals(NaN , Item.checkTemprature(potato));//NaN if there is not a temp control
			}//potatos arn't temp controlled
			
			
			@BeforeAll
			private void setup()//give the store a sale
			{
				Item potato = new Item("potato", 50.00, 60.00, "Brisbane", 70);
				//name, manufacture cost, sell cost, reorder point, reorder amount
			}
			

	}



