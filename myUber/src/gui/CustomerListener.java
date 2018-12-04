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
		
		// generer une page avec des trucs dessus ^^
		JPanel panel = new JPanel ();
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
	    
	    JPanel action = new JPanel();
	    action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 120));
	    action.setBorder(BorderFactory.createTitledBorder("Proposition correcte"));
	    JLabel prop = new JLabel("JE VOUS BAISE");
	    
	    action.add(prop);
	    
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(action, BorderLayout.SOUTH);
	    
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}
	

}
