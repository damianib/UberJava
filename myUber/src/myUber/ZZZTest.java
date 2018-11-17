package myUber;

import car.Car;
import java.util.ArrayList;

public class ZZZTest {
		
	public Car trouverVoiture (String type, GPS position, ArrayList<Car> listeVoitures) {
		for (Car car : listeVoitures) {
			String typeVoiture = car.getType();
			if (type == typeVoiture) {
				double distance = GPS.distance(position, car.getCarGPS());
				if (distance < 1000) {
					ArrayList<Driver> listeDriver = car.getDrivers();
					for(Driver driv : listeDriver) {
						if (driv.getState() == "on-duty") {
							return car;
						}
					}	
				}
			}
		}
		return null;
	}






}
