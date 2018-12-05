package controlGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import car.Car;
import car.CarFactory;
import myUber.Customer;
import myUber.CustomerFactory;

public class DeplacementListener implements ActionListener {

	JFrame frame;
	public DeplacementListener(JFrame frame) { this.frame = frame;}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel deplacerCustomer = createDeplacementPanel("customer");
		JPanel deplacerCar = createDeplacementPanel("car");
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
	    panel.setPreferredSize(new Dimension(500, 120));
	    panel.setBorder(BorderFactory.createTitledBorder("Deplacement"));
	    panel.add(deplacerCustomer);
	    panel.add(deplacerCar);
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}

	
	public JPanel createDeplacementPanel (String type) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
	    panel.setPreferredSize(new Dimension(500, 60));
	    JComboBox<String> demanderID = new JComboBox<String>();
		if (type.equals("customer")) {
			panel.setBorder(BorderFactory.createTitledBorder("Deplacer un Customer"));
			
			for (Customer customer : CustomerFactory.getListOfCustomers()) {
				demanderID.addItem(customer.getId());
			}
		}
		else if (type.equals("car")) {
			panel.setBorder(BorderFactory.createTitledBorder("Deplacement une Car"));
			for (Car car : CarFactory.getListOfCars()) {
				demanderID.addItem(car.getCarID());
			}
		}
		
		
		JLabel descr = new JLabel("entrez les nouvelles coordonnees de l'objet");
	    JLabel XLabel = new JLabel("X : ");
	    JLabel YLabel = new JLabel("Y : ");
	    JTextField X = new JTextField("10");
	    JTextField Y = new JTextField("10");
	    
	    JButton ok = new JButton("ok");
	    ok.addActionListener(new DeplacerObjet(frame, type, demanderID, X, Y));
		
	    panel.add(demanderID);
	    panel.add(descr);
	    panel.add(XLabel);
	    panel.add(X);
	    panel.add(YLabel);
	    panel.add(Y);
	    panel.add(ok);
		return panel;
	}
}
