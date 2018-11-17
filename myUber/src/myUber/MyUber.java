package myUber;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import rides.Ride;
import rides.RideFactory;

import car.Car;
import car.CarFactory;

public class MyUber {
	
	protected ArrayList<Ride> bookOfRides = new ArrayList<Ride>();
	protected static int NombreDeClients = 0;
	protected static ArrayList<Car> listOfCars = new ArrayList<Car>();
	protected static ArrayList<Driver> listofDrivers = new ArrayList<Driver>();
	
	
	
	
	
	
	public Car trouverVoiture (String type, GPS position, ArrayList<Car> listeVoitures) {
		for (Car car : listeVoitures) {
			String typeVoiture = car.getType();
			if (type == typeVoiture) {
				double distance = GPS.distance(position, car.getCarGPS());
				if (distance < 1000) {
					ArrayList<Driver> listeDriver = car.getDrivers();
					for(Driver driv : listeDriver) {
						if (driv.getState() == "on-duty") {
							return car;
						}
					}	
				}
			}
		}
		return null;
	}
	///fonction renvoyant l'état du traffic
	public static String getTraffic() {
		
		///on récupère l'heure
		Calendar cal = Calendar.getInstance();
        int heure = cal.get(Calendar.HOUR_OF_DAY);
		
		double plow;
		double pmedium;
		double phigh;
		
		///en fonction de l'heure on attribut les coeff de proba
		if (heure>22 || heure<7) {
			plow = 0.95;
			pmedium = 0.04;
			phigh = 0.01;
		}
		else if (heure < 11) {
			plow = 0.05;
			pmedium = 0.2;
			phigh = 0.75;
		}
		else if (heure < 17) {
			plow = 0.15;
			pmedium = 0.7;
			phigh = 0.15;
		}
		else {
			plow = 0.01;
			pmedium = 0.04;
			phigh = 0.95;
		}
		
		/// on tire un nombre entre 0 et 1 et on annonce le résultat
		double tirage = Math.random();
		
		if (tirage < plow) {
			return "low";
		}
		else if (tirage < plow + pmedium) {
			return "medium";
		}
		else {
			return "high";
		}
		
	}
	
	
	public static void genPrice(GPS depart, GPS arrivee) {
		
		ArrayList<String> rideTypes = RideFactory.getRideTypes();
		for (Iterator iterator = rideTypes.iterator(); iterator.hasNext();) {
			String rideType = (String) iterator.next();
			Ride currentRide = RideFactory.createRide(rideType, "-", depart, arrivee);
			double currentPrice = currentRide.rate(getTraffic());
			System.out.println("Type de ride : "+rideType);
			System.out.println("Prix : "+currentPrice);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		GPS depart = new GPS(0, 0);
		GPS arrivee = new GPS(0, 2);
		genPrice(depart, arrivee);
		Car car = CarFactory.createCar("Standard");
		listOfCars.add(car);
	}
	
	
}
