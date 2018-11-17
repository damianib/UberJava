package car;

import java.util.ArrayList;

import myUber.Driver;
import myUber.GPS;

public class Standard extends Car {

	
	/// Attributs de la Standart
	GPS carGPS = new GPS(0. ,0.);
	static String type = "standard";
	String carID;
	static int nbrSeat = 4;
	ArrayList<Driver> Conducteurs = new ArrayList<Driver>();
	int nbrLibre = 4;
	
	
	/// Constucteur
	public Standard(String ID) {
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
