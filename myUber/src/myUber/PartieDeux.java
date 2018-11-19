package myUber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import car.Car;
import car.CarFactory;
import rides.Ride;
import rides.RideFactory;

public class PartieDeux {
	
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
			
			
			return ( new Customer (NewName, NewSurname, NewID, NewGps, NewCard) );
			
		} else {
			/// ici il faut faire une fonction qui récupère l'objet client existant à partir de son id, je sais pas faire
			ArrayList<Double> NewGps = new ArrayList<Double>();
			NewGps.add(0.);
			NewGps.add(0.);
			return ( new Customer ("Pillot", "Wolpertinger", 424242, NewGps, "5875698451") );
		}
	}

	public static GPS GPSDepart(Scanner sc) {
		System.out.println("où êtes vous ? Rentrez vos coordonnées GPS");
		System.out.println("en commençant par x");
		String X = sc.nextLine();
		double newX = Double.parseDouble(X);
		System.out.println("puis maintenant y");
		String Y = sc.nextLine();
		double newY = Double.parseDouble(Y);
		return new GPS(newX, newY);
	}
	
	public static GPS GPSArrivee(Scanner sc) {
		System.out.println("où voulez vous aller ? Rentrez les coordonnées GPS");
		System.out.println("en commençant par x");
		String DX = sc.nextLine();
		double DestX = Double.parseDouble(DX);
		System.out.println("puis maintenant y");
		String DY = sc.nextLine();
		double DestY = Double.parseDouble(DY);
		return new GPS(DestX, DestY);
	}

	public static String demanderTrajet(double distance, String traffic, Scanner sc) {
		
		/// il faut récuperer les quatre prix disponible en fonction du type de trajet, pour cela il faut utiliser la fonction rate que j'ai pas comprise ^^
		double prixBlack = 42.;
		double prixPool = 42.;
		double prixVan = 42.;
		double prixX = 42.;
		/// les prix doivent être changés
				
		System.out.println("Pour votre trajet, en fonction des conditions actuelles de circulation, les tarifs sont les suivants");
		System.out.println("UberBlack : " + prixBlack + " euros");
		System.out.println("UberPool : " + prixPool + " euros");
		System.out.println("UberVan : " + prixVan + " euros");
		System.out.println("UberX : " + prixX + " euros");
		System.out.println("Inscrivez le nom du transport choisi, ou tappez 'info' pour avoir les détails sur les différents rides disponibles");
		String TypeDemande = sc.nextLine();
		if (TypeDemande == "info") {
			System.out.println("inserer ici un pavé de description des ride");
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
	
	///fonction pour commander un ride
	public void commande(Customer customer, String rideType, GPS depart, GPS arrivee) {
		ArrayList<Car> listOfCars = CarFactory.getListOfCars();
		Ride ride = RideFactory.createRide(customer, rideType, depart, arrivee);
		Car car = trouverVoiture(ride.getCarType(), depart, listOfCars);
		Driver driver = trouverConducteur(car);
		
		faireUnRide(ride, car, driver);
			
		}
	
	
	//renvoie la liste des prix des rides en fonction du trajet
		public static void genPrice(GPS depart, GPS arrivee) {
			
			ArrayList<String> rideTypes = RideFactory.getRideTypes();
			for (Iterator iterator = rideTypes.iterator(); iterator.hasNext();) {
				String rideType = (String) iterator.next();
				Ride currentRide = RideFactory.createRide(rideType, depart, arrivee);
				double currentPrice = currentRide.rate(getTraffic());
				System.out.println("Type de ride : "+rideType);
				System.out.println("Prix : "+currentPrice);
			}
			
		}

}
