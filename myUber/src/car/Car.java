package car;

import java.util.ArrayList;

import myUber.Driver;
import myUber.GPS;

public abstract class Car {
	
	
	///les attributs des voitures
	GPS carGPS;
	String type;
	String carID;
	int nbrSeat;
	String carStatus;
	ArrayList<Driver> Conducteurs = new ArrayList<Driver>();
	
	
	///le constructeur abstrait
	public Car(String type, String carID, int nbrSeat, GPS carGPS) {
		this.type = type;
		this.carID = carID;
		this.nbrSeat = nbrSeat;
		this.carGPS = carGPS;
	}
	
	
	

///les fonctions pour récuperer et modifier les attributs
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public ArrayList<Driver> getDrivers () {
		return Conducteurs;
	}
	public void addDriver (Driver driver) {
		this.Conducteurs.add(driver);
	}
	public void removeDriver(Driver driver) {
		this.Conducteurs.remove(driver);
	}
	public GPS getCarGPS() {
		return carGPS;
	}
	public void setCarGPS(GPS carGPS) {
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
