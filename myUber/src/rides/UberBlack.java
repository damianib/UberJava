package rides;

public class UberBlack extends Ride {

	public UberBlack(String status) {
		super(status);
		
		this.basicRates.add(6.2);
		this.basicRates.add(5.5);
		this.basicRates.add(3.25);
		this.basicRates.add(2.6);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.3);
		this.trafficRates.add(1.6);
		
	}
	
	

}
