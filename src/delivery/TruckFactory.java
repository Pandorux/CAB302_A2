package delivery;

public class TruckFactory {
/**
 * 
 * @param type refregerated or normal truck
 * @param cargo capacity of the truck
 */
	public TruckFactory(String type, int cargo) 
	{
		if (type == "Ordinary")
		{
			Truck truck = new Truck(cargo);
		}
		else if (type == "Refrigerated")
		{
			RefrigeratedTruck truck = new RefrigeratedTruck(cargo);
		}
		
	}
	
}
