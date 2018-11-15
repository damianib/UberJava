package rides;

public class RideFactory {
	
	public Ride createRide(String rideType, String status) {
		
		if (rideType == "UberBlack") {
			return new UberBlack(status);
		}
		else if (rideType == "UberPool") {
			return new UberPool(status);
		}
		else if (rideType == "UberVan") {
			return new UberVan(status);
		}
		else if (rideType == "UberX") {
			return new UberX(status);
		}
		else {
			return null;
		}
		
	}

}
