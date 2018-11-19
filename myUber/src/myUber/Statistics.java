package myUber;

import java.util.ArrayList;

import car.Car;
import rides.Ride;

public class Statistics {
	
	//Renvoie les rides dont a fait partie un customer
	public static ArrayList<Ride> getCustomerRides(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> listOfRides = bookOfRides.getRides();
		ArrayList<Ride> customerRides = new ArrayList<Ride>();
		
		for (int i = 0; i < listOfRides.size(); i++) {
			if (listOfRides.get(i).getCustomer() == customer) {
				customerRides.add(listOfRides.get(i));
			}
		}
		
		return customerRides;
	
	}
				
		
	//renvoie le nb total de rides d'un customer
	public static int customerNumberOfRides(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		int numberOfRides = customerRides.size();
		return numberOfRides;
	}
	
	
	//renvoie le temps total d'un customer passe dans des rides
	public static double customerTotalTime(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		double totalTime = 0.;
		for (int i = 0; i < customerRides.size(); i++) {
			Ride currentRide = customerRides.get(i);
			totalTime = totalTime + currentRide.getDuration();
		}
		return totalTime;
	}
	
	
	//renvoie l'argent depense par un customer dans tous les rides
	public static double customerTotalRate(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		double totalRate = 0.;
		for (int i = 0; i < customerRides.size(); i++) {
			Ride currentRide = customerRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}
	
	
	//Renvoie les rides dont a fait partie un customer
	public static ArrayList<Ride> getDriverRides(BookOfRides bookOfRides, Driver driver) {
			
		ArrayList<Driver> listOfDrivers = bookOfRides.getDrivers();
		ArrayList<Ride> listOfRides = bookOfRides.getRides();
		ArrayList<Ride> driverRides = new ArrayList<Ride>();
			
		for (int i = 0; i < listOfRides.size(); i++) {
			if (listOfDrivers.get(i) == driver) {
				driverRides.add(listOfRides.get(i));
			}
		}
			
		return driverRides;
		
	}
	
	
	//renvoie le nb de rides effectues par un driver
	public static int driverNumberOfRides(BookOfRides bookOfRides, Driver driver) {
		
		ArrayList<Ride> driverRides = getDriverRides(bookOfRides, driver);
		int numberOfRides = driverRides.size();
		return numberOfRides;
		
	}
	
	
	//renvoie le montant total gagne par un driver
	public static double driverTotalRate(BookOfRides bookOfRides, Driver driver) {
		
		ArrayList<Ride> driverRides = getDriverRides(bookOfRides, driver);
		double totalRate = 0.;
		for (int i = 0; i < driverRides.size(); i++) {
			Ride currentRide = driverRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}
	
	
	//renvoie le nb de rides effectues au total
	public static int totalNumberOfRides(BookOfRides bookOfRides) {
		
		return bookOfRides.getCars().size();
		
	}
	
	
	//renvoie le total des revenus generes
	public static double totalRate(BookOfRides bookOfRides) {
		
		ArrayList<Ride> listOfRides = bookOfRides.getRides();
		double totalRate = 0;
		for(int i = 0; i < listOfRides.size(); i++) {
			Ride currentRide = listOfRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}

}
