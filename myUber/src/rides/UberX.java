package rides;

import myUber.Customer;
import myUber.GPS;

public class UberX extends Ride {

	public UberX(Customer customer, GPS depart, GPS arrivee) {
		super(customer, depart, arrivee);
		
		this.basicRates.add(3.3);
		this.basicRates.add(4.2);
		this.basicRates.add(1.91);
		this.basicRates.add(1.5);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.1);
		this.trafficRates.add(1.5);
		
		this.carType = "Standard";
		this.type = "UberX";
	}
	
	

}
