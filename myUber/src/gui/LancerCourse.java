package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import car.Car;
import car.CarFactory;
import myUber.Driver;
import myUber.MyUber;
import rides.Ride;
import rides.RideFactory;

public class LancerCourse implements ActionListener {
	
	Ride ride;
	JFrame frame;
	LancerCourse(Ride ride, JFrame frame) {
		this.ride = ride;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Car car = MyUber.trouverVoiture(this.ride.getCarType(), this.ride.getDepart(), CarFactory.getListOfCars());
		if (!(car == null)) {
			Driver driver = MyUber.trouverConducteur(car);
			this.ride.setCar(car);
			this.ride.setDriver(driver);
			this.ride.setStatus("confirmed");
			car.setCarStatus("unavailable");
			driver.setState("asked");
			this.ride.getCustomer().setStatus("waiting_confirmation");
			RideFactory.getRideEnCours().add(this.ride);
			new CustomerListener(this.ride.getCustomer(), this.frame).actionPerformed(e);
			
		}
		else {
			JPanel description = JFrame1stExemple.getCustomerDescription(this.ride.getCustomer());
			JPanel action = new JPanel();
			action.setBackground(Color.white);
		    action.setPreferredSize(new Dimension(500, 300));
		    action.setBorder(BorderFactory.createTitledBorder("Ride non disponible"));
		    action.add(new JLabel ("nous sommes désolé tous nos drivers de " + this.ride.getCarType() + " sont indisponibles"));
		    action.add(new JLabel("Veuillez réessayer plus tard, ou changer de type de ride"));
		    JButton ok = new JButton("ok");
		    ok.addActionListener(new CustomerListener(this.ride.getCustomer(), this.frame));
		    action.add(ok);
		  //la fin 
		    JPanel panel = new JPanel ();
		    panel.add(description, BorderLayout.NORTH);
		    panel.add(action, BorderLayout.SOUTH);
		    
		    frame.setContentPane(panel);
		    frame.setVisible(true);
		}
		
		
	}

}
