package delivery;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exceptions.CSVFormatException;
import store.CSVException;
import store.Item;

public class Manifest {
	
	
	
	static HashMap<Integer, TruckBase> Trucks = new HashMap<Integer, TruckBase>();//ID, Truck
	
	
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
		/**
		 * 
		 * @param i truck ID
		 * @return
		 */
		
		public Object getTruck(int id)
		{
			
			return Trucks.get(id);
		}
		

		public void removeTruck(int id) 
		{
			Trucks.remove(id);
			
		}

		public void addTruck(TruckBase truck) 
		{
			Trucks.put(truck.getId(), truck);
		}

		public void addTruck(RefrigeratedTruck refrigeratedTruck) 
		{
			Trucks.put(refrigeratedTruck.getId(), refrigeratedTruck);
			
		}

		public void remove(int id) 
		{
			Trucks.remove(id,Trucks.get(id));//remove truck with id
			
		}
		
		
	}	
	
}
