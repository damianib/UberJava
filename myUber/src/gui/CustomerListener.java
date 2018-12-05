package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myUber.Customer;
import rides.Ride;
import rides.RideFactory;

public class CustomerListener implements ActionListener {

	
	Customer customer;
	JFrame frame;
	CustomerListener(Customer cust, JFrame fra) {
		this.customer = cust;
		this.frame = fra;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JPanel description = JFrame1stExemple.getCustomerDescription(this.customer);
	    
	    JPanel action = createCustomerActionPanel();
	    
	    JPanel panel = new JPanel ();
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(action, BorderLayout.SOUTH);
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}
	
	public JPanel createCustomerActionPanel() {
		JPanel action = new JPanel();
	    action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 120));
	    action.setBorder(BorderFactory.createTitledBorder("Votre situation"));
	    if (this.customer.getStatus().equals("free")) {
	    	JLabel prop = new JLabel("Pour commander un trajet, cliquez sur le bouton ");
	    	JButton demarrer = new JButton("rechercher un ride");
	    	demarrer.addActionListener(new RechercherRide(this.customer, this.frame));
	    	action.add(prop, BorderLayout.NORTH);
	    	action.add(demarrer, BorderLayout.SOUTH);
	    	
	    }
	    else if (this.customer.getStatus().equals("waiting_confirmation")) {
	    	Ride ride = RideFactory.recupererRide(this.customer);
	    	JPanel recap = new JPanel();
	    	recap.setBackground(Color.white);
	    	recap.add(new JLabel("Vous avez commander un " + ride.getType()));
	    	JPanel temps = new JPanel();
	    	temps.setBackground(Color.white);
	    	temps.add(new JLabel("En attente de confirmation du conducteur "));
	    	action.add(recap, BorderLayout.NORTH);
	    	action.add(temps, BorderLayout.SOUTH);
	    	JButton cancel = new JButton("annuler le ride");
	    	cancel.addActionListener(new AnnulationConfirmation(ride, this.frame));
	    	action.add(cancel);
	    	
	    }
	    else if (this.customer.getStatus().equals("embarquement")) {
	    	
	    }
	    else if (this.customer.getStatus().contentEquals("en_route")) {
	    	
	    }
	    return action;
	}

}
