package myUber;

import java.util.ArrayList;

public class MyUber {
	
	protected ArrayList bookOfRides = new ArrayList();
	
	
	/// juste pour faire le test
	
	public static String getTraffic(int heure) {
		
		double plow;
		double pmedium;
		double phigh;
		
		if (heure>22 || heure<7) {
			plow = 0.95;
			pmedium = 0.04;
			phigh = 0.01;
		}
		else if (heure < 11) {
			plow = 0.05;
			pmedium = 0.2;
			phigh = 0.75;
		}
		else if (heure < 17) {
			plow = 0.15;
			pmedium = 0.7;
			phigh = 0.15;
		}
		else {
			plow = 0.01;
			pmedium = 0.04;
			phigh = 0.95;
		}
		
		double tirage = Math.random();
		
		if (tirage < plow) {
			return "low";
		}
		else if (tirage < plow + pmedium) {
			return "medium";
		}
		else {
			return "high";
		}
		
	}
	
	public static double rate(Ride ride, double length, String traffic) {
		
		return ride.basicRate(length)*length*ride.trafficRate(traffic);
		
	}
	
	public static void main(String[] args) {
		Standard maVoiture = new Standard(42.42, "voiture42");
		System.out.println(maVoiture.getNbrSeat());
		
		UberX ride = new UberX("status");
		double length = 15;
		int heure = 12;
		String traffic = getTraffic(heure);
		System.out.println(traffic);
		System.out.println(rate(ride, length, traffic));
	}

}
