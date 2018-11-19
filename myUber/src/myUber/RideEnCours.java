package myUber;

import java.util.TimerTask;

import car.Car;
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
		driver.setState("on-duty");
		car.setCarStatus("available");
		System.out.println(driver.getName() + " arrivé !");
		
	}

}
