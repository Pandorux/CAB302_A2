package delivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.*;
import exceptions.DeliveryException;

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
	
	@Before
	public void beforeEachTest() {
		// id, capacity, temp
		dummyTruck = new RefrigeratedTruck();	
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_00() {
		dummyTruck.setTemp(50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_01() {
		dummyTruck.setTemp(-50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testTemperatureStaysInRange_02() {
		dummyTruck.setTemp(-50);
	}
	
	@Test(expected = DeliveryException.class)
	public void testAddItemOutOfTempRange_00() {
		dummyTruck.addItem("Milk", 30);
	}
	
	@Test(expected = DeliveryException.class)
	public void testAddItemOutOfTempRange_01() {
		dummyTruck.addItem("Milk", -30);
	}
	
	@Test
	public void testTruckCost_Empty() {
		assertTrue(900 == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_00() {
		dummyTruck.addItems(cargoMaker.CreateCargo(500));
		assertTrue(900 + (0.25 * 500) * (Math.pow(0.7, dummyTruck.getTemp() / 5)) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_01() {
		dummyTruck.addItems(cargoMaker.CreateCargo(1000));
		assertTrue(900 + 200 * (Math.pow(0.7, dummyTruck.getTemp() / 5)) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_02() {
		dummyTruck.capacity = 2000;
		dummyTruck.addItems(cargoMaker.CreateCargo(2000));
		assertTrue(900 + 200 * (Math.pow(0.7, dummyTruck.getTemp() / 5)) == dummyTruck.getCost());
	}
	
	@Test
	public void testTruckCost_03() {
		dummyTruck.capacity = 5000;
		dummyTruck.addItems(cargoMaker.CreateCargo(5000));
		assertTrue(900 + 200 * (Math.pow(0.7, dummyTruck.getTemp() / 5)) == dummyTruck.getCost());
	}
	
	@Test
	public void testAddItemsInTempRange() {
		ArrayList<DummyItem> items = cargoMaker.CreateCargo(500);
		dummyTruck.addItems(items);
	}
}
