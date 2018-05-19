package io;
import store.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class CSVParser {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "sales_log_0.csv";
		File file = new File(fileName);
		Scanner inputStream = new Scanner(file);
		inputStream.useDelimiter("(,|\\s\n)");
		ArrayList<SuperMart> items = new ArrayList<SuperMart>();
		while (inputStream.hasNext()) {
			items.add(new SuperMart(inputStream.next(), inputStream.nextInt()));
		}
		
	}
	
}
