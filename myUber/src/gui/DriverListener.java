package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

		JPanel description = JFrame1stExemple.getDriverDescription(this.driver);
		
		JPanel voiture = JFrame1stExemple.getCarDescription(this.driver);

		JPanel action = new JPanel();
	    action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 120));
	    action.setBorder(BorderFactory.createTitledBorder("Situation"));
	    if (this.driver.getState().equals("on-duty")) {
	    	JLabel etat = new JLabel("Vous etes de service, et n'avez actuellement aucune demande");
	    	etat.setPreferredSize(new Dimension(500, 40));
	    	JButton offDuty = new JButton("Get off-duty");
	    	JButton offline = new JButton("Get offline");
	    	offDuty.addActionListener(new GettingOff(this.driver, this.frame, "off-duty"));
	    	offline.addActionListener(new GettingOff(this.driver, this.frame, "offline"));
	    	action.add(etat);
	    	action.add(offDuty);
	    	action.add(offline);
	    }
	    else if (this.driver.getState().equals("offline") || this.driver.getState().equals("off-duty")) {
	    	JLabel etat = new JLabel("Vous etes " + this.driver.getState());
	    	etat.setPreferredSize(new Dimension(500, 40));
	    	JButton online = new JButton("Getting online");
	    	online.addActionListener(new GettingOn(this.driver, this.frame));
	    	action.add(etat);
	    	action.add(online);
	    }
	    else if (this.driver.getState().equals("asked")) {
	    	JLabel etat = new JLabel("Vous avez une demande de trajet !");
	    	etat.setPreferredSize(new Dimension(500, 40));
	    	JButton agree = new JButton("Take the ride");
	    	agree.addActionListener(new ConducteurAccepte(this.driver, this.frame));
	    	action.setBackground(Color.green);
	    	action.add(etat);
	    	action.add(agree);
	    }
	    
	    
	    
	    //fin
	    JPanel panel = new JPanel ();
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(voiture, BorderLayout.CENTER);
	    panel.add(action, BorderLayout.SOUTH);
	    frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}
	
	

}
