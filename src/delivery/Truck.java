package delivery;

import java.util.ArrayList;

public class Truck extends TruckBase {

	int ID; 
	int capasity;
	
	public Truck(int id, int capacity2)
	{
		super(id, capacity2);
		
		ID = id;
		capasity = capacity2;
		
	}
	public ArrayList<String> Inventory;//makes a inventory for the truck that is null initially

}
