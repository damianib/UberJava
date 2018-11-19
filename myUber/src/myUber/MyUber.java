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
	
	
	//cree et initie les voitures et clients, avec un conducteur par voiture
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
	
	
	public static void main(String[] args) {
		
		setup(1, 2, 3, 4);
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		
		while (! )
		
		faireUnRide(ride2, berl, listOfDrivers.get(0));
		faireUnRide(ride1, stand, listOfDrivers.get(1));
		
		
		}
	
	///fonction pour commander un ride
	public void commande(Customer customer, String rideType, GPS depart, GPS arrivee) {
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		Ride ride = RideFactory.createRide(customer, rideType, depart, arrivee);
		Car car = trouverVoiture(ride.getCarType(), depart, listOfCars);
		Driver driver = trouverConducteur(car);
		
		faireUnRide(ride, car, driver);
			
		}
	
	
	public Driver trouverConducteur(Car car) {
		car.setCarStatus("non-available");
		ArrayList<Driver> listDriver = car.getDrivers();
		for (Driver driver : listDriver) {
			if (driver.getState() == "on-duty") {
				return driver;
			}
			}
		return null;
		}
		
	
	/// une fois le passager embarqué
	public static void faireUnRide(Ride ride, Car car, Driver driver) {
		car.setCarStatus("non-available");
		driver.setState("on-a-ride");
		ride.setStatus("ongoing");
		System.out.println(driver.getName() + " départ !");
		double time = ride.getDuration();
		System.out.println("la durée du voyage de " + driver.getName() + " est de " + time);
		
		Timer timer = new Timer();
		timer.schedule(new RideEnCours(ride, car, driver), (long) time);
		
		
		
		
		
		
		
		
		
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
			Ride currentRide = RideFactory.createRide(rideType, depart, arrivee);
			double currentPrice = currentRide.rate(getTraffic());
			System.out.println("Type de ride : "+rideType);
			System.out.println("Prix : "+currentPrice);
		}
		
	}

	
}
