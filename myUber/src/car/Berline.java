package car;

import java.util.ArrayList;

import myUber.Driver;
import myUber.GPS;

public class Berline extends Car {

	
	/// Attributs de la berline
	static String type = "Berline";
	String carID;
	static int nbrSeat = 4;
	String carStatus = "available";
	ArrayList<Driver> Conducteurs = new ArrayList<Driver>();
	
	
	
	/// constucteur, via super
	public Berline(String ID, GPS carGPS) {
		super (type, ID, nbrSeat, carGPS);
	}
	
	
}