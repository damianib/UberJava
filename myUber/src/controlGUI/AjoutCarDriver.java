package controlGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;

import car.Car;
import car.CarFactory;
import gui.JFrame1stExemple;
import myUber.Driver;
import myUber.DriverFactory;
import myUber.GPS;

public class AjoutCarDriver implements ActionListener {

	JFrame frame; JMenu menuDriver; JMenu menuCar; JComboBox<String> typeCar; JTextField name; JTextField surname;
	AjoutCarDriver(JFrame frame, JMenu menuDriver, JMenu menuCar, JComboBox<String> typeCar, JTextField name, JTextField surname) {
		this.frame = frame;
		this.menuDriver = menuDriver;
		this.menuCar = menuCar;
		this.typeCar = typeCar;
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DriverFactory.createDriver(name.getText(), surname.getText());
		Driver driver = DriverFactory.getListOfDrivers().get(DriverFactory.getListOfDrivers().size()-1);
		CarFactory.createCar((String) this.typeCar.getSelectedItem(), GPS.randGPS());
		Car car = CarFactory.getListOfCars().get(CarFactory.getListOfCars().size()-1);
		car.addDriver(driver);
		driver.addCar(car);
		JFrame1stExemple.createPageCar(menuCar, car, frame);
		JFrame1stExemple.createPageDriver(menuDriver, driver, frame);
		
	}

}
