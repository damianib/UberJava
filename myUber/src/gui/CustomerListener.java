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
	    else if (this.customer.getStatus().equals("waiting")) {
	    	
	    }
	    else if (this.customer.getStatus().equals("embarquement")) {
	    	
	    }
	    else if (this.customer.getStatus().contentEquals("en_route")) {
	    	
	    }
	    return action;
	}

}
