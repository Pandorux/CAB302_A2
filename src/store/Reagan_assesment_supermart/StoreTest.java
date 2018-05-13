package store.Reagan_assesment_supermart;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StoreTest {

	@Test
	void test() {
		Store.new_store("da crib", 50.0);
		
		ArrayList List_of_products = new ArrayList();
		String[] Product_info = new String[3];//a array of values that protane to a object
		
		Product_info[0] = "da crib";
		Product_info[0] = "50.0";
		Product_info[0] = "null";
		
		List_of_products.add(Product_info);
		
		assertTrue(List_of_products == Store.find_store("da crib"));
	}

}
