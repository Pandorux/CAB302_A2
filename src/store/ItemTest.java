package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import delivery.DeliveryException;

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
				Item.increasePrice(80.00);//now worth $80
				assertEquals(80.00 == Item.findItemCost(potato));//find item potato's info
			}
			
			@Test
			void testChangeItemCost()
			{
				Item.newCost(90.00);//now costs $90 to import potatos
				assertEquals(90.00 == Item.findItemManufactureCost(potato));
			}
			
			@Test 
			void testNegitaveManufactureCost()
			{
				e.expect(DeliveryException.class);//cant have -ve cost
				Item.newCost(-90.00);
				
			}
			
			@Test
			void testChangeImportPoint()
			{
				Item.changeReorderPoint("Zimbabwe");//now getting items from zimbabwe
				assertEquals("Zimbabwe" == Item.findItemImportPoint(potato));
			}
			
			@Test
			void testChangeReorderAmount()
			{
				Item.changeReorderAmount(100);//now getting 100 potato
				assertEquals(100 == Item.findItemReorderAmount(potato));
			}
			
			
			void testChangeNegitaveReorderAmount()
			{
				e.expect(DeliveryException.class);//cant have -ve reorder
				Item.changeReorderAmount(-100);//now getting 100 potato
			}
			
			
			@Test
			void testAddTempControlItem()
			{
				Item ice_cream = new Item("ice cream", 100.00, 200.00, "Brisbane", 10, -30);//assume only 1 item can exist at a time				
				assertEquals(ice_cream == Item.findItem(ice_cream));
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



