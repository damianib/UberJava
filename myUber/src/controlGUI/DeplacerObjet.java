package controlGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import car.Car;
import car.CarFactory;
import gui.JFrame1stExemple;
import myUber.Customer;
import myUber.CustomerFactory;
import myUber.GPS;

public class DeplacerObjet implements ActionListener {

	JFrame frame;
	String type;
	JComboBox<String> box;
	JTextField X;
	JTextField Y;
	DeplacerObjet(JFrame frame, String type, JComboBox<String> box, JTextField X, JTextField Y) {
		this.frame = frame;
		this.type = type;
		this.box = box;
		this.X = X;
		this.Y = Y;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GPS gps = new GPS(Double.parseDouble(X.getText()), Double.parseDouble(Y.getText()));
		
		if (type.equals("car")) { JFrame1stExemple.idToCar((String) box.getSelectedItem()).setCarGPS(gps); }
		else if (type.equals("customer")) { JFrame1stExemple.idToCustomer((String) box.getSelectedItem()).setGps(gps); }
		 
		
	}

	
}

