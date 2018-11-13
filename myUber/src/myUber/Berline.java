package myUber;

public class Berline extends Car {

	
	/// Attributs de la berline
	double carGPS;
	static String type = "berline";
	String carID;
	static int nbrSeat = 4;
	
	
	
	/// constucteur, via super
	public Berline(double GPS, String ID) {
		super (GPS, type, ID, nbrSeat);
	}
	
	
}