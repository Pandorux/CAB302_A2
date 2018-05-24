package delivery;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CSVFormatException;
import store.Item;

public class Manifest {
	
	
	/**
	 * @author Jared Carey
	 * 
	 * @param filePath
	 * @return
	 * @throws CSVException
	 */
	public static ArrayList<Item> importItemCSV(String filePath) throws CSVException{
		
		File file = new File(filePath);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter(">"); // Separates CSV lines by Truck Groupings
		TruckFactory truckCreator = new TruckFactory();

		try {	
			ArrayList<TruckBase> items = new ArrayList<TruckBase>();
			while (inputStream.hasNext()) {
				String[] params = inputStream.next().split(",");
				
				switch(params[0]) {
					
					case "Ordinary":
						truckCreator.createTruck("Ordinary");
						break;
						
					case "Refrigerated":
						truckCreator.createTruck("Refrigerated");
						break;
						
					default:
						throw CSVFormatException();
				}
					// TODO: Append to Manifest
						
				}
			}
			return items;
		}
		catch (CSVFormatException e) {
			
		}	
	}	
	
}
