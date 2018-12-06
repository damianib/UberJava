package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.Customer;
import myUber.DriverFactory;
import myUber.GPS;
import rides.Ride;
import rides.RideFactory;

class RideFactoryTest {

	@Test
	void testCreateRide() {
		
		try {
			Customer c = new Customer("name", "surname", "id", "creditcard", GPS.randGPS());
			Ride r = RideFactory.createRide(c, "UberBlack", GPS.randGPS(), GPS.randGPS());
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception raised");
		}
		
	}

}
