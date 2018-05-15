package store.Reagan_assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

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
		 	public void Test1() //green
		 	{
		 		
		 		SuperMart.capital = 10;//make the capital 10 dollars
		 		
		 		
		 		assertEquals("$10", SuperMart.Return_Capital());// answer , returned answer
		 	}
		 	
		 	
		 	@Test//returns the incorrect capital of the store
		 	public void Test2()//red
		 	{
		 		SuperMart.capital = "pingaz";//the store has capital
		 		
		 		
		 		assertEquals("pingaz", SuperMart.Return_Capital());// this should fail as the stores capital cannot be a string
		 		//the store should have a integer for a capital not a string
		 	}
		 	

			@Test//returns the incorrect inventory
			public void Test4()//red
			{
				
				store_error_test();
		 		
		 		
		 		assertEquals("Potato, a, b, c, d, d, e", SuperMart.View_Inventory());//should not work because quantity cannot be a 
		 		
			}

			
			/**
			 * this should allow the user to view all the objects in the stores inventory even if its in a truck
			 */
			
		    @Test//return the inventories of the trucks and the store associated with a store
		    public void Test5()//green
		    {
				
		    		store_truck_tests();
				 	 
				 	 
				 	 store_test_cases("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
				 	
				 	 
				 	 List_of_products.add(Product_info);
				 	 
				 	 
				 	 Store_Test.addAll(List_of_products);//adds all the values from the stores inventory to the store

					 
				 	 Store_Test.addAll(Truck_Inventory);
				 	 
				 	 
				 	 assertEquals("Potato, 500, 50, 100, hell its self, 50, 0", SuperMart.View_Inventory());
		    }
		    
		    
		    /**
		     * store a object with the relevant info
		     */
		    
		    @Test //ensure you can view the inventory of a store
		    public void Test6()//green
		    {
		    	store_test_cases("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
		    	
		    	
		    	SuperMart.Store_Object("Potato", 500, 50.0, 100.0, "hell its self", 50, 0.0);
		    	
		    	
		    	assertTrue("Potato, 500, 50, 100, hell its self, 50, 0" == SuperMart.View_Inventory());
				 
		    }
		    
		    
		    private void store_test_cases(String name,Integer Quantity,Double Cost,Double sell_price, String Distrobution_point, Integer reorder_amm, Double Temprature)//temp is not nessasary but if it is not input its null
		    {
		    	SuperMart.Product_name = name;
		 		SuperMart.Product_Quantity = Quantity;
		 		SuperMart.Product_manufacture_cost = (double)Cost;
		 		SuperMart.Product_selling_price = (double) sell_price;
		 		SuperMart.Product_distrobution_point = Distrobution_point;
		 		SuperMart.Product_reorder_amount = reorder_amm;
		 		if (Temprature == null)
		 		{
		 			
		 		}
		 		else 
		 		{
		 			SuperMart.Product_Storing_temprature = (double) Temprature;
		 		}
		 		
		 		
		 		
		 		
		 	for (int i = 0; i < 7; i++)
		 	{
		 		switch (i)
		 		{
		 			case 0:
		 				Product_info[i] = SuperMart.Product_name;
		 				break;
		 			case 1:
		 				Product_info[i] = SuperMart.Product_Quantity.toString();
		 				break;
		 			case 2:
		 				Product_info[i] = SuperMart.Product_manufacture_cost.toString();
		 				break;
		 			case 3:
		 				Product_info[i] = SuperMart.Product_selling_price.toString();
		 				break;
		 			case 4:
		 				Product_info[i] = SuperMart.Product_distrobution_point.toString();
		 				break;
		 			case 5:
		 				Product_info[i] = SuperMart.Product_reorder_amount.toString();
		 				break;
		 			case 6:
		 				Product_info[i] = SuperMart.Product_Storing_temprature.toString();
		 				break;
		 				
		 		}
		 	}
		    }
		    
		    
		    private void store_error_test()
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
		 		
		 		SuperMart.Product_name = "Potato";
		 		SuperMart.Product_Quantity = 5;
		 		SuperMart.Product_manufacture_cost = (double) 5;
		 		SuperMart.Product_selling_price =  (double) 5;
		 		SuperMart.Product_distrobution_point = "hell its self";
		 		SuperMart.Product_reorder_amount = 5;
		 		SuperMart.Product_Storing_temprature = (double) 5;
		    }
		
		    private void store_truck_tests()
		    {
		    	ArrayList<String> Store_Test = new ArrayList<String>();//this is the store with all of the trucks inventory 
				 //and the actual inventory of the store

				 
				 String[] Product_info = new String[7];//a array of values that pertain to a object
			 		
			 	 ArrayList List_of_products = new ArrayList();//a list of 
				 
			 	 
			 	 ArrayList Truck_Inventory = new ArrayList();//a list of 
		    }

	}



