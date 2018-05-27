package delivery;
import delivery.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import exceptions.DeliveryException;
import delivery.Truck;
import delivery.RefrigeratedTruck;
import org.junit.*;

/**
 * A JUnit Test Class that tests functionality held within the
 * Manifest class.
 * 
 * 
 * @author Jared Carey
 *
 */
public class ManifestTest {
	
	public Manifest manifest;
	public ArrayList<TruckBase> trucks;
		
	@Before
	public void beforeEachTest() {
		trucks = new ArrayList<TruckBase>();
		trucks.add(new Truck(1));
		trucks.add(new RefrigeratedTruck(2));
		trucks.add(new Truck(3));
		trucks.add(new RefrigeratedTruck(4));
		trucks.add(new Truck(5));
		
		manifest = new Manifest();
		manifest.addTrucks(trucks);
	}
	
	@Test
	public void testGetTruckThatIsntInManifest_00() {
		manifest.removeTruck(4);
		assertTrue(null == manifest.getTruck(4));
	}

	@Test
	public void testGetTruckThatIsntInManifest_01() {
		assertTrue(null == manifest.getTruck(7));
	}
	
	@Test
	public void testRemoveTruck_00() {
		manifest.removeTruck(1);
		assertTrue(null == manifest.getTruck(1));
	}
	
	@Test
	public void testRemoveTruck_01() {
		manifest.removeTruck(1);
		assertTrue(null == manifest.removeTruck(1));
	}
	
	@Test
	public void testAddTruck() {
		TruckBase t = new Truck();
		manifest.addTruck(t);
		assertTrue(t.getId() == manifest.getTruck(t.getId()).getId());
	}
	
	@Test
	public void testManifestSize_00() {
		assertTrue(5 == manifest.length());
	}
 
	@Test
	public void testManifestSize_01() {
		manifest.remove(1);
		manifest.remove(4);
		assertEquals(3, trucks.size());
	}
	
	@Test
	public void testManifestSize_02() {
		manifest.addTruck(new Truck());
		manifest.addTruck(new RefrigeratedTruck());
		assertEquals(7, trucks.size());
	}

}
