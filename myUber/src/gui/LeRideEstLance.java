package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Customer;
import myUber.MyUber;

public class LeRideEstLance implements ActionListener {
	
	JFrame frame;
	Customer customer;
	LeRideEstLance(JFrame frame, Customer customer) { this.frame = frame; this.customer = customer;}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyUber.faireUnRide(customer);
		new CustomerListener(customer, frame).actionPerformed(e);
		
	}

}
