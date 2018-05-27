package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exceptions.CSVFormatException;
import javafx.util.Pair;

public class Store {

	protected static Store instance = new Store();
	static HashMap<Integer, Pair<String, Integer >> salesList;//id, name, quantity
	
	private static int salesId;
	
	private String name;
	private Stock inventory;
	private double capital;

	// TODO: throw exception if store alreadys exists?
	protected Store() {	
		name = "";
		inventory = new Stock();
		capital = 0.0;
		salesList = new  HashMap<Integer, Pair<String, Integer >>();//initialise
		salesId = 0;
	}
	
	/**
	 * @author n9999884
	 * @param item
	 */
	public void Sale(String item, Integer quantity)//item being sold
	{
		inventory.removeItems(item, quantity);
		salesList.put(salesId, new Pair<String, Integer>(item, quantity));
		salesId++;
	}
	
	public static Store getInstance() {
		return instance;
	}
	
	public void addCapital(double amt) throws IndexOutOfBoundsException {
		if(amt < 0) 
			throw new IndexOutOfBoundsException("Input amount cannot be less than 0");
		else
			capital += amt;
	}
	
	public void removeCapital(double amt) {
		capital -= Math.abs(amt);
	}
	
	public String getName() {
		return name;
	}
	
	public void renameStore(String storeName) {
		name = storeName;
	}
	
	/**
	 * <h1>Deconstructor method<h1>
	 * <br>
	 * <br>
	 * Sets all values of class to their beginning state.
	 */
	public void deconstruct() {
		instance = new Store();		
	}

	public double getCapital() {
		return capital;
	}

	public Stock getInventory() {
		return inventory;
	}
	
	
	/**
	 * @author n9999884
	 * @return the list in a string so thay
	 */
	public static HashMap<Integer, Pair<String, Integer>> giveSalesList()
	{
		if (salesList.size() == 0)
		{
			return salesList;
		}
		else 
		{
			return null;
		}
	}
	
	public static ArrayList<Item> importStockCSV(String filePath) throws CSVFormatException, FileNotFoundException{
		
		File file = new File(filePath);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter("(\\s\n)"); // Separates CSV lines
		

		try {	
			ArrayList<Item> items = new ArrayList<Item>();
			while (inputStream.hasNext()) {
				String[] params = inputStream.next().split(",");
				salesList.put(salesId, new Pair<String, Integer>(params[0], Integer.parseInt(params[1])));
			}
			return items;
		}
		catch (CSVFormatException e) {
			throw new CSVFormatException("Incorrect format used");
		}	
	}
	
}
