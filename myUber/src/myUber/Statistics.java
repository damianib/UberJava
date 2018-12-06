package myUber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import car.Car;
import rides.Ride;

public class Statistics {
	
	/**Renvoie les rides dont a fait partie un customer */
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
				
		
	/** renvoie le nb total de rides d'un customer */
	public static int customerNumberOfRides(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		int numberOfRides = customerRides.size();
		return numberOfRides;
	}
	
	
	/** renvoie le temps total d'un customer passe dans des rides */
	public static double customerTotalTime(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		double totalTime = 0.;
		for (int i = 0; i < customerRides.size(); i++) {
			Ride currentRide = customerRides.get(i);
			totalTime = totalTime + currentRide.getDuration();
		}
		return totalTime;
	}
	
	
	/**renvoie l'argent depense par un customer dans tous les rides*/
	public static double customerTotalRate(BookOfRides bookOfRides, Customer customer) {
		
		ArrayList<Ride> customerRides = getCustomerRides(bookOfRides, customer);
		double totalRate = 0.;
		for (int i = 0; i < customerRides.size(); i++) {
			Ride currentRide = customerRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}
	
	
	/**Renvoie les rides dont a fait partie un driver*/
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
	
	
	/**renvoie le nb de rides effectues par un driver*/
	public static int driverNumberOfRides(BookOfRides bookOfRides, Driver driver) {
		
		ArrayList<Ride> driverRides = getDriverRides(bookOfRides, driver);
		int numberOfRides = driverRides.size();
		return numberOfRides;
		
	}
	
	
	/** renvoie le temps total d'un driver passe dans des rides */
	public static double driverTotalTime(BookOfRides bookOfRides, Driver driver) {
		
		ArrayList<Ride> driverRides = getDriverRides(bookOfRides, driver);
		double totalTime = 0.;
		for (int i = 0; i < driverRides.size(); i++) {
			Ride currentRide = driverRides.get(i);
			totalTime = totalTime + currentRide.getDuration(); 
		}
		return totalTime;
	}
	
	
	/**renvoie le montant total gagne par un driver*/
	public static double driverTotalRate(BookOfRides bookOfRides, Driver driver) {
		
		ArrayList<Ride> driverRides = getDriverRides(bookOfRides, driver);
		double totalRate = 0.;
		for (int i = 0; i < driverRides.size(); i++) {
			Ride currentRide = driverRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}
	
	
	/**renvoie le nb de rides effectues au total*/
	public static int totalNumberOfRides(BookOfRides bookOfRides) {
		
		return bookOfRides.getCars().size();
		
	}
	
	
	/**renvoie le total des revenus generes*/
	public static double totalRate(BookOfRides bookOfRides) {
		
		ArrayList<Ride> listOfRides = bookOfRides.getRides();
		double totalRate = 0;
		for(int i = 0; i < listOfRides.size(); i++) {
			Ride currentRide = listOfRides.get(i);
			totalRate = totalRate + currentRide.rate();
		}
		return totalRate;
		
	}
	
	/**renvoie le temps total*/
	public static double totalTime(BookOfRides bookOfRides) {
		
		ArrayList<Ride> listOfRides = bookOfRides.getRides();
		double totalTime = 0;
		for(int i = 0; i < listOfRides.size(); i++) {
			Ride currentRide = listOfRides.get(i);
			totalTime = totalTime + currentRide.getDuration();
		}
		return totalTime;
		
	}
	
	
	
	
	
	/**Permet de comparer les clients par nombre de rides (decroissant)*/
	public static class sortByNumberOfRides implements Comparator<Customer>{
		
		BookOfRides bookOfRides;
		
		public sortByNumberOfRides(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Customer a, Customer b) {
			int na = customerNumberOfRides(this.bookOfRides, a);
			int nb = customerNumberOfRides(this.bookOfRides, b);
			if (nb > na) {
				return 1;
			} else if (nb < na) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste client classes par nombre de rides decroissant*/
	public static ArrayList<Customer> customersSortedByFrequence(BookOfRides bookOfRides){
		
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		Collections.sort(listOfCustomers, new sortByNumberOfRides(bookOfRides));
		return listOfCustomers;
		
	}
	
	
	/**Permet de comparer les clients par temps total (decroissant)*/
	public static class sortByTotalTime implements Comparator<Customer>{
		
		BookOfRides bookOfRides;
		
		public sortByTotalTime(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Customer a, Customer b) {
			double na = customerTotalTime(this.bookOfRides, a);
			double nb = customerTotalTime(this.bookOfRides, b);
			if (nb > na) {
				return 1;
			} else if (nb < na) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste client classes par nombre de rides decroissant*/
	public static ArrayList<Customer> customersSortedByTime(BookOfRides bookOfRides){
		
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		Collections.sort(listOfCustomers, new sortByTotalTime(bookOfRides));
		return listOfCustomers;
		
	}
	
	
	
	
	
	/**Permet de comparer les clients par total cash paye (decroissant)*/
	public static class sortByTotalRate implements Comparator<Customer>{
			
		BookOfRides bookOfRides;
			
		public sortByTotalRate(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
			
		public int compare(Customer a, Customer b) {
			double da = customerTotalRate(this.bookOfRides, a);
			double db = customerTotalRate(this.bookOfRides, b);
			if (db>da) {
				return 1;
			} else if (db<da) {
				return -1;
			} else {
				return 0;
			}
		}
			
	}
		
	/**Renvoie la liste client classes par total cash paye (decroissant)*/
	public static ArrayList<Customer> customersSortedByTotalRate(BookOfRides bookOfRides){
			
		ArrayList<Customer> listOfCustomers = CustomerFactory.getListOfCustomers();
		Collections.sort(listOfCustomers, new sortByTotalRate(bookOfRides));
		return listOfCustomers;
		
	}
	
	
	
	
	
	
	/**Trie les drivers selon leur evaluation (decroissant)*/
	public static class sortByEvaluation implements Comparator<Driver>{
		
		BookOfRides bookOfRides;
		
		public sortByEvaluation(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Driver a, Driver b) {
			double da = a.getEvaluation();
			double db = b.getEvaluation();
			if (db>da) {
				return 1;
			} else if (db<da) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste driver classes par nombre de rides decroissant*/
	public static ArrayList<Driver> driversSortedByEvaluation(BookOfRides bookOfRides){
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		Collections.sort(listOfDrivers, new sortByEvaluation(bookOfRides));
		return listOfDrivers;
		
	}
	
	
	
	/**Trie les drivers selon leur nombre de ride (decroissant)*/
	public static class sortByNbrRide implements Comparator<Driver>{
		
		BookOfRides bookOfRides;
		
		public sortByNbrRide(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Driver a, Driver b) {
			double da = driverNumberOfRides(bookOfRides, a);
			double db = driverNumberOfRides(bookOfRides, b);
			if (db>da) {
				return 1;
			} else if (db<da) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste driver classes par nombre de rides decroissant*/
	public static ArrayList<Driver> driversSortedByNbrRides(BookOfRides bookOfRides){
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		Collections.sort(listOfDrivers, new sortByNbrRide(bookOfRides));
		return listOfDrivers;
		
	}
	
	
	
	/**Trie les drivers selon leur montant total gagné (decroissant)*/
	public static class sortByRate implements Comparator<Driver>{
		
		BookOfRides bookOfRides;
		
		public sortByRate(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Driver a, Driver b) {
			double da = driverTotalRate(bookOfRides, a);
			double db = driverTotalRate(bookOfRides, b);
			if (db>da) {
				return 1;
			} else if (db<da) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste driver classes par prix decroissant*/
	public static ArrayList<Driver> driversSortedByRate(BookOfRides bookOfRides){
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		Collections.sort(listOfDrivers, new sortByRate(bookOfRides));
		return listOfDrivers;
		
	}

	
	
	/**Trie les drivers selon leur temps de ride (decroissant)*/
	public static class sortByTime implements Comparator<Driver>{
		
		BookOfRides bookOfRides;
		
		public sortByTime(BookOfRides bookOfRides) {
			this.bookOfRides = bookOfRides;
		}
		
		public int compare(Driver a, Driver b) {
			double da = driverTotalTime(bookOfRides, a);
			double db = driverTotalTime(bookOfRides, b);
			if (db>da) {
				return 1;
			} else if (db<da) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	/**Renvoie la liste driver classes par nombre de rides decroissant*/
	public static ArrayList<Driver> driversSortedByTime(BookOfRides bookOfRides){
		
		ArrayList<Driver> listOfDrivers = DriverFactory.getListOfDrivers();
		Collections.sort(listOfDrivers, new sortByTime(bookOfRides));
		return listOfDrivers;
		
	}
	
	
}
