package delivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.*;

import delivery.TruckBaseTest.DummyItem;
import exceptions.DeliveryException;
import store.Item;

/**
 * 
 * JUnit Test Case that tests the functionality held within the
 * RefrigeratedTruck class.
 * <br>
 * <br>
 * This Test Case extends the TruckBaseTest Test Case.
 * 
 * @author Jared Carey
 *
 */
public class RefrigeratedTruckTest extends TruckBaseTest {
	
	public RefrigeratedTruck dummyRefrigeratedTruck;
	
	@Before
	public void beforeEachTest() {
		// id, capacity, temp
		dummyRefrigeratedTruck = new RefrigeratedTruck();	
		dummyTruck = new RefrigeratedTruck();	
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_00() {
		dummyRefrigeratedTruck.setTemp(50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_01() {
		dummyRefrigeratedTruck.setTemp(-50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_02() {
		dummyRefrigeratedTruck.setTemp(-50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testAddItemOutOfTempRange_00() {
		Item item = new Item("Dairy Milk", 0, 0, "", 0, 30);
		dummyRefrigeratedTruck.addItem(item);
	}
	
	@Test(expected = DeliveryException.class)
	public void testAddItemOutOfTempRange_01() {
		Item item = new Item("Dairy Milk", 0, 0, "", 0, -30);
		dummyRefrigeratedTruck.addItem(item);
	}
	
	@Test
	public void testTruckCost_Empty() {
		assertTrue(1100 == dummyRefrigeratedTruck.getCost());
	}
	
	@Test
	@Override
	public void testTruckCost_00() {
		dummyRefrigeratedTruck.setTemp(-20);
		assertTrue(900 + 200 * (Math.pow(0.7, -20 / 5)) == dummyRefrigeratedTruck.getCost());
	}
	
	@Test
	@Override
	public void testTruckCost_01() {
		dummyRefrigeratedTruck.setTemp(10);
		assertTrue(900 + 200 * (Math.pow(0.7, 10 / 5)) == dummyRefrigeratedTruck.getCost());
	}
	
	@Test
	public void testTruckCost_02() {
		dummyRefrigeratedTruck.setTemp(0);
		assertTrue(900 + 200 * (Math.pow(0.7, 0 / 5)) == dummyRefrigeratedTruck.getCost());
	}
	
	
	@Test
	public void testAddItemsInTempRange() {
		ArrayList<Item> items = cargoMaker.CreateCargo(500);
		dummyRefrigeratedTruck.addItems(items);
	}
	
	@Test
	@Override
	public void testTruckAddItem() {
		Item item = new DummyItem("Milk", 0);
		dummyRefrigeratedTruck.addItem(item);
		assertTrue(item == dummyRefrigeratedTruck.getItem(item));
	}
	
	@Test
	@Override
	public void testGetCapacity_00() {
		assertTrue(800 == dummyRefrigeratedTruck.getCapacity());
	}
}
