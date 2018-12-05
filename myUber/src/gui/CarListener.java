package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import car.Car;
import myUber.Driver;

public class CarListener implements ActionListener {

	Car car;
	JFrame frame;
	CarListener (Car car, JFrame frame) {
		this.car = car;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel description = new JPanel();
		description.setBackground(Color.white);
	    description.setPreferredSize(new Dimension(500, 200));
	    description.setBorder(BorderFactory.createTitledBorder("Fiche voiture"));
	    JLabel type = new JLabel("Type : " + car.getType());
	    type.setPreferredSize(new Dimension(500, 20));
	    JLabel etat = new JLabel("Etat : " + car.getCarStatus());
	    etat.setPreferredSize(new Dimension(500, 20));
	    JLabel gpsLabel = new JLabel("La position : " + car.getCarGPS());
	    gpsLabel.setPreferredSize(new Dimension(500, 20));
	    description.add(type);
	    description.add(etat);
	    description.add(gpsLabel);
	    String str = "Liste des drivers : ";
	    for (Driver driv : car.getDrivers()) {
	    	str = str + driv.getId() + " ";
	    }
	    JLabel driver = new JLabel (str);
	    driver.setPreferredSize(new Dimension(500, 20));
	    description.add(driver);
	    
	    //fin
	    JPanel panel = new JPanel ();
	    panel.add(description);
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}

}
