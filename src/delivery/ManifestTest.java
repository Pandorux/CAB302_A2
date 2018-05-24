package delivery;
import delivery.*;

import static org.junit.Assert.assertEquals;
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
		
	@Test
	public void testGetTruck_00() {
		assertEquals(1, manifest.getTruck(1).getId());
	}

	@Test
	public void testGetTruck_01() {
		assertEquals(4, manifest.getTruck(4).getId());
	}
	
	@Test
	public void testGetTruckThatIsntInManifest_00() {
		manifest.removeTruck(4);
		assertEquals(null, manifest.getTruck(4));
	}

	@Test
	public void testGetTruckThatIsntInManifest_01() {
		assertEquals(null, manifest.getTruck(7).getId());
	}
	
	@Test
	public void testRemoveTruck_00() {
		manifest.removeTruck(1);
		assertEquals(null, manifest.getTruck(1));
	}
	
	@Test
	public void testRemoveTruck_01() {
		manifest.removeTruck(1);
		assertEquals(null, manifest.removeTruck(1));
	}
	
	@Test
	public void testAddTruck() {
		manifest.addTruck(new Truck());
		assertEquals(6, manifest.getTruck(6).getId());
	}
	
	@Test
	public void testManifestSize_00() {
		assertEquals(5, manifest.length());
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
	
	@Before
	public void beforeEachTest() {
		trucks = new ArrayList<TruckBase>();
		trucks.add(new Truck(1));
		trucks.add(new RefrigeratedTruck(2));
		trucks.add(new Truck(3));
		trucks.add(new RefrigeratedTruck(4));
		trucks.add(new Truck(5));
		
		manifest = new Manifest();
	}

}
