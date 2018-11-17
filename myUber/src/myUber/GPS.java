package myUber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

public class GPS {
	
	private double X;
	private double Y;
	
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	
	public GPS(double x, double y) {
		super();
		X = x;
		Y = y;
	}
	
	//renvoie la distance entre deux points
	public static double distance(GPS a, GPS b) {
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		return (Math.sqrt(dx*dx + dy*dy));
	}
	
	//renvoie un GPS random
	public static GPS randGPS(double maxX, double maxY) {
		return new GPS(Math.random()*maxX, Math.random()*maxY);
	}
	
	//renvoie le trajet optimal pour un uberPool
	public static ArrayList<GPS> trajetPool(ArrayList<GPS> pickup, ArrayList<GPS> dropout, GPS position){
		
		ArrayList<GPS> trajet = new ArrayList<GPS>();
		ArrayList<GPS> next = new ArrayList<GPS>();
		ArrayList<Integer> etatClient = new ArrayList<Integer>();
		for (int i = 0; i < pickup.size(); i++) {
			etatClient.add(0);
		}
		
		next.addAll(pickup);
		double distanceMin = 100000000.;
		int indexMin = 0;
		GPS currentPos = position;
		
		while (!next.isEmpty()) {
			
			//Recherche de la distance minimale
			for (int i = 0; i < next.size(); i++) {
				double currentDistance = GPS.distance(currentPos, next.get(i));
				if (currentDistance < distanceMin) {
					distanceMin = currentDistance;
					indexMin = i;
				}
			}
			
			trajet.add(next.get(indexMin));
			currentPos = next.get(indexMin);
			
			if (etatClient.get(indexMin)==0) {
				next.set(indexMin, dropout.get(indexMin));
				etatClient.set(indexMin, 1);
			}
			else {
				next.remove(indexMin);
			}
			
			distanceMin = 100000000.;

		}
		
		return trajet;
		
	}
	
	@Override
	public String toString() {
		return "(" + X + "," + Y + ")";
	}

}
