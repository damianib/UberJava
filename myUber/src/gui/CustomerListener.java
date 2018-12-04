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

public class CustomerListener implements ActionListener {

	
	Customer customer;
	JFrame frame;
	CustomerListener(Customer cust, JFrame fra) {
		this.customer = cust;
		this.frame = fra;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JPanel description = new JPanel();
		description.setBackground(Color.white);
	    description.setPreferredSize(new Dimension(500, 120));
	    description.setBorder(BorderFactory.createTitledBorder("Fiche client"));
	    JLabel nomLabel = new JLabel("Nom : " + this.customer.getName());
	    JLabel prenomLabel = new JLabel("Prenom : " + this.customer.getSurname());
	    JLabel gpsLabel = new JLabel("Votre position : " + this.customer.getGps());
	    description.add(nomLabel);
	    description.add(prenomLabel);
	    description.add(gpsLabel);
	    
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
	    	JLabel prop = new JLabel("Pour commander un trajet, cliquez sur le bouton ci dessous");
	    	JButton demarer = new JButton();
	    	action.add(prop, BorderLayout.NORTH);
	    	action.add(demarer, BorderLayout.SOUTH);
	    	
	    }
	    else if (this.customer.getStatus().equals("waiting")) {
	    	
	    }
	    else if (this.customer.getStatus().equals("embarquement")) {
	    	
	    }
	    else if (this.customer.getStatus().contentEquals("en_route")) {
	    	
	    }
	    return action;
	}

}
