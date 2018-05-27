package delivery;

import java.util.ArrayList;

import store.Item;

public class Truck extends TruckBase {
	
	
	
	public Truck(int id, int capacity2)
	{
		super();
		
	}
/**
 * 
 * @param cargo will be the new max cargo space of the truck
 */
	public Truck(int cargo)
	{
		super();
		capacity = cargo;
	}
/**
 * default truck
 */
	public Truck() 
	{
		super();
		capacity = 1000;//original capacity
	}
	

}
