package store.Reagan_assesment_supermart;

import java.util.ArrayList;

public class Store {

	static Store Store = new Store();
	
	private String name;
	private double funds;
	private ArrayList inventory;
	
	public static void new_store(String name, double init_funds)
	{
		Store.name = name;//name of the store
		Store.funds = init_funds;//startup cash
		Store.inventory = null;//empty inventory
	}
	
	public static ArrayList find_store(String Store_name)
	{
		return null;
		
	}
	
	
	
	
}
