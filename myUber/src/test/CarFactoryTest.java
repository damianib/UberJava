package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import car.CarFactory;
import myUber.Customer;
import myUber.GPS;
import rides.Ride;
import rides.RideFactory;

class CarFactoryTest {

	@Test
	void testCreateCar() {
		
		try {
			CarFactory.createCar("Van", GPS.randGPS());
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception raised");
		}
		
	}

}
