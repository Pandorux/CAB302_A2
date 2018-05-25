package delivery;

import java.util.ArrayList;

public class RefrigeratedTruck extends TruckBase {

	static double temprature;
	
	static ArrayList<Object> Inventory = new ArrayList<Object>();
	//public Object Inventory;

	
	/**
	 * 
	 * @param capacity will be the new max capacity of this truck
	 */
	public RefrigeratedTruck(int capacity) 
	{
		// TODO Auto-generated constructor stub
		super(capacity);
		this.temprature = FindTruckTemp();//does not have a temp?////////////////////////////////////////////////////////////////////
	}

	/**
	 * no paramaters, thus its a default truck
	 */
	public RefrigeratedTruck() 
	{
		// TODO Auto-generated constructor stub
		super ();
		this.capacity = 800;//capasity is specified to be 800 in task sheet
		temprature = FindTruckTemp();
	}

	/**
	 * find all items in the trucks inventory
	 * for each item find its temperature
	 * keep the lowest temperature
	 * @return the lowest temperature needed to keep everything frozen as the trucks temp
	 */
	
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
	/**
	 * makes the cost of the truck change if the truck needs cooling
	 */
	@Override
	public double getCost() //assuming this truck is not being cooled
	{
		return 900 + 200 * java.lang.Math.pow((0.7), temprature/5);//900+200 * 0.7^t/5
	}
			
}
