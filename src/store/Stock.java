package store;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exceptions.CSVFormatException;
import exceptions.StockException;
import javafx.util.Pair;

public class Stock {
	
	private static HashMap<String, ArrayList<Item>> items;

	static HashMap<String, Pair<Item, Integer>> storeProducts;
	
	public Stock() {
		items = new HashMap<String, ArrayList<Item>>();
	}
	
	public HashMap<String, ArrayList<Item>> returnStock()
	{
		return items;
	}
	
	public int getQuantity(String itemName) {
		if(items.containsKey(itemName.toUpperCase()))
			return items.get("MILK").size();
		else
			return 0;
	}
	
	public void removeAll() {
		
	}	
	
	public int length() {
		int count = 0;
		System.out.println("Working");
		System.out.println(items.values());
//		for(ArrayList<Item> i: items.values()) {
//			System.out.println(i.size());
//			count += i.size();
//		}
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
			ArrayList<Item> removedItems = (ArrayList<Item>) items.get(itemName).subList(0, amt);
			for(Item i: removedItems) {
				items.get(itemName).remove(i);
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
			ArrayList<Item> removedItems = items.get(itemName);
			items.get(itemName).clear();
			return removedItems;
		}
	}
	
	public static ArrayList<Item> importStockCSV(String filePath) throws CSVFormatException{
		
		File file = new File(filePath);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter("(\\s\n)"); // Separates CSV lines
		

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
   {
       if (items.size() == 0)
       {
           return null;
       }
       else
       {
           for (int i = 0; i < items.size(); i++)//for every item
           {
               if (storeProducts.containsKey(name))//if the primary field (name) is the same as the searched name
               {
            	   return items.get(name); 
               }
           }
           return null;//it doesnt exist
       }
   }


}
