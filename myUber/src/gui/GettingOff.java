package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myUber.Driver;

public class GettingOff implements ActionListener {

	JFrame frame;
	Driver driver;
	String status;
	GettingOff(Driver driver, JFrame frame, String status) {
		this.frame = frame;
		this.driver = driver;
		this.status = status;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.status.equals("off-duty")) {
			this.driver.setState("off-duty");
		}
		else if (this.status.equals("offline")) {
			this.driver.setState("offline");
		}
		new DriverListener(this.driver, this.frame).actionPerformed(arg0);
	}

}
