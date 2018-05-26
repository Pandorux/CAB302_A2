package store;

import java.util.ArrayList;

public class Store {

	protected static Store instance = new Store();
	
	private String name;
	private Stock inventory;
	private double capital;
	
	// TODO: throw exception if store alreadys exists?
	protected Store() {	
		name = "";
		inventory = new Stock();
		capital = 0.0;
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
	
}
