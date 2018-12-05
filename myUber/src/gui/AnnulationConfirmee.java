package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Driver;

public class AnnulationConfirmee implements ActionListener {

	Driver driver;
	JFrame frame;
	AnnulationConfirmee (Driver driver, JFrame frame) { this.frame = frame; this.driver = driver;}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.driver.setState("on-duty");
		new DriverListener(driver, frame).actionPerformed(e);
		
	}

}
