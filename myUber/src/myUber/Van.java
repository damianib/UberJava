package myUber;

public class Van extends Car {

	
	///les attributs
	double carGPS;
	static String type = "van";
	String carID;
	static int nbrSeat = 6;
	
	
	///le constucteur, via le super
	public Van(double GPS, String ID) {
		super (GPS, type, ID, nbrSeat);
	}
	
	
}