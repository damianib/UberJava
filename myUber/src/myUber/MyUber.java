package myUber;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

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

	///fonction calculant une distance
	public static Double getDistance(ArrayList<Double> gps1, ArrayList<Double> gps2) {
		double x = gps1.get(0) - gps2.get(0);
		double y = gps1.get(1) - gps2.get(1);
		return (Math.sqrt(x*x + y*y));
	}
	
	/// G pa kompri
	public static double rate(Ride ride, double length, String traffic) {
		return ride.basicRate(length)*length*ride.trafficRate(traffic);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("quel est votre identifiant client ?");
		String idDuClientSTR =sc.nextLine();
		int idDuClient = Integer.parseInt(idDuClientSTR);
		
		if ( idDuClient > NombreDeClients) {
			System.out.println("vous etes un nouveau client ! Nous allons ensemble vous créer un compte");
			System.out.println("entrez votre nom :");
			String NewName = sc.nextLine();
			System.out.println("entrez votre surnom :");
			String NewSurname = sc.nextLine();
			System.out.println("entrez votre carte de crédit. Elle ne sera jamais débitée sans avoir votre confirmation :");
			String NewCard = sc.nextLine();
			System.out.println("Votre profil est maintenant créé ! Vous disposez également d'une MailBox où vous recevrez tous nos messages !");
			
			int NewID = ( NombreDeClients + 1);
			NombreDeClients++;
			ArrayList<Double> NewGps = new ArrayList<Double>();
			NewGps.add(0.);
			NewGps.add(0.);
			
			
			Customer s = new Customer (NewName, NewSurname, NewID, NewGps, NewCard);
			
		}
		

}
