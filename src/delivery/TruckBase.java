package delivery;

import java.util.ArrayList;
import java.util.InputMismatchException;

import delivery.TruckBaseTest.DummyItem;
import store.Item;

public abstract class TruckBase {

	protected static int totalTrucks = 1;
	
	ArrayList<Object> invenObjects = new ArrayList<Object>();//Trucks inventory

	protected static int id;
	private int capacity;//max capacity of normal truck
	
	//public Object Truck = invenObjects.size();

	//make standby trucks
	
	
	/**
	 * 
	 * @param capacity2  its id and capacity of the truck
	 */
	
	public TruckBase()
	{
		this.capacity = 1000;
		this.id = totalTrucks;
		totalTrucks++;		
	}
	
	public TruckBase(int capacity) 
	{
		this.capacity = capacity;
		this.id = totalTrucks;
		totalTrucks++;
	}
	
	/**
	 * 
	 * @author n9999884
	 * 
	 * @param createCargo adds the cargo that the truck should have to the cargo
	 */
	
	public void addItems(ArrayList<Object> createCargo) 
	{
		
		invenObjects.add(createCargo);//add the cargo of the truck to the trucks cargo		
	}

	
	/**
	 * 
	 * @return  returns the cost that the truck will have to make a trip
	 */
	
	public Object getCost() //assuming this truck is not being cooled
	{
		if (temp == Double.NaN)//if not refregerated
		{
			return (750 + (0.25 * (double)capacity));
		}
		else //if refregerated
		{
			return java.lang.Math.pow((900 + 200 * 0.7), temp/5);//900+200 * 0.7^t/5
		}
	}

	
	/**
	 * 
	 * @param dummyItem  inserts a item into the trucks inventory
	 */
	
	public void addItems(String Item) 
	{
		if (invenObjects.size() < (int)capacity)//if not full
		{
			invenObjects.add(Item);//add the item to the inventory of objects
		}
			
		
	}

	/**
	 * 
	 * @param string the item that the function should remove
	 */
	
	
	public void removeItem(String string) 
	{
		for (int i = 0; i < invenObjects.size() - 1; i++)
		{
			if (invenObjects.get(i) == string)
			{
				invenObjects.remove(i);
			}
		}
	}

	
	/**
	 * 
	 * @param string  view the item and its details 
	 * @return  the item and its relevant info
	 */
	
	public Item getItem(String string) 
	{
		for (int i = 0; i < invenObjects.size() - 1; i++)
		{
			if (invenObjects.get(i) == string)
			{
				return (Item) invenObjects.get(i);
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
		invenObjects.add(item);//add the cargo of the truck to the trucks cargo	
		
	}

	
	/**
	 * 
	 * @param item  the item the user wants to view
	 * @return return the objects information
	 */

	public Object getItem(Item item) 
	{
		for (int i = 0; i < invenObjects.size() - 1; i++)
		{
			if (invenObjects.get(i) == item)
			{
				return invenObjects.get(i);
			}
		}
		return "Error, item not found";
	}



	public Object getItem(int i) 
	{
		return invenObjects.get(i);
	}



	public void removeItems(ArrayList<Item> items)
	{
		invenObjects.remove(items);
		
	}



	public void removeItems(String string) 
	{
		for (int i = 0; i < invenObjects.size(); i++)
		{
			if (invenObjects.get(i) == string)
			{
				invenObjects.remove(i);
			}
		}
		
	}



	public Object getItems(String string) 
	{
		ArrayList<Object> List_of_things = new ArrayList<Object>();
		
		for (int i = 0; i < invenObjects.size(); i++)//search through all items
		{
			if (invenObjects.get(i) == string)//for each object found that is what we are looking for
			{
				RefrigeratedTruck.Inventory.add(invenObjects.get(i));//add cold item to cold truck
			}
		}
		
		return List_of_things;//then return the list
	}



	public Object getItems(int i)//needs checkTemprature to be implemented in item to work
	{
		ArrayList<Object> List_of_things = new ArrayList<Object>();
		
		for (int l = 0; l < invenObjects.size(); l++)
		{
			Object thing = invenObjects.get(l);
			
			if (Item.checkTemprature(thing) == i)//if object has temp i
			{
				RefrigeratedTruck.Inventory.add(thing);//add it to a list
			}
		}
	}



	public void removeItems(int i)//needs checkTemprature to be implemented in item to work
	{
		ArrayList<Object> List_of_things = new ArrayList<Object>();
		
		for (int l = 0; l < invenObjects.size(); l++)
		{
			Object thing = invenObjects.get(l);
			
			if (Item.checkTemprature(thing) == i)//for each object found
			{
				RefrigeratedTruck.Inventory.remove(thing);//add it to a list
			}
		}
	}



	public void empty() 
	{
		for (int l = 0; l < invenObjects.size(); l++)//remove everything
		{
			invenObjects.remove(l);
		}
	}


	


	public void setTemperature(int i)
	{
		RefrigeratedTruck.temprature = i;	
	}


	public void addItem(String string, int i) 
	{
		Object thing = Inventory(string, i);//have a item factory here probs
		RefrigeratedTruck.Inventory.add(thing);
		error, look here later
	}

	public Integer getId() 
	{
		return this.id;
	}

	public Object getCapacity() 
	{
		return this.capacity;
	}

	public void setTemp(int i) 
	{
		RefrigeratedTruck.temprature = i;	
	}

	public double getTemp() 
	{
		return RefrigeratedTruck.temprature;
	}

	



	
}
