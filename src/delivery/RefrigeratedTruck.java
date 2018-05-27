package delivery;

import java.util.ArrayList;

import exceptions.DeliveryException;
import store.Item;

public class RefrigeratedTruck extends TruckBase {
	
	public final double maxTemp = 10;
	public final double minTemp = -20;
	
	private double temperature;
	
	/**
	 * 
	 * @param capacity will be the new max capacity of this truck
	 */
	public RefrigeratedTruck(int capacity) 
	{
		// TODO Auto-generated constructor stub
		super(capacity);
		this.temperature = FindTruckTemp();//does not have a temp?////////////////////////////////////////////////////////////////////
	}

	/**
	 * no paramaters, thus its a default truck
	 */
	public RefrigeratedTruck() 
	{
		// TODO Auto-generated constructor stub
		super ();
		this.capacity = 800;//capasity is specified to be 800 in task sheet
		temperature = FindTruckTemp();
	}

	/**
	 * find all items in the trucks inventory
	 * for each item find its temperature
	 * keep the lowest temperature
	 * @return the lowest temperature needed to keep everything frozen as the trucks temp
	 */
	
	double FindTruckTemp()
	{
		for (int i = 0; i < cargo.size(); i++)
		{
			if(Double.isNaN(temperature)) 
			{
				temperature = cargo.get(i).getTemperature();
			}
			else if (cargo.get(i).getTemperature() < temperature)
			{
				temperature = cargo.get(i).getTemperature();
			}
		}
		return temperature; 
	}
	
	/**
	 * 
	 * @param name add a new item 
	 * @param i how many of said item
	 * @return return the paramaters as a new item
	 */
	@Override
	public void addItem(Item item) throws DeliveryException
	{
		if(item.checkTemperature()) {
			if(item.getTemperature() < minTemp || maxTemp < item.getTemperature()) {
				throw new DeliveryException("This truck cannot contain an item with a temperature of " + item.getTemperature());
			}
		}
			super.addItem(item);
	}
	
	/**
	 * makes the cost of the truck change if the truck needs cooling
	 */
	@Override
	public double getCost() //assuming this truck is not being cooled
	{	if(Double.isNaN(temperature))
			return 900 + 200;
		else
			return 900 + 200 * java.lang.Math.pow((0.7), temperature/5);//900+200 * 0.7^t/5
	}
	
	/**
	 * 
	 * @param i set the temp of the truck to i
	 * 
	 */
	public void setTemp(double temp) throws DeliveryException //the temp can only be of a refregerated truck
	{
		if(temp < minTemp || maxTemp < temp) {
			throw new DeliveryException(temp + " is not in temperature range");
		}
		else {
			temperature = temp;
		}
	}
				
}
