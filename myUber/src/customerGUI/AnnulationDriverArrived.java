package customerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.CustomerListener;
import myUber.BookOfRides;
import myUber.Customer;
import rides.Ride;
import rides.RideFactory;

public class AnnulationDriverArrived implements ActionListener {

	JFrame frame;
	Customer customer;
	public AnnulationDriverArrived(JFrame frame, Customer customer) { this.frame = frame; this.customer = customer; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Ride ride = RideFactory.customerToRide(customer);
		ride.setStatus("cancelled");
		RideFactory.getRideEnCours().remove(ride);
		BookOfRides.addEntry(ride.getCar(), ride.getDriver(), ride);
		ride.getDriver().setState("cancelled");
		customer.setStatus("free");
		ride.getCar().setCarStatus("available");
		new CustomerListener(customer, frame).actionPerformed(e);
		
	}
	
}
