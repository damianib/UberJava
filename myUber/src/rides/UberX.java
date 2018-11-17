package rides;

import myUber.GPS;

public class UberX extends Ride {

	public UberX(GPS depart, GPS arrivee) {
		super(depart, arrivee);
		
		this.basicRates.add(3.3);
		this.basicRates.add(4.2);
		this.basicRates.add(1.91);
		this.basicRates.add(1.5);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.1);
		this.trafficRates.add(1.5);
		
		this.carType = "Standard";
	}
	
	

}
