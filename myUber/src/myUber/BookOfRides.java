package myUber;

import java.util.ArrayList;

import car.Car;
import rides.Ride;

public class BookOfRides {
	
	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private ArrayList<Ride> rides = new ArrayList<Ride>();
	
	public BookOfRides() {
		super();
	}
	
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}
	public ArrayList<Ride> getRides() {
		return rides;
	}
	public void setRides(ArrayList<Ride> rides) {
		this.rides = rides;
	}
	
	public void addEntry(Car car, Driver driver, Ride ride) {
		this.cars.add(car);
		this.drivers.add(driver);
		this.rides.add(ride);
	}

}
