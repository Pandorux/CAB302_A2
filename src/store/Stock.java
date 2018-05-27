package store;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exceptions.CSVFormatException;
import exceptions.StockException;

public class Stock {
	
	private HashMap<String, ArrayList<Item>> items;
	
	public Stock() {
		items = new HashMap<String, ArrayList<Item>>();
	}
	
	public int getQuantity(String itemName) {
		if(items.containsKey(itemName))
			return items.size();
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
		for(String i: items.keySet()) {
			System.out.println(i);
		}
	}
	
	public void addItem(Item item) {
		if(!items.containsKey(item.getName().toUpperCase()))
			items.put(item.getName().toUpperCase(), new ArrayList<Item>());
		items.get(item.getName().toUpperCase()).add(item);
	}
	
	// TODO:
	public ArrayList<Item> removeItems(String itemName, int amt) throws StockException {
		System.out.println(items.containsKey(itemName.toUpperCase()));
		return new ArrayList<Item>();
//		if(!items.containsKey(itemName)) {
//			throw new StockException(itemName + "does not exist");
//		}
//		else if(items.get(itemName).size() < Math.abs(amt)) {
//			throw new StockException("Cannot remove " + amt + itemName + "; there is only " + items.get(itemName).size());
//		}
//		else {
//			ArrayList<Item> removedItems = (ArrayList<Item>) items.get(itemName).subList(0, amt);
//			for(Item i: removedItems) {
//				items.get(itemName).remove(i);
//			}
//			return removedItems;
//		}
	
	}
	
	public ArrayList<Item> removeItems(String itemName) throws StockException {
		System.out.println(items.containsKey(itemName.toUpperCase()));
		return new ArrayList<Item>();
//		if(!items.containsKey(itemName)) {
//			throw new StockException(itemName + "does not exist");
//		}
//		else {
//			ArrayList<Item> removedItems = items.get(itemName);
//			items.get(itemName).clear();
//			return removedItems;
//		}
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

}
