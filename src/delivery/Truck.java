package delivery;

import java.util.ArrayList;

import store.Item;

public class Truck extends TruckBase {
	
	public Truck(int id, int capacity2)
	{
		super();
		
	}

	public Truck(int cargo)
	{
		super();
		TruckBase.capacity = cargo;
	}

	public Truck() 
	{
		super();
		TruckBase.capacity = 1000;//original capacity
	}
	

}
