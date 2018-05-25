package store.Reagan_assesment_supermart;

import java.util.ArrayList;

public class Store {

	public static Store instance = null;
	
	private String name;
	private Stock inventory;
	private double capital;
	
	// TODO: throw exception if store alreadys exists?
	public Store(String name) {
		this.name = name;
		this.inventory = new Stock();
		this.capital = 0;
		instance = this;
	}

	public Store(String name, double capital) {
		this.name = name;
		this.inventory = new Stock();
		this.capital = capital;
		instance = this;
	}
	
	public void AddCapital(double amt) {
		capital += amt;
	}
	
	public void removeCapital(double amt) {
		capital -= amt;
	}
	
	public String getName() {
		return name;
	}
	
	public void renameStore(String storeName) {
		name = storeName;
	}
	
}
