package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import rides.Ride;
import rides.RideFactory;

public class AnnulationConfirmation implements ActionListener {

	JFrame frame;
	Ride ride;
	AnnulationConfirmation (Ride ride, JFrame frame) {
		this.ride = ride;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.ride.getCustomer().setStatus("free");
		this.ride.getDriver().setState("on-duty");
		this.ride.setStatus("Canceled_before_driver_confirmation");
		RideFactory.getRideEnCours().remove(this.ride);
		RideFactory.getRideFinies().add(this.ride);
		new CustomerListener(this.ride.getCustomer(), this.frame).actionPerformed(e);	
	}

}
