package myUber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class MyUber {
	
	protected ArrayList bookOfRides = new ArrayList();
	protected static int NombreDeClients = 0;
	File ListeDesClients = new File("C://Users/matth/Desktop/rgergeg/UberJava/Liste des Clients.txt");
	
	
	
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


	
	/// G pa kompri
	public static double rate(Ride ride, double length, String traffic) {
		return ride.basicRate(length)*length*ride.trafficRate(traffic);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer Client = recupererOuCreerClient(sc);
		GPS Depart = GPSDepart(sc);
		GPS Destination = GPSArrivee(sc);
		double distance = GPS.distance (Depart, Destination);
		String traffic = getTraffic();
		String TypeDeTrajet = demanderTrajet(distance, traffic, sc);
		int nbrPlaceVoulues = demanderNbrPlaces(TypeDeTrajet, sc);
		
		
		
		
		
	}	
	
	public static Customer recupererOuCreerClient(Scanner sc) {
		
		System.out.println("quel est votre identifiant client ?");
		String idDuClientSTR =sc.nextLine();
		int idDuClient = Integer.parseInt(idDuClientSTR);
		
		if ( idDuClient > NombreDeClients) {
			System.out.println("vous etes un nouveau client ! Nous allons ensemble vous cr�er un compte");
			System.out.println("entrez votre nom :");
			String NewName = sc.nextLine();
			System.out.println("entrez votre surnom :");
			String NewSurname = sc.nextLine();
			System.out.println("entrez votre carte de cr�dit. Elle ne sera jamais d�bit�e sans avoir votre confirmation :");
			String NewCard = sc.nextLine();
			System.out.println("Votre profil est maintenant cr�� ! Vous disposez �galement d'une MailBox o� vous recevrez tous nos messages !");
			
			int NewID = ( NombreDeClients + 1);
			NombreDeClients++;
			ArrayList<Double> NewGps = new ArrayList<Double>();
			NewGps.add(0.);
			NewGps.add(0.);
			
			
			return ( new Customer (NewName, NewSurname, NewID, NewGps, NewCard) );
			
		} else {
			/// ici il faut faire une fonction qui r�cup�re l'objet client existant � partir de son id, je sais pas faire
			ArrayList<Double> NewGps = new ArrayList<Double>();
			NewGps.add(0.);
			NewGps.add(0.);
			return ( new Customer ("Pillot", "Wolpertinger", 424242, NewGps, "5875698451") );
		}
	}

	public static GPS GPSDepart(Scanner sc) {
		System.out.println("o� �tes vous ? Rentrez vos coordonn�es GPS");
		System.out.println("en commen�ant par x");
		String X = sc.nextLine();
		double newX = Double.parseDouble(X);
		System.out.println("puis maintenant y");
		String Y = sc.nextLine();
		double newY = Double.parseDouble(Y);
		return new GPS(newX, newY);
	}
	
	public static GPS GPSArrivee(Scanner sc) {
		System.out.println("o� voulez vous aller ? Rentrez les coordonn�es GPS");
		System.out.println("en commen�ant par x");
		String DX = sc.nextLine();
		double DestX = Double.parseDouble(DX);
		System.out.println("puis maintenant y");
		String DY = sc.nextLine();
		double DestY = Double.parseDouble(DY);
		return new GPS(DestX, DestY);
	}

	public static String demanderTrajet(double distance, String traffic, Scanner sc) {
		
		/// il faut r�cuperer les quatre prix disponible en fonction du type de trajet, pour cela il faut utiliser la fonction rate que j'ai pas comprise ^^
		double prixBlack = 42.;
		double prixPool = 42.;
		double prixVan = 42.;
		double prixX = 42.;
		/// les prix doivent �tre chang�s
				
		System.out.println("Pour votre trajet, en fonction des conditions actuelles de circulation, les tarifs sont les suivants");
		System.out.println("UberBlack : " + prixBlack + " euros");
		System.out.println("UberPool : " + prixPool + " euros");
		System.out.println("UberVan : " + prixVan + " euros");
		System.out.println("UberX : " + prixX + " euros");
		System.out.println("Inscrivez le nom du transport choisi, ou tappez 'info' pour avoir les d�tails sur les diff�rents rides disponibles");
		String TypeDemande = sc.nextLine();
		if (TypeDemande == "info") {
			System.out.println("inserer ici un pav� de description des ride");
			return demanderTrajet(distance, traffic, sc);
		} else {
			return TypeDemande;
		}
				
	}
	
	public static Integer demanderNbrPlaces(String trajet, Scanner sc) {
		int max = 4;
		if (trajet == "UberVan") {
			max = 6;
		}
		int nbr =42;
		while (!(nbr <= max && nbr > 0)) {
			System.out.println("pour ce trajet, le nombre de place maximal est " + max + ", combien en voulez vous ?");
			String nbrSTR = sc.nextLine();
			nbr = Integer.parseInt(nbrSTR);
		}
		return (nbr);
	}
	
	
	
	
	
	
	
}
