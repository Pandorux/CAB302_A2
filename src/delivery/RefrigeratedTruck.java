package delivery;

import java.util.ArrayList;

public class RefrigeratedTruck extends TruckBase {

	int iD;
	int capasity;
	static int temprature;
	
	static ArrayList<Object> Inventory = new ArrayList<Object>();
	//public Object Inventory;

	public RefrigeratedTruck(int iD, int Capasity, int Temprature) 
	{
		// TODO Auto-generated constructor stub
		super (iD, Capasity);
		this.iD = iD;
		this.capacity = Capasity;
		RefrigeratedTruck.temprature = Temprature;
	}


}
