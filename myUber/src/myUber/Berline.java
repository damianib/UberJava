package myUber;

public class Berline extends Car {

	double carGPS;
	static String type = "berline";
	String carID;
	static int nbrSeat = 4;
	
	public Berline(double GPS, String ID) {
		super (GPS, type, ID, nbrSeat);
	}
	
	
}