package store;
package exceptions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.CSVFormatException;

public class Stock {

	private HashMap<String, Pair<Item, Integer>> storeProducts;
	
	public Stock() {
		storeProducts = new HashMap<String, ArrayList<Item>>();
	}
	
	public void removeAll() {
		for(Iterator<String> i = storeProducts.keySet().iterator(); i.hasNext();) {
			storeProducts.get(i.next()).clear();
		}
	}	
	
	// TODO: How to add item?
	public void addItem(String itemName, int amt) {
		//storeProducts.get(itemName).add();
	}
	
	public static ArrayList<Item> importStockCSV(String filePath) throws CSVException{
		
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
