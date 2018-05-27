package store;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.CSVFormatException;
import exceptions.StockException;
import javafx.util.Pair;

public class Stock {
	
	private static HashMap<String, ArrayList<Item>> items;

	public Stock() {
		items = new HashMap<String, ArrayList<Item>>();
	}
	
	public HashMap<String, ArrayList<Item>> returnStock()
	{
		return items;
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
	public static ArrayList<Item> removeItems(String itemName, int amt) throws StockException {
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
	
	public static ArrayList<Item> removeItems(String itemName) throws StockException {
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

		try {	
			ArrayList<Item> items = new ArrayList<Item>();
			while (inputStream.hasNext()) {
				String[] params = inputStream.next().split(",");
				// TODO: Append to Sales Log
			}
			return items;
		}
		catch (CSVFormatException e) {
			
		}	
	}
	
   public static String giveInventory()
   {
       if (items.size() == 0)
       {
           return "";
       }
       else
       {
           return items.toString();
       }

   }


   public static ArrayList<Item> getItem(String name)
   public boolean getItem(String name)
   {
       if (items.size() == 0)
       {
    	   System.out.println("list is empty");
           return null;
       }
       else
       {
           for (String key: items.keySet())//for every item
           {
        	   System.out.println("Checking against " + name);
        	   System.out.println("key: " + key);
               if (key.equalsIgnoreCase(name))//if the primary field (name) is the same as the searched name
               {
            	   return items.get(key); //return the item at the current index
               }
           }
           System.out.println("not in list");
           return null;//it doesnt exist
       }
   }
   
   public static ArrayList<Item> printAllItems()
   {
	   ArrayList<Item> potato = new ArrayList<Item>();
	   for (int i = 0; i < items.size(); i++)
	   {
		   potato.addAll(items.get(i));
	   }
	   
	return potato;
	   
   }

	/**
	 * @author n9999884
	 * @return 
	 */
	public static String giveInventory()
	{
		if (storeProducts.size() == 0)
		{
			return null;
		}
		else
		{
			return storeProducts.toString();
		}
		
	}
	
}
