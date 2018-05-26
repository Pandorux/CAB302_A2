package store;
import exceptions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.CSVFormatException;
import javafx.util.Pair;

public class Stock {

	private HashMap<String, Pair<Item, Integer>> storeProducts;
	
	public Stock() {
		storeProducts = new HashMap<String, Pair<Item, Integer>>();
	}
	
	public void removeAll() {

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

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}



	
}
