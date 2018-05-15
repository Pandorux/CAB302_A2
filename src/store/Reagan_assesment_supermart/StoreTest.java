package store.Reagan_assesment_supermart;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StoreTest {

	@Test//green
	void test1() //look for a store
	{
		Store.new_store("da crib", 50.0);//make new store
		
		Setup();
		
		List_of_products.add(Product_info);//add the stores product
		
		assertTrue(List_of_products == Store.find_store("da crib"));//does the store have a product
	}

	
	@Test//red
	void test2() //search for a incorrect store
	{
		Store.new_store("the crib", 50.0);//make new store and look for the incorrect store
		
		Setup();
		
		List_of_products.add(Product_info);//add the stores product
		
		assertTrue(List_of_products == Store.find_store("da crib"));//looking for the incorrect store
	}

	
	
	
	private void Setup()//create a stores info
	{
		ArrayList List_of_products = new ArrayList();
		String[] Product_info = new String[3];//a array of values that pertains to a object
		
		Product_info[0] = "da crib";
		Product_info[0] = "50.0";
		Product_info[0] = "null";
	}
	
}
