package delivery;

import java.util.ArrayList;

public class RefrigeratedTruck extends TruckBase {

	int iD;
	int capacity;
	static double temprature;
	
	static ArrayList<Object> Inventory = new ArrayList<Object>();
	//public Object Inventory;

	public RefrigeratedTruck(int capacity) 
	{
		// TODO Auto-generated constructor stub
		super(capacity);
		this.iD = FindAvalableId();
		this.temprature = FindTruckTemp();//does not have a temp?////////////////////////////////////////////////////////////////////
	}

	
	public RefrigeratedTruck() 
	{
		// TODO Auto-generated constructor stub
		super ();
		this.iD = FindAvalableId();
		this.capacity = 800;//capasity is specified to be 800 in task sheet
		RefrigeratedTruck.temprature = FindTruckTemp();
	}

	public double FindTruckTemp()
	{
		for (int i = 0; i < Inventory.size(); i++)
		{
			if (Truck.Inventory.Item.getTemperture() < this.temprature)
			{
				this.temprature = Truck.Inventory.Item.getTemperture();
			}
		}
		return temprature; 
	}
	
	public int FindAvalableId()
	{
		for (int i = 0; i < Manifest.Trucks.size(); i++)
		{
			if (TruckBase.id <= iD)//find highest Id in manafest
			{
				iD = TruckBase.id + 1;//one higher than the highest id in manafest
			}
		}
		return capacity;
		
	}
}
