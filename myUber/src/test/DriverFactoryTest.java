package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.DriverFactory;

class DriverFactoryTest {

	@Test
	void testCreateDriver() {
		
		try {
			DriverFactory.createDriver("name", "surname");
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception raised");
		}
		
		
		
	}

}
