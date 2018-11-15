package car;

public class CarFactory {
	
	public Car createCar(String CarType, int nbrVoitureDeCeType) {
		
		String str = Integer.toString(nbrVoitureDeCeType +1);
		String ID = CarType + str;
		
		if (CarType == "Van") {
			return new Van(ID);
		}
		else if (CarType == "Standard") {
			return new Standard(ID);
		}
		else if (CarType == "Berline") {
			return new Berline(ID);
		}
		return null;
	}
	
	

}
