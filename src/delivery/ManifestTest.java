package delivery;
import delivery.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jared Carey
 *
 */
class ManifestTest {
	
	public Manifest manifest;
	public ArrayList<TruckBase> trucks;
	
	@Test
	void testManifestConstruction() {
		// TODO:
	}
	
	
	@Test
	void testGetTruck_00() {
		// TODO: Get a truck that meets a certain criteria(id)
	}

	@Test
	void testGetTruck_01() {
		// TODO: Get exception if manifest is empty
	}
	
	@Test
	void testRemoveTruck() {
		manifest.removeTruck(1);
		// Throw exception?
	}
	
	@Test
	void testAddTruck() {
		// TODO: Remove truck from manifest using its id
	}
	
	@Test
	void testGetTrucks() {
		// TODO: Remove truck from manifest using its id
	}

	@Test
	void testRemoveTrucks() {
		
	}
	
	@Test
	void testAddTrucks() {
		
	}
	
	@Test
	void testGetAllRefrigeratedTrucks() {
		
	}
	
	@Test
	void testGetAllStandardTrucks() {
		
	}
	
	@Test
	void testManifestSize_00() {
		assertEquals(5, manifest.length());
	}
	
	@Test
	void testManifestSize_01() {
		manifest.clear();
		assertEquals(0, trucks.size());
	}
	
	@Test
	void testManifestSize_02() {
		trucks.removeIf(); // TODO: Remove Refrigerated Trucks
		assertEquals(0, trucks.size()); 
	}
	
	@Test
	void testManifestSize_03() {
		manifest.removeTrucks .removeIf(); // TODO: Remove Ordinary Trucks
		assertEquals(0, trucks.size());
	}
	
	@BeforeAll 
	void beforeEachTest() {
		trucks = new ArrayList<TruckBase>();
		trucks.add(Truck());
		trucks.add(RefrigeratedTruck());
		trucks.add(Truck());
		trucks.add(RefrigeratedTruck());
		trucks.add(Truck());
		
		manifest = new Manifest();
	}

}
