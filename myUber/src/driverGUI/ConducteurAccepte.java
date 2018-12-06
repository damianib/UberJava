package driverGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;

import Thread.DriverToCustomer2;
import gui.DriverListener;
import myUber.Driver;
import rides.Ride;
import rides.RideFactory;

public class ConducteurAccepte implements ActionListener {

	JFrame frame;
	Driver driver;
	public ConducteurAccepte (Driver driver, JFrame frame) {
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
		new DriverListener(driver, frame).actionPerformed(e);
	}

}
