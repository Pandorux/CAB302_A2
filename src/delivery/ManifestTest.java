package delivery;
import delivery.*;

import java.util.ArrayList;
import exceptions.DeliveryException;
import delivery.Truck;
import delivery.RefrigeratedTruck;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit Test Class that tests functionality held within the
 * Manifest class.
 * 
 * 
 * @author Jared Carey
 *
 */
class ManifestTest {
	
	public Manifest manifest;
	public ArrayList<TruckBase> trucks;
		
	@Test
	void testGetTruck_00() {
		assertEquals(1, manifest.getTruck(1).getId());
	}

	@Test
	void testGetTruck_01() {
		assertEquals(4, manifest.getTruck(4).getId());
	}
	
	@Test
	void testGetTruckThatIsntInManifest_00() {
		manifest.removeTruck(4);
		assertEquals(null, manifest.getTruck(4));
	}

	@Test
	void testGetTruckThatIsntInManifest_01() {
		assertEquals(null, manifest.getTruck(7).getId());
	}
	
	@Test
	void testRemoveTruck_00() {
		manifest.removeTruck(1);
		assertEquals(null, manifest.getTruck(1));
	}
	
	@Test
	void testRemoveTruck_01() {
		manifest.removeTruck(1);
		assertEquals(null, manifest.removeTruck(1));
	}
	
	@Test
	void testAddTruck() {
		manifest.addTruck(new Truck());
		assertEquals(6, manifest.getTruck(6).getId);
	}
	
	@Test
	void testManifestSize_00() {
		assertEquals(5, manifest.length());
	}
	
	@Test
	void testManifestSize_01() {
		manifest.remove(1);
		manifest.remove(4);
		assertEquals(3, trucks.size());
	}
	
	@Test
	void testManifestSize_02() {
		manifest.addTruck(new Truck());
		manifest.addTruck(new RefrigeratedTruck());
		assertEquals(7, trucks.size()); 
	}
	
	@Before
	void beforeEachTest() {
		trucks = new ArrayList<TruckBase>();
		trucks.add(new Truck(1));
		trucks.add(new RefrigeratedTruck(2));
		trucks.add(new Truck(3));
		trucks.add(new RefrigeratedTruck(4));
		trucks.add(new Truck(5));
		
		manifest = new Manifest();
	}

}
