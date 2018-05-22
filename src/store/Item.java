package store;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;

	
	public class Item {
		
		String name;
		double manufactureCost;
		double retailPrice;
		String reorderPoint;
		int reorderAmount;
		double temperature;
		
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
		
		public void increasePrice(double amt) {
			retailPrice += amt;
		}
		
		public String getName() {
			return name;
		}
		
		// TODO: add exception for when you go under 0
		public void decreasePrice(double amt) {
			retailPrice -= amt;
		}

		public double findItemCost() {
			return manufactureCost;
		}

		public void increaseReorderAmount(int amt) {
			reorderAmount += amt;
		}
		
		// TODO: add exception to this when it goes under 0
		public void decreaaseReorderAmount(int amt) {
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
		
		public void increaseCost(double amt) {
			manufactureCost += amt;	
		}
		
		public void decreaseCost(double amt) {
			manufactureCost -= amt;	
		}
		
		/**
		 * 
		 * @param filePath
		 * @return
		 * @throws CSVException
		 */
		public static ArrayList<Item> importItemCSV(String filePath) throws CSVException{
			
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
							throw CSVFormatException();
							break;
					}
				}
				return items;
			}
			catch (CSVFormatException e) {
				
			}	
		}
	}
	


