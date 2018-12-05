package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TimerTask;

import car.Car;
import car.CarFactory;
import myUber.Customer;
import myUber.Driver;
import myUber.MyUber;
import rides.Ride;
import rides.RideFactory;

public class DriverToCustomer2 extends TimerTask {

	Customer customer;
	Driver driver;
	Car car;
	Ride fakeRide;
	
	public DriverToCustomer2(Customer customer, Driver driver, Car car) { 
		this.customer = customer;
		this.driver = driver;
		this.car = car;
		fakeRide = RideFactory.createRide(customer, MyUber.correspondanceCarToRide(car.getType()), car.getCarGPS(), customer.getGps());
	}
	
	
	public void run() {
		driver.setState("waiting");
		customer.setStatus("driver_arrived");
    }

	public void annulation() {
		Ride ride = RideFactory.customerToRide(customer);
		ride.setStatus("cancelled");
		RideFactory.getRideEnCours().remove(ride);
		RideFactory.getRideFinies().add(ride);
		driver.setState("cancelled");
		customer.setStatus("free");
		car.setCarStatus("available");
	}


	// getters and setters
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Ride getFakeRide() {
		return fakeRide;
	}
	public void setFakeRide(Ride fakeRide) {
		this.fakeRide = fakeRide;
	}
	
	
	
	
	
	
}