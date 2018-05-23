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
				// TODO: No String needed for this method
				// TODO: There should be a decrease price method as well
				Item.increasePrice("potato", 80);//now worth $80
				assertEquals("potato", 80 == Item.findItemCost());//find second item
			}
			
			@Test
			void testChangeItemCost()
			{
<<<<<<< HEAD
				// TODO: no string needed
				// TODO: decrease cost needed
				Item.increaseCost("potato", 90);//now costs $90 to import potatos
				assertEquals("potato", 90 == Item.findItemManufactureCost());
=======
				Item.newCost(90.00);//now costs $90 to import potatos
				assertEquals(90.00 == Item.findItemManufactureCost(potato));
>>>>>>> reagan/junit_tests
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
				// TODO: Only reorderPoint string needed for this method
				Item.changeReorderPoint("potato", "Zimbabwe");//now getting items from zimbabwe
				assertEquals("potato", "Zimbabwe" == Item.findItemImportPoint());
			}
			
			@Test
			void testChangeReorderAmount()
			{
				// TODO: turn this into an increase and decrease reorderAmount
				// TODO: No string needed for method
				Item.changeReorderAmount("potato", 100);//now getting 100 potato
				assertEquals("potato", 100 == Item.findItemReorderAmount());
			}
			
			
			void testChangeNegitaveReorderAmount()
			{
				e.expect(DeliveryException.class);//cant have -ve reorder
				Item.changeReorderAmount(-100);//now getting 100 potato
			}
			
			
			@Test
			void testAddTempControlItem()
			{
				Item ice_cream = new Item("ice cream", 100, 200, "Brisbane", 10, -30);//assume only 1 item can exist at a time				
				assertEquals(ice_cream == Item.findItem());
				// TODO: Why should the Item find itself?
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



