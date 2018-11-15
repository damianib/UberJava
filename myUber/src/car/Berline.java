package car;

import java.util.ArrayList;

import myUber.GPS;

public class Berline extends Car {

	
	/// Attributs de la berline
	GPS carGPS = new GPS(0. ,0.);
	static String type = "berline";
	String carID;
	static int nbrSeat = 4;
	ArrayList<String> Conducteurs = new ArrayList<String>();
	
	
	
	/// constucteur, via super
	public Berline(String ID) {
		super (type, ID, nbrSeat);
	}
	
	
}