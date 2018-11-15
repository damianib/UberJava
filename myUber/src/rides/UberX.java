package rides;

public class UberX extends Ride {

	public UberX(String status) {
		super(status);
		
		this.basicRates.add(3.3);
		this.basicRates.add(4.2);
		this.basicRates.add(1.91);
		this.basicRates.add(1.5);
		
		this.trafficRates.add(1.);
		this.trafficRates.add(1.1);
		this.trafficRates.add(1.5);
	}
	
	

}
