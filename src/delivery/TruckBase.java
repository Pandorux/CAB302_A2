package delivery;

import java.util.ArrayList;
import java.util.InputMismatchException;

import delivery.TruckBaseTest.DummyItem;
import store.Item;

public abstract class TruckBase {

	protected int totalTrucks = 0;
	
	protected ArrayList<Item> cargo = new ArrayList<Item>();//Trucks inventory

	protected static int id;
	protected static int capacity;//max capacity of normal truck	
	
	//public Object Truck = invenObjects.size();

	//make standby trucks
	
	
	/**
	 * 
	 * @param capacity2  its id and capacity of the truck
	 */
	
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
	

	
	/**
	 * 
	 * @author n9999884
	 * 
	 * @param createCargo adds the cargo that the truck should have to the cargo
	 */
	
	public void addItems(ArrayList<Item> items) 
	{
		cargo.addAll(items);//add the cargo of the truck to the trucks cargo		
	}

	
	/**
	 * 
	 * @return  returns the cost that the truck will have to make a trip
	 */
	
	public double getCost() //assuming this truck is not being cooled
	{
		return (750 + (0.25 * capacity));
	}

	/*
	
	
	public void addItems(String Item) 
	{
		if (cargo.size() < capacity)//if not full
		{
			cargo.add(Item);//add the item to the inventory of objects
		}
			
		
	}
*/
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
		for (int i = 0; i < cargo.size() - 1; i++)
		{
			if (cargo.get(i).getName() == name)
			{
				return (Item) cargo.get(i);
			}
		}
		throw new InputMismatchException();
	}

	/**
	 * 
	 * @param item  adds the object into the inventory of the truck
	 */

	public void addItems(Item item)
	{
		if (item.getQuantity() <= 0)//if negitive input or 0
		{
			
		}
		else 
		{
			cargo.add(item);//add the cargo of the truck to the trucks cargo	
		}
		
	}

	
	/**
	 * 
	 * @param item  the item the user wants to view
	 * @return return the objects information
	 */

	public Item getItem(Item item) 
	{
		for (int i = 0; i < cargo.size() - 1; i++)
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
		return cargo.get(i);
	}

/**
 * 
 * @param items remove all items that aare passed theough as paramaters
 */

	public void removeItems(ArrayList<Item> items)
	{
		cargo.remove(items);
		
	}

/**
 * 
 * @param string remove all items that have the name passed through the parameters
 */

	public void removeItems(String string) 
	{
		for (int i = 0; i < cargo.size(); i++)
		{
			if (cargo.get(i).getName() == string)
			{
				cargo.remove(i);
			}
		}
		
	}
	
	/**
	 * 
	 * @param string  the name of the item
	 * @return all items with the name passed as the paramater
	 */
	
	public ArrayList<Item> getItems(String string) //a array of items that have the name ...
	{
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)//search through all items
		{
			if (cargo.get(i).getName() == string)//for each object found that is what we are looking for
			{
				RefrigeratedTruck.Inventory.add(cargo.get(i));//add cold item to cold truck
			}
		}
		
		return List_of_things;//then return the list
	}
	
	
	public ArrayList<Item> getItems(Item thing) //a array of items ...
	{
		ArrayList<Item> List_of_things = new ArrayList<Item>();
		
		for (int i = 0; i < cargo.size(); i++)//search through all items
		{
			if (cargo.get(i) == thing)//for each object found that is what we are looking for
			{
				RefrigeratedTruck.Inventory.add(cargo.get(i));//add cold item to cold truck
			}
		}
		
		return List_of_things;//then return the list
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


/**
 * remove everything
 */
	public void empty() 
	{
		for (int l = 0; l < cargo.size(); l++)//remove everything
		{
			cargo.remove(l);
		}
	}


	/**
	 * 
	 * @param name add a new item 
	 * @param i how many of said item
	 * @return return the paramaters as a new item
	 */

	public Item addItem(String name, int i) 
	{
		Item thing = addItem(name, i);//have a item factory here probs
		RefrigeratedTruck.Inventory.add(thing);
		return thing;
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
	 * @param i set the temp of the truck to i
	 * 
	 */
	public void setTemp(int i) //the temp can only be of a refregerated truck
	{
		RefrigeratedTruck.temprature = i;	//obselete since this is automated
	}

	
	/**
	 * 
	 * @return the temprature of a truck
	 */
	public static double getTemp() 
	{
		return RefrigeratedTruck.temprature;
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
			if (cargo.get(i).getTemperature() >= temp)//if object is cooler then temp
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

	



	
}
