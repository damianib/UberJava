package myUber;

public class Van extends Car {

	double carGPS;
	static String type = "van";
	String carID;
	static int nbrSeat = 6;
	
	public Van(double GPS, String ID) {
		super (GPS, type, ID, nbrSeat);
	}
	
	
}