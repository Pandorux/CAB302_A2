package store.Reagan_assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockTest {

	@Test//green
	void Test_StoreStock() //can you import and store stock?
	{
		setup();
		
		Stock.items_imported(List_of_products);//import the stores stock
		
		assertTrue(List_of_products == Stock.give_sales_log( "Cool_kids_crib"));
		//does the store have its stock
	}

	@Test//green
	void Test_SalesLog()//can you give a log of all the sales
	{
		
		setup();

		assertTrue(Product_info == give_sales_log("Cool_kids_crib"));
		
	}
	
	
	
	
	@BeforeEach
	private void setup()//give the store a sale
	{
		ArrayList List_of_products = new ArrayList();
		
		String[] Product_info = new String[3];//a array of values that protane to a object
		
		Stock.sale("Top hat", "50.0", "Cool_kids_crib");
		
		Product_info[0]= "Top hat";
		Product_info[1]= "50.0";
		Product_info[2]= "Cool_kids_crib";
	}
	
}
