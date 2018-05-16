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
		Stock.items_imported(List_of_products);//import the stores stock
		
		setup();
		
		
		
		assertTrue(List_of_products == Stock.give_sales_log( "Cool_kids_crib"));
		
	}
	
	@Test//red
	void Test_WrongStore() //are you looking at the wrong store?
	{
		Stock.items_imported(List_of_products);//import the stores stock
		
		setup();
		
		
		
		assertTrue(List_of_products == Stock.give_sales_log( "Not_Cool_kids_crib"));//wrong store
		
	}

	@Test//green
	void Test_EmptyStoreStock() //can you import nothing?
	{
		ArrayList List_of_products = new ArrayList();//empty array
		assertTrue(List_of_products == Stock.give_sales_log( "Cool_kids_crib"));//is the stock originally empty
		
	}
	
	@Test//green
	void Test_void_store() //a store with no name
	{
		
		assertTrue(List_of_products == Stock.give_sales_log());
		
	}
	
	@Test //red
	void Test_BlankSale()//shouldnt allow a blank sale
	{
		Stock.sale();
		assertTrue(List_of_products == Stock.give_sales_log("Cool_kids_crib"));
	}
	

	
	
	@BeforeAll
	private void setup()//give the store a sale
	{
		ArrayList List_of_products = new ArrayList();
		
		String[] Product_info = new String[3];//a array of values that protane to a object
		
		Stock.sale("Top hat", "50.0", "Cool_kids_crib");
		
		Product_info[0]= "Top hat";
		Product_info[1]= "50.0";
		Product_info[2]= "Cool_kids_crib";
		List_of_products.add(Product_info);
		
	}
	
}
