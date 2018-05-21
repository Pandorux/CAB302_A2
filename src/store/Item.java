package store;

import io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

	
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
		
		public static void increasePrice(String string, int i) {
			// TODO Auto-generated method stub
			
		}

		public static int findItemCost() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void changeReorderAmount(String string, int i) {
			// TODO Auto-generated method stub
			
		}

		public static int findItemReorderAmount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void changeReorderPoint(String string, String string2) {
			// TODO Auto-generated method stub
			
		}

		public static int findItemManufactureCost() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void increaseCost(String string, int i) {
			// TODO Auto-generated method stub
			
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
	


