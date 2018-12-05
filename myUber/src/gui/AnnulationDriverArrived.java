package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Customer;
import rides.Ride;
import rides.RideFactory;

public class AnnulationDriverArrived implements ActionListener {

	JFrame frame;
	Customer customer;
	AnnulationDriverArrived(JFrame frame, Customer customer) { this.frame = frame; this.customer = customer; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Ride ride = RideFactory.customerToRide(customer);
		ride.setStatus("cancelled");
		RideFactory.getRideEnCours().remove(ride);
		RideFactory.getRideFinies().add(ride);
		ride.getDriver().setState("cancelled");
		customer.setStatus("free");
		ride.getCar().setCarStatus("available");
		new CustomerListener(customer, frame).actionPerformed(e);
		
	}
	
}
