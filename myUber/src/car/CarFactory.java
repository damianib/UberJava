package car;

public class CarFactory {
	
	public Car createCar(String CarType) {
		if (CarType == "Van") {
			return Van();
		}
		else if (CarType == "Standard") {
			return Standart();
		}
		else if (CarType == "Berline") {
			return Berline();
		}
		return null;
	}
	
	

}
