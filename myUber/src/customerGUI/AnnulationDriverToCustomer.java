package customerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Thread.DriverToCustomer2;
import gui.CustomerListener;
import myUber.Customer;
import rides.RideFactory;

public class AnnulationDriverToCustomer implements ActionListener {

	Customer customer;
	JFrame frame;
	
	public AnnulationDriverToCustomer(Customer customer, JFrame frame) { this.customer = customer; this.frame = frame; }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DriverToCustomer2 dtc = RideFactory.customerToDriverToCustomer(customer);
		dtc.cancel();
		dtc.annulation();
		RideFactory.listOfDriverToCustomer.remove(dtc);
		new CustomerListener(customer, frame).actionPerformed(e);
		
	}

}
