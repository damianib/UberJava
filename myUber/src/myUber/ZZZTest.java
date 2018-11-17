package myUber;

import car.Car;
import car.CarFactory;
import rides.Ride;

import java.util.ArrayList;

public class ZZZTest {
		
	
	public static void main(String[] args) {
		System.out.println("hello");
		try {
			Thread.sleep(6000);
			System.out.println("salut");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public static void setup(int nbStandard, int nbVan, int nbBerline, int nbCustomers) {
		
		double maxX = 10.;
		double maxY = 10.;
		int nbCars = nbStandard + nbVan + nbBerline;
		
		//Creation des cars
		for (int i = 0; i < nbStandard; i++) {
			CarFactory.createCar("Standard", GPS.randGPS(maxX, maxY));
		}
		for (int i = 0; i < nbVan; i++) {
			CarFactory.createCar("Van", GPS.randGPS(maxX, maxY));
		}
		for (int i = 0; i < nbBerline; i++) {
			CarFactory.createCar("Berline", GPS.randGPS(maxX, maxY));
		}
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		
		//Creation des drivers
		for (int i = 0; i < nbCars; i++) {
			DriverFactory.createDriver(""+i, ""+i);
		}
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		
		//Association driver/car
		for (int i = 0; i < nbCars; i++) {
			listOfCars.get(i).addDriver(listOfDrivers.get(i));
		}
		
		//Creation Customer
		for (int i = 0; i < nbCustomers; i++) {
			CustomerFactory.createCustomer(""+i, ""+i, "421242124212", GPS.randGPS(maxX, maxY));
		}
		
	}

}
