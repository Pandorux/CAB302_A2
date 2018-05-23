package delivery;

import java.util.ArrayList;

import store.Item;

public class Truck extends TruckBase {

	int ID; 
	int capasity;
	public static ArrayList<Item> Inventory;//makes a inventory for the truck that is null initially
	
	
	public Truck(int id, int capacity2)
	{
		super();
		
		ID = id;
		capasity = capacity2;
		
	}
	

}
