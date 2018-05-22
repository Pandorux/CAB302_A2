package delivery;

import java.util.ArrayList;
import java.util.InputMismatchException;

import delivery.TruckBaseTest.DummyItem;
import store.Item;

public abstract class TruckBase {

	
	
	
	ArrayList<Object> invenObjects = new ArrayList<Object>();//Trucks inventory
	
	public int id;
	public Object capacity;

	public Object totalItems = invenObjects.size();
	
	/**
	 * 
	 * @param capacity2  capacity of the truck
	 */
	
	public TruckBase(int id, int capacity) 
	{
		this.id = id;
		this.capacity = capacity;
	}


	
	/**
	 * 
	 * @author n9999884
	 * 
	 * @param createCargo adds the cargo that the truck should have to the cargo
	 */
	
	public void addItems(ArrayList<DummyItem> createCargo) 
	{
		invenObjects.add(createCargo);//add the cargo of the truck to the trucks cargo		
	}

	
	/**
	 * 
	 * @return  returns the cost that the truck will have to make a trip
	 */
	
	public Object getCost() //assuming this truck is not being cooled
	{
		return (750 + (0.25 * (double)capacity));
	}

	
	/**
	 * 
	 * @param dummyItem  inserts a item into the trucks inventory
	 */
	
	public void addItems(String Item) 
	{
		if (invenObjects.size() < (int)capacity)
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return invenObjects.get(i);
	}



	public void removeItems(ArrayList<DummyItem> items)
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



	
}
