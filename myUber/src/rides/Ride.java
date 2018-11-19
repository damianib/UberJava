package rides;

import java.util.ArrayList;

import myUber.MyUber;
import myUber.Customer;
import myUber.GPS;

public abstract class Ride {
	
	protected String status = "unconfirmed";
	protected ArrayList<Double> basicRates = new ArrayList<Double>();
	protected ArrayList<Double> trafficRates = new ArrayList<Double>();
	protected GPS depart;
	protected GPS arrivee;
	protected double length;
	protected String traffic = MyUber.getTraffic();
	protected double duration;
	protected String carType;
	protected Customer customer;
	
	
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
	
	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
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
	
	/// fonction qui renvoie la durée du trajet (en s)
	public double duration(String traffic) {
		
		if (traffic == "low") {
			return this.length/15.*60*60;
		}
		else if (traffic == "medium") {
			return this.length/7.5*60*60;
		}
		else {
			return this.length/3.*60*60;
		}
		
	}
	
	///fonction qui renvoie le cout total du ride
	public double rate(String traffic) {
		
		return this.basicRate()*this.length*this.trafficRate(traffic);
		
	}

	
	/// Constructor
	public Ride(Customer customer, GPS depart, GPS arrivee) {
		this.depart = depart;
		this.arrivee = arrivee;
		this.length = GPS.distance(depart, arrivee);
		this.duration = duration(this.traffic);
		this.customer = customer;
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
