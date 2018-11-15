package car;

import java.util.ArrayList;

import myUber.GPS;

public class Van extends Car {

	
	///les attributs
	GPS carGPS = new GPS(0. ,0.);
	static String type = "Van";
	String carID;
	static int nbrSeat = 6;
	ArrayList<String> Conducteurs = new ArrayList<String>();
	
	
	///le constucteur, via le super
	public Van(String ID) {
		super (type, ID, nbrSeat);
	}
	
	
}