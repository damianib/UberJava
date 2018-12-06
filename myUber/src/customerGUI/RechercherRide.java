package customerGUI;

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

import gui.CustomerListener;
import gui.FramePrincipale;
import myUber.Customer;

public class RechercherRide implements ActionListener {

	Customer customer;
	JFrame frame;
	public RechercherRide(Customer cust, JFrame fra) {
		this.customer = cust;
		this.frame = fra;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JPanel description = FramePrincipale.getCustomerDescription(this.customer);
		
		JPanel action = new JPanel();
		action.setBackground(Color.white);
	    action.setPreferredSize(new Dimension(500, 120));
	    action.setBorder(BorderFactory.createTitledBorder("Recherche de ride"));
	    
	    JLabel descr = new JLabel("entrez les coordonnees de votre destination");
	    JLabel XLabel = new JLabel("X : ");
	    JLabel YLabel = new JLabel("Y : ");
	    JTextField X = new JTextField("10");
	    JTextField Y = new JTextField("10");
	    
	    JPanel caseH = new JPanel();
	    caseH.add(descr);
	    caseH.add(XLabel);
	    caseH.add(X);
	    caseH.add(YLabel);
	    caseH.add(Y);
	    
	    JButton ok = new JButton("ok");
	    ok.addActionListener(new EnvoyerPrix(this.customer, this.frame, X, Y));
	    
	    action.add(caseH, BorderLayout.NORTH);
	    action.add(ok, BorderLayout.SOUTH);
	    
	    JButton cancel = new JButton("Cancel");
	    cancel.addActionListener(new CustomerListener(this.customer, this.frame));
	    action.add(cancel);
	    
		
	    JPanel panel = new JPanel ();
	    panel.add(description, BorderLayout.NORTH);
	    panel.add(action, BorderLayout.SOUTH);
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}

}
