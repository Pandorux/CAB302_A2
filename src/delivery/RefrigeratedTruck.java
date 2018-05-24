package delivery;

import java.util.ArrayList;

public class RefrigeratedTruck extends TruckBase {

	double temprature;
	
	static ArrayList<Object> Inventory = new ArrayList<Object>();
	//public Object Inventory;

	public RefrigeratedTruck(int capacity) 
	{
		// TODO Auto-generated constructor stub
		super(capacity);
		this.temprature = FindTruckTemp();//does not have a temp?////////////////////////////////////////////////////////////////////
	}

	
	public RefrigeratedTruck() 
	{
		// TODO Auto-generated constructor stub
		super ();
		this.capacity = 800;//capasity is specified to be 800 in task sheet
		temprature = FindTruckTemp();
	}

	double FindTruckTemp()
	{
		for (int i = 0; i < Inventory.size(); i++)
		{
			if(Double.isNaN(temprature)) 
			{
				temprature = cargo.get(i).getTemperature();
			}
			else if (cargo.get(i).getTemperature() < temprature)
			{
				temprature = cargo.get(i).getTemperature();
			}
		}
		return temprature; 
	}
	
	@Override
	public double getCost() //assuming this truck is not being cooled
	{
		return 900 + 200 * java.lang.Math.pow((0.7), temprature/5);//900+200 * 0.7^t/5
	}
			
}
