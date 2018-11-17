package myUber;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Timer;

import rides.Ride;
import rides.RideFactory;

import car.Car;
import car.CarFactory;

public class MyUber {
	
	protected ArrayList<Ride> bookOfRides = new ArrayList<Ride>();
	
	
	public static void main(String[] args) {
		DriverFactory.createDriver("pillot", "wolpertinger");
		DriverFactory.createDriver("benoit", "rainbow");
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		CarFactory.createCar("Standard");
		CarFactory.createCar("Berline");
		CarFactory.createCar("Van");
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		Car stand = listOfCars.get(0);
		Car berl = listOfCars.get(1);
		Car van = listOfCars.get(2);
		stand.addDriver(listOfDrivers.get(0));
		stand.addDriver(listOfDrivers.get(1));
		berl.addDriver(listOfDrivers.get(0));
		van.addDriver(listOfDrivers.get(1));
		
		
		
		
	}
	
	///fonction pour commander un ride
	public void commande(String rideType, GPS gps) {
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		Car car = trouverVoiture(rideType, gps, listOfCars);
		
			
		}
	}
	
	public Driver trouverConducteurs
	
	/// une fois le passager embarqué
	public void faireUnRide(Ride ride, Car car, Driver driver) {
		car.setCarStatus("non-available");
		driver.setState("on-a-ride");
		ride.setStatus("ongoing");
		double time = ride.getDuration();
		try {
			Thread.sleep((long) (time*1000));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ride.setStatus("completed");
		driver.setState("on-duty");
		car.setCarStatus("available");
		
		
		
		
		
	}
	
	///renvoie la voiture du type demandé disponible la plus proche
	public Car trouverVoiture (String type, GPS position, ArrayList<Car> listeVoitures) {
		double distMin = 1000;
		Car candidat = null;
		for (Car car : listeVoitures) {
			String typeVoiture = car.getType();
			String statusCar = car.getCarStatus();
			if (type == typeVoiture && statusCar == "available") {
				double distance = GPS.distance(position, car.getCarGPS());
				if (distance < distMin) {
					ArrayList<Driver> listeDriver = car.getDrivers();
					for(Driver driv : listeDriver) {
						if (driv.getState() == "on-duty") {
							distMin = distance;
							candidat = car;
						}
					}	
				}
			}
		}
		return candidat;
	}
	
	///fonction renvoyant l'état du traffic
	public static String getTraffic() {
		
		///on récupère l'heure
		Calendar cal = Calendar.getInstance();
        int heure = cal.get(Calendar.HOUR_OF_DAY);
        
		double plow; double pmedium; double phigh;
		
		///en fonction de l'heure on attribut les coeff de proba
		if (heure>22 || heure<7) {
			plow = 0.95; pmedium = 0.04; phigh = 0.01;
		}
		else if (heure < 11) {
			plow = 0.05; pmedium = 0.2; phigh = 0.75;
		}
		else if (heure < 17) {
			plow = 0.15; pmedium = 0.7; phigh = 0.15;
		}
		else {
			plow = 0.01; pmedium = 0.04; phigh = 0.95;
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
	
	///nani the fuck
	public static void bookingRide(Customer client, GPS destination, String rideType) {
		
		GPS depart = client.getGps();
		
		genPrice(depart, destination);//liste des prix
		
		
		
	}
	
	//renvoie la liste des prix des rides en fonction du trajet
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

	
}
