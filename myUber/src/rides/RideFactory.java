package rides;

import java.util.ArrayList;

import myUber.GPS;

public class RideFactory {
	
	public static ArrayList<String> getRideTypes(){
		
		ArrayList<String> rideTypes = new ArrayList<String>();
		rideTypes.add("UberBlack");
		rideTypes.add("UberPool");
		rideTypes.add("UberVan");
		rideTypes.add("UberX");
		return rideTypes;
		
	}
	
	public static Ride createRide(String rideType, String status, GPS depart, GPS arrivee) {
		
		if (rideType == "UberBlack") {
			return new UberBlack(status, depart, arrivee);
		}
		else if (rideType == "UberPool") {
			return new UberPool(status, depart, arrivee);
		}
		else if (rideType == "UberVan") {
			return new UberVan(status, depart, arrivee);
		}
		else if (rideType == "UberX") {
			return new UberX(status, depart, arrivee);
		}
		else {
			return null;
		}
		
	}

}
