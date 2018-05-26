package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;

/**
 * 
 * @author Jared Carey
 *
 */
public class Item {

	private String name;
	private double manufactureCost;
	private double retailPrice;
	private String reorderPoint;
	private int reorderAmount;
	private double temperature;
	
	public Item(String name, double manufactureCost, double retailPrice, 
			String reorderPoint, int reorderAmount) {
		this.name = name;
		this.manufactureCost = manufactureCost;
		this.retailPrice = retailPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperature = Double.NaN;
	}
	
	public Item(String name, double manufactureCost, double retailPrice, 
			String reorderPoint, int reorderAmount, double temperature) {
		this.name = name;
		this.manufactureCost = manufactureCost;
		this.retailPrice = retailPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperature = temperature;
	}
	
	public String getName() {
		return name;
	}
	
	public void rename(String newName) {
		this.name = newName;
	}
	
	public double findRetailPrice() {
		return retailPrice;
	}

	public void increaseReorderAmount(int amt) throws IndexOutOfBoundsException{	
		if(amt < 0)
			throw new IndexOutOfBoundsException("Input amount cannot be less than 0");
		else
			reorderAmount += amt;
	}
	
	// TODO: add exception to this when it goes under 0
	public void decreaseReorderAmount(int amt) {
		if(reorderAmount - Math.abs(amt) < 0)
			throw new IndexOutOfBoundsException("ReorderAmount cannot be less than 0");
		else
			reorderAmount -= amt;
	}
	
	public int findItemReorderAmount() {
		return reorderAmount;
	}

	public String findItemImportPoint() {
		return reorderPoint;
	}	
	
	public void changeReorderPoint(String loc) {
		reorderPoint = loc;
	}

	public double findItemManufactureCost() {
		return manufactureCost;
	}

	public double getTemperature() {
		return temperature;
	}
	
	public boolean checkTemperature() {
		if(Double.isNaN(temperature))
			return false;
		else
			return true;
	}

	public void increaseManufactureCost(double amt) throws IndexOutOfBoundsException {
		if(amt < 0)
			throw new IndexOutOfBoundsException("Input amount cannot be less than 0");
		else
			manufactureCost += amt;		
	}
	
	public void decreaseManufactureCost(double amt) {
		manufactureCost -= Math.abs(amt);	
	}

	public void increaseRetailPrice(double amt) throws IndexOutOfBoundsException {
		if(amt < 0)
			throw new IndexOutOfBoundsException("Input amount cannot be less than 0");
		else
			retailPrice += amt;
	}
	
	public void decreaseRetailPrice(double amt) {
		retailPrice -= Math.abs(amt);
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException 
	 * @throws CSVException
	 */
	public static ArrayList<Item> importItemCSV(String filePath) throws CSVFormatException, FileNotFoundException{
		
		File file = new File(filePath);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter("(\\s\n)"); // Separates CSV lines

		try {	
			ArrayList<Item> items = new ArrayList<Item>();
			while (inputStream.hasNext()) {
				String[] params = inputStream.next().split(",");
				
				switch(params.length) {
					
					case 5:
						items.add(new Item(params[0], Double.parseDouble(params[1]),
								Double.parseDouble(params[3]), params[2], 
								Integer.parseInt(params[4])));
						break;
				
					case 6:
						items.add(new Item(params[0], Double.parseDouble(params[1]),
								Double.parseDouble(params[3]), params[2], 
								Integer.parseInt(params[4]), Double.parseDouble(params[5])));
						break;
						
					default:
						inputStream.close();
						throw new CSVFormatException("Incorrect amount of attributes in CSV");
				}
			}
			inputStream.close();
			return items;
		}
		catch (CSVFormatException e) {
			inputStream.close();
			throw new CSVFormatException("Imported CSV does not meet format");
		}	
		
		
	}



}
	


