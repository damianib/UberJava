package car;

import java.util.ArrayList;

public class CarFactory {
	
	static int compteurStandard = 0;
	static int compteurVan = 0;
	static int compteurBerline = 0;
	static ArrayList<Car> listOfCars = new ArrayList<Car>();
	
	public static Car createCar(String CarType) {
		
		if (CarType == "Van") {
			compteurVan ++;
			String str = Integer.toString(compteurVan);
			String ID = CarType + str;
			Van van = new Van(ID);
			listOfCars.add(van);
		}
		else if (CarType == "Standard") {
			compteurStandard ++;
			String str = Integer.toString(compteurStandard);
			String ID = CarType + str;
			Standard stand = new Standard(ID);
			listOfCars.add(stand);
		}
		else if (CarType == "Berline") {
			compteurBerline ++;
			String str = Integer.toString(compteurBerline);
			String ID = CarType + str;
			Berline berl = new Berline(ID);
			listOfCars.add(berl);
		}
		return null;
	}
	
	public ArrayList<Car> getListOfCars () {
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
