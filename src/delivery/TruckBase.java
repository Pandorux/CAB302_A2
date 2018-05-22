package delivery;

import java.util.ArrayList;
import java.util.InputMismatchException;

import delivery.TruckBaseTest.DummyItem;
import store.Item;

public abstract class TruckBase {

	
	
	
	ArrayList<Object> invenObjects = new ArrayList<Object>();//Trucks inventory
	
	public int id;
	public int capacity;
	public int temp;
	
	//public Object Truck = invenObjects.size();

	//make standby trucks
	
	
	/**
	 * 
	 * @param capacity2  its id and capacity of the truck
	 */
	
	public TruckBase(int id, int capacity) //if its a normal truck
	{
		this.id = id;
		this.capacity = capacity;
		
	}
	
	public TruckBase(int id, int capacity, int temp) //if its a cold truck
	{
		this.id = id;
		this.capacity = capacity;
		this.temp = temp;
		
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
		return (750 + (0.25 * (double)capacity));
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





	}


	public void setTemperature(int i)
	{
		RefrigeratedTruck.temprature = i;	
		
	}


	public void addItem(String string, int i) 
	{
		Object thing = Inventory(string, i);//have a item factory here probs
		RefrigeratedTruck.Inventory.add(thing);
	}



	
}
