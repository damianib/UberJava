package myUber;

import java.util.ArrayList;

abstract class Car {
	
	
	///les attributs des voitures
	ArrayList <Double> carGPS = new ArrayList<Double>();
	String type;
	String carID;
	int nbrSeat;
	ArrayList<String> Conducteurs = new ArrayList<String>();
	
	
	///le constructeur abstrait
	public Car(String type, String carID, int nbrSeat) {
		this.type = type;
		this.carID = carID;
		this.nbrSeat = nbrSeat;
	}
	
	
	

///les fonctions pour récuperer et modifier les attributs
	public ArrayList<Double> getCarGPS() {
		return carGPS;
	}
	public void setCarGPS(ArrayList<Double> carGPS) {
		this.carGPS = carGPS;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public int getNbrSeat() {
		return nbrSeat;
	}
	public void setNbrSeat(int nbrSeat) {
		this.nbrSeat = nbrSeat;
	}
	
	
	
	
}
