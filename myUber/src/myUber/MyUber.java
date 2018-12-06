package myUber;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.JFrame;

import Thread.RideEnCours;
import rides.Ride;
import rides.RideFactory;

import car.Car;
import car.CarFactory;
import gui.Setup;

public class MyUber {
	
	public static BookOfRides bookOfRides = new BookOfRides();
	
	
	public static void main(String[] args) {
		Setup.start();
	}
	
	
	/**cree et initie les voitures et clients, avec un conducteur par voiture
	 * 
	 */
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
				listOfDrivers.get(i).addCar(listOfCars.get(i));
			}
			
			//Creation Customer
			for (int i = 0; i < nbCustomers; i++) {
				CustomerFactory.createCustomer(""+i, ""+i, "421242124212", GPS.randGPS(maxX, maxY));
			}
			
		}
	
	
	
	/**fonction qui renvoie le type de ride, pour un type de voiture (hors UberPool)
	 * 
	 */
	public static String correspondanceCarToRide(String carType) {
		if (carType.equals("Standard")) {return "UberX";}
		else if (carType.equals("Van")) {return "UberVan";}
		else if (carType.equals("Berline")) {return "UberBlack";}
		return null;
	}
	
	/** fonction pour recuperer un driver disponible pour cette voiture7
	 * 
	 */
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
		
	public static Car findCar(Driver driver, String type) {
		ArrayList<Car> listeOfCar = driver.getCars();
		for (Car car : listeOfCar) {
			if (car.getType().equals(type) && car.getCarStatus().equals("available") ) {
				return car;
			}
		}
			
		
		return null;
	}

	
	/** embarquement du passager
	 * 
	 */
	public static void faireUnRide(Customer customer) {
		Ride ride = RideFactory.customerToRide(customer);
		ride.getDriver().setState("on-a-ride");
		customer.setStatus("on-a-ride");
		ride.setStatus("ongoing");
		double time = ride.getDuration();
		Timer timer = new Timer();
		timer.schedule(new RideEnCours(ride, ride.getCar(), ride.getDriver()), (long) time);
		bookOfRides.addEntry(ride.getCar(), ride.getDriver(), ride);
	}
	
	/**renvoie la voiture du type demandé disponible la plus proche
	 * 
	 */
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
	
	/**fonction renvoyant l'état du traffic
	 * 
	 */
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
