package myUber;

import java.util.ArrayList;

import car.Car;
import rides.Ride;

public class BookOfRides {
	
	private static ArrayList<Car> cars = new ArrayList<Car>();
	private static ArrayList<Driver> drivers = new ArrayList<Driver>();
	private static ArrayList<Ride> rides = new ArrayList<Ride>();
	
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
	
	/** Permet d'ajouter une entree au bookOfRides */
	public static void addEntry(Car car, Driver driver, Ride ride) {
		cars.add(car);
		drivers.add(driver);
		rides.add(ride);
	}

}
