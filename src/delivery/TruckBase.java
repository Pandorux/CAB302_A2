package delivery;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import delivery.TruckBaseTest.DummyItem;
import exceptions.DeliveryException;
import store.Item;

public abstract class TruckBase {

	protected static int totalTrucks = 0;
	
	protected ArrayList<Item> cargo = new ArrayList<Item>();//Trucks inventory

	protected final int id;
	protected int capacity;//max capacity of normal truck	
	
	//public Object Truck = invenObjects.size();

	//make standby trucks
	
	

	public TruckBase(int capacity) 
	{
		totalTrucks++;
		this.id = totalTrucks;
		this.capacity = capacity;
	}
	
	public TruckBase()
	{
		totalTrucks++;
		this.id = totalTrucks;	
		this.capacity = 1000;
	}
	
	public static int getTotalTrucks() {
		return totalTrucks;
	}
	
	/**
	 * 
	 * @author n9999884
	 * 
	 * @param createCargo adds the cargo that the truck should have to the cargo
	 */	
	public void addItems(ArrayList<Item> items) throws DeliveryException
	{
		if(cargo.size() + items.size() > capacity)
			throw new DeliveryException("This truck cannot contain more than " + capacity + " items at a time");
		else
			cargo.addAll(items);//add the cargo of the truck to the trucks cargo		
	}

	
	/**
	 * 
	 * @return  returns the cost that the truck will have to make a trip
	 */
	public double getCost() //assuming this truck is not being cooled
	{
		return (750 + (0.25 * cargo.size()));
	}

	/**
	 * 
	 * @param string the item that the function should remove
	 */
	public void removeItem(String string) 
	{
		for (int i = 0; i < cargo.size() - 1; i++)
		{
			if (cargo.get(i).getName() == string)
			{
				cargo.remove(i);
			}
		}
	}

	
	/**
	 * 
	 * @param string  view the item and its details 
	 * @return  the item and its relevant info
	 */
	public Item getItem(String name) 
	{
		for (int i = 0; i < cargo.size(); i++)
		{
			if (cargo.get(i).getName() == name)
			{
				return cargo.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param item  adds the object into the inventory of the truck
	 */
	public void addItem(Item item) throws DeliveryException
	{
		if(cargo.size() + 1 > capacity)
			throw new DeliveryException("This truck cannot contain more than " + capacity + " items at a time");
		else
			cargo.add(item);//add the cargo of the truck to the trucks cargo	
	}

	
	/**
	 * 
	 * @param item  the item the user wants to view
	 * @return return the objects information
	 */
	public Item getItem(Item item) 
	{
		for (int i = 0; i < cargo.size(); i++)
		{
			if (cargo.get(i) == item)
			{
				return cargo.get(i);
			}
		}
		return null;
	}


/**
 * 
 * @param i position in the inventory
 * @return the item at position i in the inventory
 */
	public Item getItem(int i) 
	{
		if(cargo.get(i) != null)
			return cargo.get(i);
		else
			return null;
	}

/**
 * 
 * @param items remove all items that aare passed theough as paramaters
 */

	public void removeItems(ArrayList<Item> items)
	{ 
		for(Item i: items) {
			cargo.remove(i);
		}	
	}

/**
 * 
 * @param string remove all items that have the name passed through the parameters
 */

	public void removeItems(String itemName) 
	{
		int count = 0;
		for(Iterator<Item> i = cargo.iterator(); i.hasNext();) {
			if(i.next().getName() == itemName)
				i.remove();
		}

		System.out.println(count + " Milk Removed");
	}
	
	/**
	 * 
	 * @param string  the name of the item
	 * @return all items with the name passed as the paramater
	 */
	
	public ArrayList<Item> getItems(String itemName) //a array of items that have the name ...
	{
		ArrayList<Item> items = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)//search through all items
		{
			if (cargo.get(i).getName() == itemName)//for each object found that is what we are looking for
			{
				items.add(cargo.get(i));
			}
		}
		
		return items;//then return the list
	}
	
	
	public ArrayList<Item> getItems(Item item) //a array of items ...
	{
		ArrayList<Item> items = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)//search through all items
		{
			if (cargo.get(i) == item)//for each object found that is what we are looking for
			{
				items.add(cargo.get(i));
			}
		}
		
		return items;//then return the list
	}
	
	/**
	 * 
	 * @param temp get all the items with the temprature of temp or lower
	 * @return return these items
	 */
	public ArrayList<Item> getItems(double temp)//needs checkTemprature to be implemented in item to work
	{
		// TODO: Fix Naming
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)
		{			
			if (cargo.get(i).getTemperature() == temp)//if object has temp i
			{
				List_of_things.add(cargo.get(i));//add it to a list
			}
		}
		
		return List_of_things;//show all items that are below a temp
	}


/**
 * 
 * @param temp remove all items with a temprature of temp or lower
 */
	public void removeItems(double temp)//needs checkTemprature to be implemented in item to work
	{
		
		for (int i = 0; i < cargo.size(); i++)
		{			
			if (cargo.get(i).getTemperature() == temp)//if object has temp i
			{
				cargo.remove(cargo.get(i));//remove
			}
		}
	}

	public void empty() 
	{
		cargo.clear();
	}

	/**
	 * 
	 * @return finds the id of a truck
	 */
	
	public Integer getId() 
	{
		return this.id;
	}

	/**
	 * 
	 * @return the capasity of the truck 
	 */
	
	public Integer getCapacity() 
	{
		return this.capacity;
	}
	
	/**
	 * 
	 * @return the temprature of a truck
	 */
	public static double getTemp() 
	{
		return RefrigeratedTruck.temperature;
	}

	public ArrayList<Item> getItemsWithTempUnder(int temp) 
	{
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		for (int i = 0; i < cargo.size(); i++)
		{			
			if (cargo.get(i).getTemperature() <= temp)//if object is cooler then temp
			{
				List_of_things.add(cargo.get(i));//add it to the list
			}
		}
		return List_of_things;
	}

	public ArrayList<Item> getItemsWithTemp(int temp) 
	{
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)
		{			
			if (cargo.get(i).getTemperature() == temp)//if object is cooler then temp
			{
				List_of_things.add(cargo.get(i));//add it to the list
			}
		}
		return List_of_things;
	}

	public ArrayList<Item> getItemsWithTempOver(int temp) 
	{
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)
		{			
			if (cargo.get(i).getTemperature() > temp)//if object is cooler then temp
			{
				List_of_things.add(cargo.get(i));//add it to the list
			}
		}
		return List_of_things;
	}

	public Integer getTotalItems() 
	{
		return cargo.size();
	}

	public ArrayList<Item> getItemsTempEqual(double temp) {
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item i: cargo) {
			if(i.getTemperature() == temp)
				items.add(i);
		}
		return items;
	}

	public void removeItem(Item item) {
		cargo.remove(item);
	}

	public ArrayList<Item> getItemsTempLess(int temp) {
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item i: cargo) {
			if(i.getTemperature() < temp)
				items.add(i);
		}
		return items;
	}

	public ArrayList<Item> getItemsTempMore(int temp) {
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item i: cargo) {
			if(i.getTemperature() > temp)
				items.add(i);
		}
		return items;
	}



	



	
}
