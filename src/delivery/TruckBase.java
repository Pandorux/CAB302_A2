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
	
	public TruckBase()
	{
		totalTrucks++;
		this.id = totalTrucks;	
		this.capacity = 1000;
	}
	
	public TruckBase(int capacity) 
	{
		totalTrucks++;
		this.id = totalTrucks;
		this.capacity = capacity;
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
		cargo.add(item);//add the cargo of the truck to the trucks cargo	
	}

	
	/**
	 * 
	 * @param item  the item the user wants to view
	 * @return return the objects information
	 */

	public Object getItem(Item item) 
	{
		for (int i = 0; i < cargo.size() - 1; i++)
		{
			if (cargo.get(i) == item)
			{
				return cargo.get(i);
			}
		}
		return "Error, item not found";
	}



	public Object getItem(int i) 
	{
		return cargo.get(i);
	}



	public void removeItems(ArrayList<Item> items)
	{
		cargo.remove(items);
		
	}



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



	public Object getItems(String string) 
	{
		ArrayList<Object> List_of_things = new ArrayList<Object>();
		
		for (int i = 0; i < cargo.size(); i++)//search through all items
		{
			if (cargo.get(i).getName() == string)//for each object found that is what we are looking for
			{
				RefrigeratedTruck.Inventory.add(cargo.get(i));//add cold item to cold truck
			}
		}
		
		return List_of_things;//then return the list
	}



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
		for (int l = 0; l < cargo.size(); l++)//remove everything
		{
			cargo.remove(l);
		}
	}


	

	public Item addItem(String name, int i) 
	{
		Item thing = addItem(name, i);//have a item factory here probs
		RefrigeratedTruck.Inventory.add(thing);
		return thing;
	}

	public Integer getId() 
	{
		return this.id;
	}

	public Object getCapacity() 
	{
		return this.capacity;
	}
/*
	public void setTemp(int i) 
	{
		RefrigeratedTruck.temprature = i;	
	}

	public static double getTemp() 
	{
		return RefrigeratedTruck.temprature;
	}
*/
	



	
}
