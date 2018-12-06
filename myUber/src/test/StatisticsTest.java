package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import car.Car;
import car.CarFactory;
import myUber.BookOfRides;
import myUber.Customer;
import myUber.CustomerFactory;
import myUber.Driver;
import myUber.DriverFactory;
import myUber.GPS;
import myUber.MyUber;
import myUber.Statistics;
import rides.Ride;
import rides.RideFactory;

class StatisticsTest {

	@Test
	void testCustomerNumberOfRides() {
		
		MyUber.setup(3, 3, 3, 3);
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		Car car = listOfCars.get(0);
		Driver driver = listOfDrivers.get(0);
		Customer customer = listOfCustomers.get(0);
		BookOfRides.addEntry(car, driver, RideFactory.createRide(customer, "UberX", GPS.randGPS(), GPS.randGPS()));
		
		assertEquals(Statistics.customerNumberOfRides(new BookOfRides(), customer), 1);
		
	}

	@Test
	void testDriverTotalRate() {
		
		MyUber.setup(3, 3, 3, 3);
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		BookOfRides bookOfRides = new BookOfRides();
		Car car = listOfCars.get(0);
		Driver driver = listOfDrivers.get(0);
		Customer customer = listOfCustomers.get(1);
		Ride ride = RideFactory.createRide(customer, "UberX", GPS.randGPS(), GPS.randGPS());
		bookOfRides.addEntry(car, driver, ride);
		
		assertEquals(Statistics.driverTotalRate(bookOfRides, driver), ride.rate());
		
	}

	@Test
	void testCustomersSortedByFrequence() {
		
		MyUber.setup(3, 3, 3, 3);
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		BookOfRides bookOfRides = new BookOfRides();
		Car car = listOfCars.get(0);
		Driver driver = listOfDrivers.get(0);
		Customer customer = listOfCustomers.get(1);
		bookOfRides.addEntry(car, driver, RideFactory.createRide(customer, "UberX", GPS.randGPS(), GPS.randGPS()));
		
		ArrayList<Customer> customersSorted = Statistics.customersSortedByFrequence(bookOfRides);
		
		assertEquals(customersSorted.get(0).getId(), customer.getId());
		
	}

}
