package myUber;

import java.util.ArrayList;
import java.util.Calendar;

public class MyUber {
	
	protected ArrayList bookOfRides = new ArrayList();
	
	
	
	///fonction renvoyant l'�tat du traffic
	public static String getTraffic() {
		
		///on r�cup�re l'heure
		Calendar cal = Calendar.getInstance();
        int heure = cal.get(Calendar.HOUR_OF_DAY);
		
		double plow;
		double pmedium;
		double phigh;
		
		///en fonction de l'heure on attribut les coeff de proba
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
		
		/// on tire un nombre entre 0 et 1 et on annonce le r�sultat
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
		String traffic = getTraffic();
		System.out.println(traffic);
		System.out.println(rate(ride, length, traffic));
	}

}
