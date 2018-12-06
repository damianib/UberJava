package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import car.Car;
import car.CarFactory;
import controlGUI.AjoutListener;
import controlGUI.DeplacementListener;
import guiStatistique.CustomerStat;
import guiStatistique.DriverStat;
import guiStatistique.GlobalStat;
import myUber.Customer;
import myUber.CustomerFactory;
import myUber.Driver;
import myUber.DriverFactory;

public class FramePrincipale {
	
	
	public static void lancer() {
		
		//MyUber.setup(0, 2, 3, 4);
		
		JFrame myFrame =new JFrame("myUber controler");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setPreferredSize(new Dimension(1000, 1000));
		
		// creer les menus déroulant
		JMenuBar menuBar = new JMenuBar();
		JMenu menuControl = new JMenu("Control");
		JMenu menuCustomer = new JMenu("Customer");
		JMenu menuDriver = new JMenu("Driver");
		JMenu menuCar = new JMenu("Car");
		JMenu menuStat = new JMenu("Statistiques");
		
		//implementer le menu car
		for (Car car : CarFactory.getListOfCars()) {
			createPageCar(menuCar, car, myFrame);
		}
		
		// implementer le menu client
		for (Customer customer : CustomerFactory.getListOfCustomers()) {
			createPageCustomer(menuCustomer, customer, myFrame);
		}
		
		//implementer le menu driver
		for (Driver driver : DriverFactory.getListOfDrivers()) {
			createPageDriver(menuDriver, driver, myFrame);
		}
		
		//implementer le menu control
		createPageAjout(menuControl, menuCustomer, menuDriver, menuCar, myFrame);
		//createPageSimulation(menuControl);
		createPageDeplacement(menuControl, myFrame);
		
		//implementer le menu statistiques
		createPageStatDriver(menuStat, myFrame);
		createPageStatCustomer(menuStat, myFrame);
		createPageStatGlobal(menuStat, myFrame);
		
		
		menuBar.add(menuControl);
		menuBar.add(menuCustomer);
		menuBar.add(menuDriver);
		menuBar.add(menuCar);
		menuBar.add(menuStat);
		myFrame.setJMenuBar(menuBar);
		
		
		myFrame.pack();
		
		myFrame.setVisible(true);
		
	}
	
	
	public static void createPageStatDriver(JMenu menu, JFrame myFrame) {
		 JMenuItem page = new JMenuItem("Drivers");
		 page.addActionListener(new DriverStat(myFrame));
		 menu.add(page);
		 
	}
	public static void createPageStatCustomer(JMenu menu, JFrame myFrame) {
		 JMenuItem page = new JMenuItem("Customers");
		 page.addActionListener(new CustomerStat(myFrame));
		 menu.add(page);
		 
	}
	public static void createPageStatGlobal(JMenu menu, JFrame myFrame) {
		 JMenuItem page = new JMenuItem("Global");
		 page.addActionListener(new GlobalStat(myFrame));
		 menu.add(page);
		 
	}
	
	
	public static void createPageAjout(JMenu menuControl,JMenu menuCustomer,JMenu menuDriver,JMenu menuCar, JFrame myFrame) {
		JMenuItem page = new JMenuItem("Ajouts");
		page.addActionListener(new AjoutListener(myFrame, menuCustomer, menuDriver, menuCar));
		menuControl.add(page);
	}
	public static void createPageDeplacement(JMenu menu, JFrame myFrame) {
		 JMenuItem page = new JMenuItem("Deplacement");
		 page.addActionListener(new DeplacementListener(myFrame));
		 menu.add(page);
		 
	}
	public static void createPageCar(JMenu menu, Car car, JFrame myFrame) {
		JMenuItem page = new JMenuItem(car.getCarID());
		page.addActionListener(new CarListener(car, myFrame));
		menu.add(page);
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
	    nomLabel.setPreferredSize(new Dimension(500, 20));
	    JLabel prenomLabel = new JLabel("Prenom : " + customer.getSurname());
	    prenomLabel.setPreferredSize(new Dimension(500, 20));
	    JLabel gpsLabel = new JLabel("Votre position : " + customer.getGps());
	    gpsLabel.setPreferredSize(new Dimension(500, 20));
	    description.add(nomLabel);
	    description.add(prenomLabel);
	    description.add(gpsLabel);
	    return description;
	}
	
	public static JPanel getDriverDescription (Driver driver) {
		JPanel description = new JPanel();		
		description.setBackground(Color.white);
		description.setPreferredSize(new Dimension(500, 120));
		description.setBorder(BorderFactory.createTitledBorder("Fiche conducteur"));
		JLabel nomLabel = new JLabel("Nom : " + driver.getName());
		nomLabel.setPreferredSize(new Dimension(400,30));
		JLabel prenomLabel = new JLabel("Prenom : " + driver.getSurname());
		prenomLabel.setPreferredSize(new Dimension(400,30));
		JLabel evaluation = new JLabel("Votre evaluation : " + Double.toString(driver.getEvaluation()));
		description.add(nomLabel);
		description.add(prenomLabel);
		description.add(evaluation);
		return description;
		
	}
	
	public static JPanel getCarDescription (Driver driver) {
		JPanel voiture = new JPanel();
		voiture.setBackground(Color.white);
		voiture.setPreferredSize(new Dimension(500,200));
		voiture.setBorder(BorderFactory.createTitledBorder("Voitures associées"));
		for (Car car : driver.getCars()) {
			JLabel modelLabel = new JLabel("Modele de voiture : " + car.getType());
			modelLabel.setPreferredSize(new Dimension(200,40));
			JLabel idLabel = new JLabel("L'id de la voiture : " + car.getCarID());
			idLabel.setPreferredSize(new Dimension(200,40));
			voiture.add(modelLabel);
			voiture.add(idLabel);
		}
		return voiture;
	}
	
	public static Car idToCar(String id) {
		for (Car car : CarFactory.getListOfCars()) { if (car.getCarID().equals(id)) { return car; } }
		return null;
	}
	public static Customer idToCustomer(String id) {
		for (Customer customer : CustomerFactory.getListOfCustomers()) { if (customer.getId().equals(id)) { return customer; } }
		return null;
	}
	
	
	
	
	
	
	
	
}