package customerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.CustomerListener;
import myUber.BookOfRides;
import myUber.Customer;
import rides.Ride;
import rides.RideFactory;

public class SetFree implements ActionListener {

	JFrame frame;
	Customer customer;
	public SetFree(JFrame frame, Customer customer) {
		this.frame = frame;
		this.customer = customer;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.customer.setStatus("free");
		Ride ride = RideFactory.customerToRide(this.customer);
		RideFactory.getRideEnCours().remove(ride);
		BookOfRides.addEntry(ride.getCar(), ride.getDriver(), ride);
		new CustomerListener(this.customer, this.frame).actionPerformed(arg0);
	}

}
