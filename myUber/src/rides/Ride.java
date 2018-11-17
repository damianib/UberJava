package rides;

import java.util.ArrayList;

import myUber.GPS;

public abstract class Ride {
	
	protected String status;
	protected ArrayList<Double> basicRates = new ArrayList<Double>();
	protected ArrayList<Double> trafficRates = new ArrayList<Double>();
	protected GPS depart;
	protected GPS arrivee;
	protected double length; 
	//protected double lenght = 2.;
	
	
	/// fonction qui renvoie le coefficient adapté à la longueur du trajet 
	public double basicRate() {
		
		if (length < 5) {
			return this.basicRates.get(0);
		}
		else if (length < 10) {
			return this.basicRates.get(1);
		}
		else if (length < 20) {
			return this.basicRates.get(2);
		}
		else {
			return this.basicRates.get(3);
		}
		
	}
	
	/// fonction qui renvoie le coefficient adapté au traffic présent
	public double trafficRate(String traffic) {
		
		if (traffic == "low") {
			return this.trafficRates.get(0);
		}
		else if (traffic == "medium") {
			return this.trafficRates.get(1);
		}
		else {
			return this.trafficRates.get(2);
		}
		
	}
	
	///fonction qui renvoie le cout total du ride
	public double rate(String traffic) {
		
		return this.basicRate()*this.length*this.trafficRate(traffic);
		
	}

	
	/// Constructor
	public Ride(String status, GPS depart, GPS arrivee) {
		this.status = status;
		this.depart = depart;
		this.arrivee = arrivee;
		this.length = GPS.distance(depart, arrivee);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Double> getBasicRates() {
		return basicRates;
	}

	public void setBasicRates(ArrayList<Double> basicRates) {
		this.basicRates = basicRates;
	}

	public ArrayList<Double> getTrafficRates() {
		return trafficRates;
	}

	public void setTrafficRates(ArrayList<Double> trafficRates) {
		this.trafficRates = trafficRates;
	}

	public GPS getDepart() {
		return depart;
	}

	public void setDepart(GPS depart) {
		this.depart = depart;
	}

	public GPS getArrivee() {
		return arrivee;
	}

	public void setArrivee(GPS arrivee) {
		this.arrivee = arrivee;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

}
