package myUber;

public class Standard extends Car {

	double carGPS;
	static String type = "standard";
	String carID;
	static int nbrSeat = 4;
	int nbrLibre = 4;
	
	public Standard(double GPS, String ID) {
		super (GPS, type, ID, nbrSeat);
	}

	public int getNbrLibre() {
		return nbrLibre;
	}

	public void setNbrLibre(int nbrLibre) {
		this.nbrLibre = nbrLibre;
	}
	
	
}
