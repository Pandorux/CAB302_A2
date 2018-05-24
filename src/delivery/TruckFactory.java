package delivery;

public class TruckFactory {

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
