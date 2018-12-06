package controlGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;

import gui.FramePrincipale;
import myUber.Customer;
import myUber.CustomerFactory;
import myUber.GPS;

public class AjoutCustomer implements ActionListener {
	JFrame frame; JMenu menuCustomer; JTextField name; JTextField surname;
	AjoutCustomer(JFrame frame, JMenu menuCustomer, JTextField name, JTextField surname) {
		this.frame = frame;
		this.menuCustomer = menuCustomer;
		this.name = name;
		this.surname = surname;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CustomerFactory.createCustomer(name.getText(), surname.getText(), "random", GPS.randGPS());
		Customer customer = CustomerFactory.getListOfCustomers().get(CustomerFactory.getListOfCustomers().size()-1);
		FramePrincipale.createPageCustomer(menuCustomer, customer, frame);
		
	}

}
