package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;



	import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;

	import org.junit.jupiter.api.Test;



		/**
		 * 
		 * @author n9999884
		 *
		 */
		class junit {

		 	
		private static final String[] Product_info = null;

		/*function: Return_Capital
		 	* this should give the capital of the super mart AKA the total value of the store
		 	*/
		 	
		 	
		 	@Test//return the stores capital
		 	public void Test_FindCapital() //green
		 	{
		 		
		 		Item.capital = 10;//make the capital 10 dollars
		 		
		 		
		 		assertEquals("$10", Item.Return_Capital());// answer , returned answer
		 	}
		 	
		 	
		 	@Test//returns the incorrect capital of the store
		 	public void Test_FindStringCapital()//red
		 	{
		 		Item.capital = "pingaz";//the store has capital
		 		
		 		
		 		assertEquals("pingaz", Item.Return_Capital());// this should fail as the stores capital cannot be a string
		 		//the store should have a integer for a capital not a string
		 	}
		 	

			@Test//returns the incorrect inventory
			public void Test_ViewBadInventory()//red
			{
				
				StoreErrorTests();
		 		
		 		
		 		assertEquals("Potato, a, b, c, d, d, e", Item.View_Inventory());//should not work because quantity cannot be a 
		 		
			}

			
			/**
			 * this should allow the user to view all the objects in the stores inventory even if its in a truck
			 */
			
		    @Test//return the inventories of the trucks and the store associated with a store
		    public void Test_ViewAllInventories()//green
		    {
				
		    		store_truck_tests();
				 	 
				 	 
		    		StoreTestInfomation("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
				 	
				 	 
				 	 List_of_products.add(Product_info);
				 	 
				 	 
				 	 Store_Test.addAll(List_of_products);//adds all the values from the stores inventory to the store

					 
				 	 Store_Test.addAll(Truck_Inventory);
				 	 
				 	 
				 	 assertEquals("Potato, 500, 50, 100, hell its self, 50, 0", Item.View_Inventory());
		    }
		    
		    
		    /**
		     * store a object with the relevant info
		     */
		    
		    @Test //ensure you can view the inventory of a store
		    public void Test_ViewStoreInventory()//green
		    {
		    	StoreTestInfomation("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
		    	
		    	
		    	Item.Store_Object("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
		    	
		    	
		    	assertTrue("Potato, 500, 50, 100, hell its self, 50, 0" == Item.View_Inventory());
				 
		    }
		    
		    @BeforeClass
		    private void StoreTestInfomation(String name,Integer Quantity,Double Cost,Double sell_price, String Distrobution_point, Integer reorder_amm, Double Temprature)//temp is not nessasary but if it is not input its null
		    {
		    	Item.Product_name = name;
		 		Item.Product_Quantity = Quantity;
		 		Item.Product_manufacture_cost = (double)Cost;
		 		Item.Product_selling_price = (double) sell_price;
		 		Item.Product_distrobution_point = Distrobution_point;
		 		Item.Product_reorder_amount = reorder_amm;
		 		if (Temprature == null)
		 		{
		 			
		 		}
		 		else 
		 		{
		 			Item.Product_Storing_temprature = (double) Temprature;
		 		}
		 		
		 		
		 		
		 		
		 	for (int i = 0; i < 7; i++)
		 	{
		 		switch (i)
		 		{
		 			case 0:
		 				Product_info[i] = Item.Product_name;
		 				break;
		 			case 1:
		 				Product_info[i] = Item.Product_Quantity.toString();
		 				break;
		 			case 2:
		 				Product_info[i] = Item.Product_manufacture_cost.toString();
		 				break;
		 			case 3:
		 				Product_info[i] = Item.Product_selling_price.toString();
		 				break;
		 			case 4:
		 				Product_info[i] = Item.Product_distrobution_point.toString();
		 				break;
		 			case 5:
		 				Product_info[i] = Item.Product_reorder_amount.toString();
		 				break;
		 			case 6:
		 				Product_info[i] = Item.Product_Storing_temprature.toString();
		 				break;
		 				
		 		}
		 	}
		    }
		    
		    @BeforeClass
		    private void StoreErrorTests()
		    {


		    	String[] Product_info = new String[7];//a array of values that pertain to a object
		 		
		 		ArrayList List_of_products = new ArrayList();//a list of 
		    	
		 		Product_info[0] = ("Potato");//this should not be allowed as the array shouldn't accept letters instead of numbers here
		 		Product_info[1] = ("a");//quantity
		 		Product_info[2] = ("b");//m_cost
		 		Product_info[3] = ("c");//sell_price
		 		Product_info[4] = ("d");//disp_point
		 		Product_info[5] = ("e");//re_amm
		 		Product_info[6] = ("f");//storing_temp
		 		
		 		Item.Product_name = "Potato";
		 		Item.Product_Quantity = 5;
		 		Item.Product_manufacture_cost = (double) 5;
		 		Item.Product_selling_price =  (double) 5;
		 		Item.Product_distrobution_point = "hell its self";
		 		Item.Product_reorder_amount = 5;
		 		Item.Product_Storing_temprature = (double) 5;
		    }
		    @BeforeClass
		    private void store_truck_tests()
		    {
		    	ArrayList<String> Store_Test = new ArrayList<String>();//this is the store with all of the trucks inventory 
				 //and the actual inventory of the store

				 
				 String[] Product_info = new String[7];//a array of values that pertain to a object
			 		
			 	 ArrayList List_of_products = new ArrayList();//a list of 
				 
			 	 
			 	 ArrayList Truck_Inventory = new ArrayList();//a list of 
		    }

	}



