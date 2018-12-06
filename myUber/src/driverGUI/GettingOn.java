package driverGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.DriverListener;
import myUber.Driver;

public class GettingOn implements ActionListener {

	JFrame frame;
	Driver driver;
	public GettingOn(Driver driver, JFrame frame) {
		this.driver = driver;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.driver.setState("on-duty");
		new DriverListener(this.driver, this.frame).actionPerformed(e);
		
	}

}
