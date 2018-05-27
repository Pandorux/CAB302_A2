package delivery;

public class TruckFactory {
/**
 * 
 * @param type refregerated or normal truck
 * @param cargo capacity of the truck
 */
	
	public TruckBase createTruck(String type) {
		TruckBase truck = null;
		if (type == "Ordinary")
		{
			truck = new Truck();

		}
		else if (type == "Refrigerated")
		{
			truck = new RefrigeratedTruck();
		}
		return truck;
	}
	
}
