package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SuperMartTest {

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
	 	
	 	
	 	@Test//return the stores capitaal
	 	public void Test1() //green
	 	{
	 		
	 		SuperMart.capital = 10;//make the capital 10 dollars
	 		
	 		assertEquals("$10", SuperMart.Return_Capital());// answer , returned answer
	 	}
	 	@Test
	 	public void Test2()//red
	 	{
	 		SuperMart.capital = 1000;
	 		
	 		assertEquals("pingaz", SuperMart.Return_Capital());// this should fail as the stores capital cannot be a string
	 		
	 	}
	 	
	 	
	 	@Test
	 	public void Test3()//green
	 	{
	 		
	 		//List Product_info = new ArrayList(); // input a list of values as they are related
	 		//List List_of_products = new ArrayList();
	 		//String[] List_of_products = new String[7];
	 		
	 		
	 		String[] Product_info = new String[7];//a array of values that protane to a object
	 		
	 		ArrayList List_of_products = new ArrayList();//a list of 
	 		
	 		for (int i = 0; i < 6; i++)
	 		{
	 			Product_info[i] = "";//clear the product info list
	 		}
	 		//Product_info.clear();//doesnt work
	 				
	 		List_of_products.clear();	
	 		
	 		SuperMart.Product_name = "Potato";
	 		SuperMart.Product_Quantity = 500;
	 		SuperMart.Product_manufacture_cost = (double) 50;
	 		SuperMart.Product_selling_price = (double) 100;
	 		SuperMart.Product_distrobution_point = "hell its self";
	 		SuperMart.Product_reorder_amount = 50;
	 		SuperMart.Product_Storing_temprature = (double) 0;
	 		
	 		
	 		
	 	for (int i = 0; i < 7; i++)//shut it jarred, i know what your gonna say, so plz no
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
	 		
	 	    
	 		
	 		List_of_products.add(Product_info); // this makes the first value the product potato with all the relevent info which can be retrieved easily
	 		
	 		assertEquals("Potato, 500, 50, 100, hell its self, 50, 0", SuperMart.View_Inventory());//this should show all the items in the stores inventory
	 	}


		@Test
		public void Test4()//red
		{
			String[] Product_info = new String[7];//a array of values that protane to a object
	 		
	 		ArrayList List_of_products = new ArrayList();//a list of 
	 		
			for (int i = 0; i < 6; i++)
	 		{
	 			Product_info[i] = "";//clear the product info list
	 		}
	 		List_of_products.clear();	
	 		
	 		Product_info[0] = ("Potato");//this should not be allowed as the array shouldnt accept letters instead of numbers here
	 		Product_info[1] = ("a");//qty
	 		Product_info[2] = ("b");//m_cost
	 		Product_info[3] = ("c");//sell_price
	 		Product_info[4] = ("d");//disp_point
	 		Product_info[5] = ("e");//re_amm
	 		Product_info[6] = ("f");//storing_temp
	 		
	 		SuperMart.Product_name = "Potato";
	 		SuperMart.Product_Quantity = "a";
	 		SuperMart.Product_manufacture_cost = "b";
	 		SuperMart.Product_selling_price =  "100";
	 		SuperMart.Product_distrobution_point = "hell its self";
	 		SuperMart.Product_reorder_amount = "e";
	 		SuperMart.Product_Storing_temprature = "f";
	 		
	 		assertEquals("Potato, a, b, c, d, e, f", SuperMart.View_Inventory());
	 		
		}

	    @Test
	    public void Test5()//green
	    {
			
				



	    	
	    }
	}


}
