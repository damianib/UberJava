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
import myUber.GPS;
import rides.Ride;
import rides.RideFactory;

public class EnvoyerPrix implements ActionListener {

	Customer customer;
	JFrame frame;
	GPS arrivee;
	JTextField X;
	JTextField Y;
	EnvoyerPrix (Customer customer, JFrame frame, JTextField X, JTextField Y) {
		this.customer = customer;
		this.frame = frame;
		this.X = X;
		this.Y = Y;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.arrivee = new GPS(Double.parseDouble(X.getText()), Double.parseDouble(Y.getText()));
		
		JPanel description = JFrame1stExemple.getCustomerDescription(this.customer);
		
		JPanel action = new JPanel();
		action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 350));
	    action.setBorder(BorderFactory.createTitledBorder("Voici les prix"));
	    
	    Ride egVan = RideFactory.createRide(this.customer, "UberVan", this.customer.getGps(), this.arrivee);
	    Ride egX = RideFactory.createRide(this.customer, "UberX", this.customer.getGps(), this.arrivee);
	    Ride egBlack = RideFactory.createRide(this.customer, "UberBlack", this.customer.getGps(), this.arrivee);
	    
	    JPanel van = new JPanel();
	    van.setBackground(Color.white);
	    van.setPreferredSize(new Dimension(500, 80));
	    van.setBorder(BorderFactory.createTitledBorder("UberVan"));
	    van.add(new JLabel("Le prix d'un ride UberVan : " + Double.toString(egVan.rate())));
	    JButton lancerVan = new JButton("Choisir UberVan");
	    lancerVan.addActionListener(new LancerCourse(egVan, this.frame));
	    van.add(lancerVan);
	    
	    JPanel black = new JPanel();
	    black.setBackground(Color.white);
	    black.setPreferredSize(new Dimension(500, 80));
	    black.setBorder(BorderFactory.createTitledBorder("UberBlack"));
	    black.add(new JLabel("Le prix d'un ride UberBlack : " + Double.toString(egBlack.rate())));
	    JButton lancerBlack = new JButton("Choisir UberBlack");
	    lancerBlack.addActionListener(new LancerCourse(egBlack, this.frame));
	    black.add(lancerBlack);
	    
	    JPanel uberX = new JPanel();
	    uberX.setBackground(Color.white);
	    uberX.setPreferredSize(new Dimension(500, 80));
	    uberX.setBorder(BorderFactory.createTitledBorder("UberX"));
	    uberX.add(new JLabel("Le prix d'un ride UberX : " + Double.toString(egX.rate())));
	    JButton lancerX = new JButton("Choisir UberX");
	    lancerX.addActionListener(new LancerCourse(egX, this.frame));
	    uberX.add(lancerX);
	    
	    JPanel pool = new JPanel();
	    pool.add(new JLabel("UberPool est actuellement indisponible, nous nous excusons pour la gene occasionée"));
	    
	    action.add(van);
	    action.add(black);
	    action.add(uberX);
	    action.add(pool);
	    
	    JButton cancel = new JButton("Cancel");
	    cancel.addActionListener(new CustomerListener(this.customer, this.frame));
	    action.add(cancel);
	    
		//la fin 
	    JPanel panel = new JPanel ();
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(action, BorderLayout.SOUTH);
	    
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}
		
	

}
