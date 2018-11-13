package myUber;

abstract class Car {
	
	
	///les attributs des voitures
	double carGPS;
	String type;
	String carID;
	int nbrSeat;
	
	
	///le constructeur abstrait
	public Car(double carGPS, String type, String carID, int nbrSeat) {
		this.carGPS = carGPS;
		this.type = type;
		this.carID = carID;
		this.nbrSeat = nbrSeat;
	}
	
	
	

///les fonctions pour récuperer et modifier les attributs
	public double getCarGPS() {
		return carGPS;
	}
	public void setCarGPS(double carGPS) {
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
