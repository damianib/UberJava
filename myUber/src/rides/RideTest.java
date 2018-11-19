package rides;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.Customer;
import myUber.CustomerFactory;
import myUber.GPS;

class RideTest {

	@Test
	void testDuration() {
		
		String traffic = "low";
		GPS depart = new GPS(0, 0);
		GPS arrivee = new GPS(0, 15);
		Customer customer = new Customer("a", "b", "id", "c", new GPS(0, 0));
		Ride r = RideFactory.createRide(customer, "UberBlack", depart, arrivee);
		double duree = r.duration(traffic);
		assertEquals(duree, 3600.);
		
	}

	@Test
	void testRate() {
		
		String traffic = "medium";
		GPS depart = new GPS(0, 0);
		GPS arrivee = new GPS(0, 2);
		Customer customer = new Customer("a", "b", "id", "c", new GPS(0, 0));
		Ride r = RideFactory.createRide(customer, "UberBlack", depart, arrivee);
		double rate = r.rate(traffic);
		double rateTh = 2*6.2*1.3;
		assertEquals(rate, rateTh);
		
	}
		

}
