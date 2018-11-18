package car;

import java.util.ArrayList;

import myUber.GPS;

public class CarFactory {
	
	static int compteurStandard = 0;
	static int compteurVan = 0;
	static int compteurBerline = 0;
	static ArrayList<Car> listOfCars = new ArrayList<Car>();
	
	public static void createCar(String CarType, GPS carGPS) {
		
		if (CarType == "Van") {
			compteurVan ++;
			String str = Integer.toString(compteurVan);
			String ID = CarType + str;
			Van van = new Van(ID, carGPS);
			listOfCars.add(van);
		}
		else if (CarType == "Standard") {
			compteurStandard ++;
			String str = Integer.toString(compteurStandard);
			String ID = CarType + str;
			Standard stand = new Standard(ID, carGPS);
			listOfCars.add(stand);
		}
		else if (CarType == "Berline") {
			compteurBerline ++;
			String str = Integer.toString(compteurBerline);
			String ID = CarType + str;
			Berline berl = new Berline(ID, carGPS);
			listOfCars.add(berl);
		}
	}
	
	public static ArrayList<Car> getListOfCars () {
		return listOfCars;
	}
	public void supprimerCar (Car car) {
		listOfCars.remove(car);
	}
	public int getNbrOfStandard () {
		return compteurStandard;
	}
	public int getNbrOfVan () {
		return compteurVan;
	}
	public int getNbrOfBerline () {
		return compteurBerline;
	}
	
	
	

}
