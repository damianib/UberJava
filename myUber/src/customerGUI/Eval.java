package customerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import gui.CustomerListener;
import myUber.BookOfRides;
import myUber.Customer;
import rides.Ride;
import rides.RideFactory;

public class Eval implements ActionListener {
	
	JFrame frame;
	Customer customer;
	JComboBox<String> eval;
	public Eval(JFrame frame, Customer customer, JComboBox<String> eval) {
		this.frame = frame;
		this.customer = customer;
		this.eval = eval;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String valeur = (String) this.eval.getSelectedItem();
		Integer note = notation(valeur);
		Ride ride = RideFactory.customerToRide(this.customer);
		ride.getDriver().ajouterEval(note);
		RideFactory.getRideEnCours().remove(ride);
		BookOfRides.addEntry(ride.getCar(), ride.getDriver(), ride);
		customer.setStatus("free");
		new CustomerListener(this.customer, this.frame).actionPerformed(e);
		
	}

	private Integer notation(String valeur) {
		if (valeur.equals("Parfait")) { return 5; }
		if (valeur.equals("Très bien")) { return 4; }
		if (valeur.equals("Bien")) { return 3; }
		if (valeur.equals("Decevant")) { return 2; }
		if (valeur.equals("Horrible")) { return 1; }
		return null;
	}
	
}
