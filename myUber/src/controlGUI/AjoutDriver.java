package controlGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;

import car.Car;
import gui.FramePrincipale;
import myUber.Driver;
import myUber.DriverFactory;

public class AjoutDriver implements ActionListener {

	JFrame frame; JMenu menuDriver; JComboBox<String> box; JTextField name; JTextField surname;
	AjoutDriver(JFrame frame,JMenu menuDriver, JComboBox<String> box, JTextField name, JTextField surname) {
		this.frame = frame;
		this.menuDriver = menuDriver;
		this.box = box;
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DriverFactory.createDriver(name.getText(), surname.getText());
		Driver driver = DriverFactory.getListOfDrivers().get(DriverFactory.getListOfDrivers().size()-1);
		Car car = FramePrincipale.idToCar((String) box.getSelectedItem());
		car.addDriver(driver);
		driver.addCar(car);
		FramePrincipale.createPageDriver(menuDriver, driver, frame);
	}

}
