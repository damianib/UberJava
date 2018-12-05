package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Customer;
import rides.RideFactory;

public class AnnulationDriverToCustomer implements ActionListener {

	Customer customer;
	JFrame frame;
	
	AnnulationDriverToCustomer(Customer customer, JFrame frame) { this.customer = customer; this.frame = frame; }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DriverToCustomer2 dtc = RideFactory.customerToDriverToCustomer(customer);
		System.out.println("wait for it");
		dtc.cancel();
		System.out.println("lengend ...");
		dtc.annulation();
		System.out.println("...DARY !");
		RideFactory.listOfDriverToCustomer.remove(dtc);
		new CustomerListener(customer, frame).actionPerformed(e);
		
	}

}
