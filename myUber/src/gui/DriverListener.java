package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import car.Car;
import car.CarFactory;
import myUber.Driver;

public class DriverListener implements ActionListener {

	Driver driver;
	JFrame frame;
	DriverListener (Driver driv, JFrame fra) {
		this.driver = driv;
		this.frame = fra;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		JPanel description = new JPanel();		
		description.setBackground(Color.white);
		description.setPreferredSize(new Dimension(500, 120));
		description.setBorder(BorderFactory.createTitledBorder("Fiche conducteur"));
		JLabel nomLabel = new JLabel("Nom : " + this.driver.getName());
		JLabel prenomLabel = new JLabel("Prenom : " + this.driver.getSurname());
		//JLabel gpsLabel = new JLabel("Votre position : " + this.driver.getGps());
		description.add(nomLabel);
		description.add(prenomLabel);
		//description.add(gpsLabel);
		
		JPanel voiture = new JPanel();
		voiture.setBackground(Color.white);
		voiture.setPreferredSize(new Dimension(500,120));
		voiture.setBorder(BorderFactory.createTitledBorder("Voiture associée"));
		Car car = findCar(this.driver);
		JLabel modelLabel = new JLabel("Modele de voiture : " + car.getType());
		JLabel idLabel = new JLabel("L'id de la voiture : " + car.getCarID());
		voiture.add(modelLabel);
		voiture.add(idLabel);
		
		
		JPanel action = new JPanel();
	    action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 120));
	    action.setBorder(BorderFactory.createTitledBorder("Proposition correcte"));
	    JLabel prop = new JLabel("JE VOUS BAISE");
	    action.add(prop);
		
	    JPanel panel = new JPanel ();
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(voiture, BorderLayout.CENTER);
	    panel.add(action, BorderLayout.SOUTH);
	    frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}
	
	public Car findCar(Driver driver) {
		ArrayList<Car> listeOfCar = CarFactory.getListOfCars();
		for (Car car : listeOfCar) {
			for (Driver driv : car.getDrivers()) {
				if (driv == driver) { return car; }
			}
		}
		return null;
	}

}
