package myUber;

public class Standard extends Car {

	
	/// Attributs de la Standart
	double carGPS;
	static String type = "standard";
	String carID;
	static int nbrSeat = 4;
	int nbrLibre = 4;
	
	
	/// Constucteur
	public Standard(double GPS, String ID) {
		super (type, ID, nbrSeat);
	}

	
	/// fonctions concernant les sièges libres, pour UberPool
	public int getNbrLibre() {
		return nbrLibre;
	}
	public void setNbrLibre(int nbrLibre) {
		this.nbrLibre = nbrLibre;
	}
	
	
}
