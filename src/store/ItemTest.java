package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



	import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;

	import org.junit.jupiter.api.Test;



		/**
		 * 
		 * @author n9999884
		 *
		 */
		class ItemTest {

			
			
			@Test
			void testChangeItemCost()
			{
				Item.increasePrice("potato", 80);//now worth $80
				assertEquals("potato", 80 == Item.findItemCost());//find second item
			}
			
			@Test
			void testIncreaseManufactureCost()
			{
				Item.increaseCost("potato", 90);//now costs $90 to import potatos
				assertEquals("potato", 90 == Item.findItemManufactureCost());
			}
			
			@Test
			void testChangeImportPoint()
			{
				Item.changeReorderPoint("potato", "Zimbabwe");//now getting items from zimbabwe
				assertEquals("potato", "Zimbabwe" == Item.findItemImportPoint());
			}
			
			@Test
			void testChangeReorderAmount()
			{
				Item.changeReorderAmount("potato", 100);//now getting 100 potato
				assertEquals("potato", 100 == Item.findItemReorderAmount());
			}
			
			
			@Test
			void testAddTempControlItem()
			{
				Item ice_cream = new Item("ice cream", 100, 200, "Brisbane", 10, -30);//assume only 1 item can exist at a time				
				assertEquals(ice_cream == Item.findItem());
			}
			
			
			@BeforeAll
			private void setup()//give the store a sale
			{
				Item item = new Item("potato", 50, 60, "Brisbane", 70);
				//name, manufacture cost, sell cost, reorder point, reorder amount
			}
			

	}



