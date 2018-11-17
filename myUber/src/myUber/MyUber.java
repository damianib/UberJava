package myUber;


import java.util.ArrayList;
import java.util.Calendar;


import rides.Ride;


public class MyUber {
	
	protected ArrayList bookOfRides = new ArrayList();
	protected static int NombreDeClients = 0;
	
	
	
	
	///fonction renvoyant l'état du traffic
	public static String getTraffic() {
		
		///on récupère l'heure
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
		
		/// on tire un nombre entre 0 et 1 et on annonce le résultat
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
	
}
