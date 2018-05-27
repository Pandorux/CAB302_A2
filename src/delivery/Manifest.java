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
	
	HashMap<Integer, TruckBase> fleet;//ID, Truck
	
	public Manifest() {
		fleet = new HashMap<Integer, TruckBase>();
	}

	/**
	 * 
	 * @param i truck ID
	 * @return
	 */
	
	public TruckBase getTruck(int id)
	{
		return fleet.get(id);
	}
	
	
	/**
	 * 
	 * @param id remove the truck with id
	 * @return 
	 */
	
	public TruckBase removeTruck(int id) 
	{
		return fleet.remove(id);
	}

	/**
	 * 
	 * @param truck adds the truck to the manifest and gives it a appropriate id
	 */
	
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
}
