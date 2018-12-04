package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import myUber.Customer;
import myUber.CustomerFactory;
import myUber.Driver;
import myUber.DriverFactory;
import myUber.MyUber;

public class JFrame1stExemple {
	public static void main(String[] args) {
		
		MyUber.setup(0, 2, 3, 4);
		
		JFrame myFrame =new JFrame("myUber controler");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creer les menus déroulant
		JMenuBar menuBar = new JMenuBar();
		JMenu menuControl = new JMenu("Control");
		JMenu menuCustomer = new JMenu("Customer");
		JMenu menuDriver = new JMenu("Driver");
		
		// implementer le menu client
		for (Customer customer : CustomerFactory.getListOfCustomers()) {
			createPageCustomer(menuCustomer, customer, myFrame);
		}
		
		for (Driver driver : DriverFactory.getListOfDrivers()) {
			createPageDriver(menuDriver, driver, myFrame);
		}
		
		menuBar.add(menuControl);
		menuBar.add(menuCustomer);
		menuBar.add(menuDriver);
		myFrame.setJMenuBar(menuBar);
		
		
		myFrame.pack();
		
		myFrame.setVisible(true);
		
	}
	
	
	
	public static void createPageCustomer (JMenu menu, Customer customer, JFrame myFrame) {
		JMenuItem page = new JMenuItem(customer.getId());
		page.addActionListener(new CustomerListener(customer, myFrame));
		menu.add(page);
	}
	public static void createPageDriver (JMenu menu, Driver driver, JFrame myFrame) {
		JMenuItem page = new JMenuItem(driver.getId());
		page.addActionListener(new DriverListener(driver, myFrame));
		menu.add(page);
	}
	public static JPanel getCustomerDescription (Customer customer) {
		JPanel description = new JPanel();
		description.setBackground(Color.white);
	    description.setPreferredSize(new Dimension(500, 120));
	    description.setBorder(BorderFactory.createTitledBorder("Fiche client"));
	    JLabel nomLabel = new JLabel("Nom : " + customer.getName());
	    JLabel prenomLabel = new JLabel("Prenom : " + customer.getSurname());
	    JLabel gpsLabel = new JLabel("Votre position : " + customer.getGps());
	    description.add(nomLabel);
	    description.add(prenomLabel);
	    description.add(gpsLabel);
	    return description;
	}
	
}