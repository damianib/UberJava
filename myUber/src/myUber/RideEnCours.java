package myUber;

import java.util.TimerTask;

import car.Car;
import rides.Ride;
import rides.RideFactory;

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
		RideFactory.getRideEnCours().remove(ride);
		RideFactory.getRideFinies().add(ride);
		driver.setState("on-duty");
		car.setCarStatus("available");
		ride.getCustomer().setStatus("free");
		
	}

}
