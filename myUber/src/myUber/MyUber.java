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
	
	public static BookOfRides bookOfRides = new BookOfRides();
	
	public static void main(String[] args) {
		
		setup(1, 1, 1, 5);
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		
		ArrayList<Customer> listWait = new ArrayList<Customer>(listOfCustomers);
		
		while (!(listWait.size() == 0)) {
			Customer customer = listWait.get(0);
			listWait.remove(0);
			String typeRide = RideAlea();
			Ride ride = RideFactory.createRide(customer, typeRide, customer.getGps(), GPS.randGPS());
			Car car = trouverVoiture(ride.getCarType(), customer.getGps(), listOfCars);
			if (car == null) {
				listWait.add(customer);
			}
			else {
				System.out.println("ca part !");
				Driver driver = trouverConducteur(car);
				faireUnRide(ride, car, driver);
			}	
			
		}
	}
	
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
	
	///renvoie un type de ride aléatoire
	public static String RideAlea () {
		ArrayList<String> choix = new ArrayList<String>();
		choix.add("UberVan");
		choix.add("UberBlack");
		choix.add("UberX");
		///choix.add("UberPool");
		int x =(int)(Math.random() * (2 + 1));
		return choix.get(x);
		
	}
	
	/// fonction pour recuperer un driver disponible pour cette voiture
	public static Driver trouverConducteur(Car car) {
		car.setCarStatus("non-available");
		ArrayList<Driver> listDriver = car.getDrivers();
		for (Driver driver : listDriver) {
			if (driver.getState() == "on-duty") {
				return driver;
			}
			}
		return null;
		}
			
	/// embarquement du passager
	public static void faireUnRide(Ride ride, Car car, Driver driver) {
		car.setCarStatus("non-available");
		driver.setState("on-a-ride");
		ride.setStatus("ongoing");
		System.out.println(driver.getName() + " départ !");
		double time = ride.getDuration();
		System.out.println("la durée du voyage de " + driver.getName() + " est de " + time);
		
		Timer timer = new Timer();
		timer.schedule(new RideEnCours(ride, car, driver), (long) time);
		bookOfRides.addEntry(car, driver, ride);
	}
	
	///renvoie la voiture du type demandé disponible la plus proche
	public static Car trouverVoiture (String type, GPS position, ArrayList<Car> listeVoitures) {
		double distMin = 1000000000000000000000.;
		Car candidat = null;
		for (Car car : listeVoitures) {
			String typeVoiture = car.getType();
			String statusCar = car.getCarStatus();
			if (type.equals(typeVoiture) && statusCar.equals("available")) {
				double distance = GPS.distance(position, car.getCarGPS());
				if (distance < distMin) {
					ArrayList<Driver> listeDriver = car.getDrivers();
					for(Driver driv : listeDriver) {
						if (driv.getState().equals("on-duty")) {
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

}
