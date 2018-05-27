package delivery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exceptions.CSVFormatException;
import javafx.util.Pair;
import store.Item;

public class Manifest {
	
	
	//protected static Manifest instance = new Manifest();//make a manifest
	private static HashMap<Integer, TruckBase> Trucks = new HashMap<Integer, TruckBase>();//ID, Truck
	
	
	public Manifest()
	{
		Trucks = new HashMap<Integer, TruckBase>();//initialise
	}
	

	public void addTruck(TruckBase truck) 
	{
		fleet.put(truck.getId(), truck);
	}

	public void addTrucks(ArrayList<TruckBase> trucks) 
	{
		for(TruckBase t: trucks) {
			addTruck(t);
		}
	}
	
	/**
	 * 
	 * @param id removes the truck with a ID of id
	 */
	
	public void remove(int id) 
	{
		fleet.remove(id,fleet.get(id));//remove truck with id
	}


	public int length() 
	{
		
		return fleet.size();
	}
=======
>>>>>>> reagan/Implementation
	
	/**
	 * @author Jared Carey
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException 
	 * @throws CSVException
	 */
	public static ArrayList<TruckBase> importItemCSV(String filePath) throws CSVFormatException, FileNotFoundException {
		
	File file = new File(filePath);
	Scanner inputStream = new Scanner(file);
	inputStream.useDelimiter(">"); // Separates CSV lines by Truck Groupings
	TruckFactory truckCreator = new TruckFactory();
		
	try {	
		ArrayList<TruckBase> trucks = new ArrayList<TruckBase>();
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
					throw new CSVFormatException("There is no " + params[0] + " truck");
			}
				// TODO: Append to Manifest
					
			}
			inputStream.close();
			return trucks;
		}
		catch (CSVFormatException e) 
		{
			throw new CSVFormatException("Imported CSV does not meet format requirements");
		}
	}
		
		/**
		 * 
		 * @param id remove the truck with id
		 * @return 
		 */
		
		public TruckBase removeTruck(int id) 
		{
			return Trucks.remove(id);
		}

		/**
		 * 
		 * @param truck adds the truck to the manifest and gives it a appropriate id
		 */
		
		public void addTruck(TruckBase truck) 
		{
			Trucks.put(truck.getId(), truck);
		}

		/**
		 * 
		 * @param refrigeratedTruck makes a refrigerated truck and gives it a id
		 */
		
		public void addTruck(RefrigeratedTruck refrigeratedTruck) 
		{
			Trucks.put(refrigeratedTruck.getId(), refrigeratedTruck);
			
		}

		/**
		 * 
		 * @param id removes the truck with a ID of id
		 */
		
		public void remove(int id) 
		{
			Trucks.remove(id,Trucks.get(id));//remove truck with id
			
		}


		public int length() 
		{
			
			return Trucks.size();
		}
		
		
		public static String giveManifest()
		{
			if (Trucks.size() == 0)
			{
				return "";
			}
			else 
			{
				return Trucks.toString();
			}
			
		}
}
