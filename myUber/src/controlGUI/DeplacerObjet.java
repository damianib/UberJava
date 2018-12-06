package controlGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import gui.FramePrincipale;
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
		
		if (type.equals("car")) { FramePrincipale.idToCar((String) box.getSelectedItem()).setCarGPS(gps); }
		else if (type.equals("customer")) { FramePrincipale.idToCustomer((String) box.getSelectedItem()).setGps(gps); }
		 
		
	}

	
}

