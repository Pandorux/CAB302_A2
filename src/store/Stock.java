package store;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.CSVFormatException;
import exceptions.StockException;

public class Stock {
	
	private HashMap<String, ArrayList<Item>> items;

	public Stock() {
		items = new HashMap<String, ArrayList<Item>>();
	}
	
	public int getQuantity(String itemName) {
		if(items.containsKey(itemName.toUpperCase()))
			return items.get(itemName.toUpperCase()).size();
		else
			return 0;
	}
 
	public void removeAll() {
		items.clear();
	}	
	
	public int length() {
		int count = 0;
		for(ArrayList<Item> i: items.values()) {
			count += i.size();
		}
		return count;
	}
	
	public void addItems(ArrayList<Item> newItems) {
		for(Item i: newItems) {
			addItem(i);
		}
	}
	
	public void addItem(Item item) {
		if(!items.containsKey(item.getName().toUpperCase()))
			items.put(item.getName().toUpperCase(), new ArrayList<Item>());
		items.get(item.getName().toUpperCase()).add(item);
	}
	
	// TODO:
	public ArrayList<Item> removeItems(String itemName, int amt) throws StockException {
		itemName = itemName.toUpperCase();
		if(!items.containsKey(itemName)) {
			throw new StockException(itemName + "does not exist");
		}
		else if(items.get(itemName).size() < Math.abs(amt)) {
			throw new StockException("Cannot remove " + amt + itemName + "; there is only " + items.get(itemName).size());
		}
		else {
			ArrayList<Item> removedItems = new ArrayList<Item>();
			for(Iterator<Item> i = items.get(itemName).subList(0, amt).iterator(); i.hasNext();) {
				removedItems.add(i.next());
				i.remove();
			}
			return removedItems;
		}
	
	}
	
	public ArrayList<Item> removeItems(String itemName) throws StockException {
		itemName = itemName.toUpperCase();
		if(!items.containsKey(itemName)) {
			throw new StockException(itemName + "does not exist");
		}
		else {
			ArrayList<Item> removedItems = new ArrayList<Item>();
			for(Item i: items.get(itemName)) {
				removedItems.add(i);
			}
			
			items.get(itemName).clear();
			return removedItems;
		}
	}

   public boolean getItem(String name)
   {
       if (items.size() == 0)
       {
           return false;
       }
       else
       {
           for (int i = 0; i < items.size(); i++)//for every item
           {
               if (items.containsKey(name))//if the primary field (name) is the same as the searched name
               {
                   return true;//return that it exists
               }
           }
           return false;//it doesnt exist
       }

	/**
	 * @author n9999884
	 * @return 
	 */
	public String giveInventory()
	{
		if (items.size() == 0)
		{
			return null;
		}
		else
		{
			return items.toString();
		}
		
	}
	
}
