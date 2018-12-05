package myUber;

import java.util.ArrayList;

public class DriverFactory {
	
	static int compteurDriver = 0;
	static ArrayList<Driver> listOfDrivers = new ArrayList<Driver>();
	
	/**Cree un driver ajoute a listOfDrivers */
	public static void createDriver(String name, String surname) {
		compteurDriver ++;
		String str = Integer.toString(compteurDriver);
		String ID = "Driver" + str;
		Driver driver = new Driver(name, surname, ID);
		listOfDrivers.add(driver);
	}	
	
	public static ArrayList<Driver> getListOfDrivers() {
		return listOfDrivers;
	}
	public void supprimerDriver (Driver driver) {
		listOfDrivers.remove(driver);
	}
	public int getNbrOfDrivers () {
		return compteurDriver;
	}
}



