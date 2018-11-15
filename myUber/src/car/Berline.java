package car;

import java.util.ArrayList;

public class Berline extends Car {

	
	/// Attributs de la berline
	ArrayList<Double> carGPS = new ArrayList <Double>();
	static String type = "berline";
	String carID;
	static int nbrSeat = 4;
	ArrayList<String> Conducteurs = new ArrayList<String>();
	
	
	
	/// constucteur, via super
	public Berline(String ID) {
		super (type, ID, nbrSeat);
	}
	
	
}