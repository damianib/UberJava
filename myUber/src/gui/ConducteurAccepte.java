package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Driver;

public class ConducteurAccepte implements ActionListener {

	JFrame frame;
	Driver driver;
	ConducteurAccepte (Driver driver, JFrame frame) {
		this.driver = driver;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
