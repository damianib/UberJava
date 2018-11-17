package rides;

import myUber.GPS;

public class UberPool extends Ride {

	public UberPool(GPS depart, GPS arrivee) {
		super(depart, arrivee);
		
		this.basicRates.add(2.4);
		this.basicRates.add(3.);
		this.basicRates.add(1.3);
		this.basicRates.add(1.1);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.1);
		this.trafficRates.add(1.2);
		
		this.carType = "Standard";
	}
	
	

}
