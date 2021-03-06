package rides;

import myUber.Customer;
import myUber.GPS;

public class UberBlack extends Ride {

	public UberBlack(Customer customer, GPS depart, GPS arrivee) {
		super(customer, depart, arrivee);
		
		this.basicRates.add(6.2);
		this.basicRates.add(5.5);
		this.basicRates.add(3.25);
		this.basicRates.add(2.6);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.3);
		this.trafficRates.add(1.6);
		
		this.carType = "Berline";
		this.type = "UberBlack";
		
	}
	
	

}
