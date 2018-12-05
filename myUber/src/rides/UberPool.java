package rides;

import myUber.Customer;
import myUber.GPS;

public class UberPool extends Ride {

	public UberPool(Customer customer, GPS depart, GPS arrivee) {
		super(customer, depart, arrivee);
		
		this.basicRates.add(2.4);
		this.basicRates.add(3.);
		this.basicRates.add(1.3);
		this.basicRates.add(1.1);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.1);
		this.trafficRates.add(1.2);
		
		this.carType = "Standard";
		this.type = "UberPool";
	}
	
	

}
