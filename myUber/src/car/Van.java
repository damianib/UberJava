package car;

import java.util.ArrayList;

public class Van extends Car {

	
	///les attributs
	ArrayList<Double> carGPS = new ArrayList<Double>();
	static String type = "Van";
	String carID;
	static int nbrSeat = 6;
	
	
	///le constucteur, via le super
	public Van(String ID) {
		super (type, ID, nbrSeat);
	}
	
	
}