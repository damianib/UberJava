package rides;

import java.util.ArrayList;

import myUber.Customer;
import myUber.GPS;

public class RideFactory {
	
	static ArrayList<Ride> rideEnCours = new ArrayList<Ride>();
	static ArrayList<Ride> rideFinies = new ArrayList<Ride>();
	protected static ArrayList<Ride> poolRequests = new ArrayList<Ride>();
	
	public static ArrayList<Ride> getPoolRequests(){
		return poolRequests;
	}
	
	//renvoie la liste de tous les types de ride dispo
	public static ArrayList<String> getRideTypes(){
		
		ArrayList<String> rideTypes = new ArrayList<String>();
		rideTypes.add("UberBlack");
		rideTypes.add("UberPool");
		rideTypes.add("UberVan");
		rideTypes.add("UberX");
		return rideTypes;
		
	}
	
	//cree le ride voulu (design factory)
	public static Ride createRide(Customer customer, String rideType, GPS depart, GPS arrivee) {
		if (rideType == "UberBlack") {
			return new UberBlack(customer, depart, arrivee);
		}
		else if (rideType == "UberPool") {
			Ride Pool = new UberPool(customer, depart, arrivee);
			poolRequests.add(Pool);
			return Pool;
		}
		else if (rideType == "UberVan") {
			return new UberVan(customer, depart, arrivee);
		}
		else if (rideType == "UberX") {
			return new UberX(customer, depart, arrivee);
		}
		else {
			return null;
		}
		
	}

	public static Ride recupererRide(Customer customer) {
		for (Ride ride : rideEnCours) {
			if (ride.getCustomer()== customer) {
				return ride;
			}
		}
		return null;
	}
	
	public static ArrayList<Ride> getRideEnCours() {
		return rideEnCours;
	}

	public void setRideEnCours(ArrayList<Ride> rideEnCours) {
		this.rideEnCours = rideEnCours;
	}

	public static ArrayList<Ride> getRideFinies() {
		return rideFinies;
	}

	public void setRideFinies(ArrayList<Ride> rideFinies) {
		this.rideFinies = rideFinies;
	}
	
	
	
	
}
