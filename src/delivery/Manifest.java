package delivery;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CSVFormatException;
import store.CSVException;
import store.Item;

public class Manifest {
	
	public static ArrayList<Item> importItemCSV(String filePath) throws CSVException{
		
		File file = new File(filePath);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter("(\\s\n)"); // Separates CSV lines
		

		try {	
			ArrayList<Item> items = new ArrayList<Item>();
			while (inputStream.hasNext()) {
				String[] params = inputStream.next().split(",");
				
					// TODO: Append to Manifest
						
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
