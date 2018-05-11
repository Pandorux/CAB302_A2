package assesment_supermart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StockTest {

	@Test
	void test() {
		ArrayList List_of_products = new ArrayList();
		
		String[] Product_info = new String[3];//a array of values that protane to a object
		
		Stock.sale("Top hat", "50.0", "Cool_kids_crib");
		
		Product_info[0]= "Top hat";
		Product_info[1]= "50.0";
		Product_info[2]= "Cool_kids_crib";
		
		List_of_products.add(Product_info);
		
		assertTrue(List_of_products == Stock.give_sales_log( "Cool_kids_crib"));
	}

}
