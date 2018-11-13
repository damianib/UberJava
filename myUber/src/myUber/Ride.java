package myUber;

import java.util.ArrayList;

public abstract class Ride {
	
	protected String status;
	protected ArrayList<Double> basicRates = new ArrayList<Double>();
	protected ArrayList<Double> trafficRates = new ArrayList<Double>();
	
	/// fonction qui renvoie le coefficient adapté à la longueur du trajet 
	public double basicRate(double length) {
		
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

	
	/// Constructor
	public Ride(String status) {
		super();
		this.status = status;
	}
	
	

}
