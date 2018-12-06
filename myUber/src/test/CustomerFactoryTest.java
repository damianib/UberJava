package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.CustomerFactory;
import myUber.GPS;

class CustomerFactoryTest {

	@Test
	void testCreateCustomer() {
		
		try {
			CustomerFactory.createCustomer("nom", "surname", "creditCard", GPS.randGPS());
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception raised");
		}
		
		
	}

}
