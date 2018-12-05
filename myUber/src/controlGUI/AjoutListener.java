package controlGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import car.Car;
import car.CarFactory;

public class AjoutListener implements ActionListener {

	JFrame frame; JMenu menuCustomer; JMenu menuDriver; JMenu menuCar;
	public AjoutListener(JFrame frame, JMenu menuCustomer, JMenu menuDriver, JMenu menuCar) { 
		this.frame = frame;
		this.menuCustomer = menuCustomer;
		this.menuDriver = menuDriver;
		this.menuCar = menuCar;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel driverCar = createCarDriver();
		JPanel driver = createDriver();
		JPanel customer = createCustomer();
		
		JPanel panel = new JPanel();
		panel.add(customer);
		panel.add(driverCar);
		panel.add(driver);
		
		frame.setContentPane(panel);
	    frame.setVisible(true);
		
	}

	private JPanel createCarDriver() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
	    panel.setPreferredSize(new Dimension(500, 120));
	    panel.setBorder(BorderFactory.createTitledBorder("Ajout d'un driver avec voiture"));
	    JTextField name = new JTextField("Name");
	    JTextField surname = new JTextField("Surname");
	    JComboBox<String> typeCar = new JComboBox<String>();
	    typeCar.addItem("Standard");
	    typeCar.addItem("Van");
	    typeCar.addItem("Berline");
	    JButton create = new JButton("Create");
	    create.addActionListener(new AjoutCarDriver(frame, this.menuDriver, this.menuCar, typeCar, name, surname));
	    panel.add(typeCar);
	    panel.add(name);
	    panel.add(surname);
	    panel.add(create);
	    return panel;
	}
	
	
	
	private JPanel createCustomer() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
	    panel.setPreferredSize(new Dimension(500, 120));
	    panel.setBorder(BorderFactory.createTitledBorder("Ajout d'un customer"));
	    
	    JTextField name = new JTextField("Name");
	    JTextField surname = new JTextField("Surname");
	    JButton create = new JButton("Create");
	    create.addActionListener(new AjoutCustomer(frame, this.menuCustomer, name, surname));
	    panel.add(name);
	    panel.add(surname);
	    panel.add(create);
	    return panel;
	}
	
	private JPanel createDriver() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
	    panel.setPreferredSize(new Dimension(500, 120));
	    panel.setBorder(BorderFactory.createTitledBorder("Ajout d'un driver seul"));
	    
	    JComboBox<String> idCar = new JComboBox<String>();
	    for (Car car : CarFactory.getListOfCars()) { idCar.addItem(car.getCarID()); }
	    
	    JTextField name = new JTextField("Name");
	    JTextField surname = new JTextField("Surname");
	    
	    JButton create = new JButton("Create");
	    create.addActionListener(new AjoutDriver(frame, this.menuDriver, idCar, name, surname));
	    
	    panel.add(idCar);
	    panel.add(name);
	    panel.add(surname);
	    panel.add(create);
	    return panel;
	}
	
	
	
	
	
	
	
	
	
	
	
}
