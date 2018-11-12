package myUber;

import java.util.ArrayList;

public abstract class Ride {
	
	protected String status;
	protected ArrayList<Double> basicRates;
	protected ArrayList<Double> trafficRates;
	
	
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

}
