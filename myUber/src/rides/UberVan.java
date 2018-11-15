package rides;

public class UberVan extends Ride {

	public UberVan(String status) {
		super(status);
		
		this.basicRates.add(6.2);
		this.basicRates.add(7.7);
		this.basicRates.add(3.25);
		this.basicRates.add(2.6);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.5);
		this.trafficRates.add(1.8);
	}
	
	

}
