package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import myUber.Driver;
import myUber.MyUber;
import rides.Ride;
import rides.RideFactory;

public class ConducteurAccepte implements ActionListener {

	JFrame frame;
	Driver driver;
	ConducteurAccepte (Driver driver, JFrame frame) {
		this.driver = driver;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Ride ride = RideFactory.driverToRide(driver);
		this.driver.setState("drivingToC");
		ride.getCustomer().setStatus("waiting_driver");
		ride.getCar().setCarStatus("unavailable");
		DriverToCustomer2 driverToCustomer = new DriverToCustomer2(ride.getCustomer(), driver, ride.getCar());
		
		Timer timer = new Timer();
	    timer.schedule (driverToCustomer, (long)driverToCustomer.getFakeRide().getDuration() *1 );
		
		RideFactory.listOfDriverToCustomer.add(driverToCustomer);
		System.out.println("wait for it");
		System.out.println("legendary !");
		new DriverListener(driver, frame).actionPerformed(e);
	}

}
