package Thread;

import java.util.TimerTask;

import car.Car;
import myUber.Driver;
import rides.Ride;

public class RideEnCours extends TimerTask {
	
	Ride ride;
	Car car;
	Driver driver;
	
	
	
	
	
	public RideEnCours(Ride ride, Car car, Driver driver) {
		super();
		this.ride = ride;
		this.car = car;
		this.driver = driver;
	}


	@Override
	public void run() {
		ride.setStatus("completed");
		car.setCarGPS(ride.getArrivee());
		ride.getCustomer().setGps(ride.getArrivee());
		driver.setState("end_ride");
		car.setCarStatus("available");
		ride.getCustomer().setStatus("asked_eval");
		
	}

}
