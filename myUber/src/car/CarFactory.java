package car;

public class CarFactory {
	
	int compteurStandard = 0;
	int compteurVan = 0;
	int compteurBerline = 0;
	
	public Car createCar(String CarType) {
		
		if (CarType == "Van") {
			compteurVan ++;
			String str = Integer.toString(compteurVan);
			String ID = CarType + str;
			return new Van(ID);
		}
		else if (CarType == "Standard") {
			compteurStandard ++;
			String str = Integer.toString(compteurStandard);
			String ID = CarType + str;
			return new Standard(ID);
		}
		else if (CarType == "Berline") {
			compteurBerline ++;
			String str = Integer.toString(compteurBerline);
			String ID = CarType + str;
			return new Berline(ID);
		}
		return null;
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
