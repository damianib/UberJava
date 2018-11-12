package myUber;

import java.util.ArrayList;

public class myUber {
	
	protected ArrayList<String> bookOfRides;
	
	public String getTraffic(int heure) {
		
		return "low";
	}
	
	public double rideCost(Ride ride, double length, String traffic) {
		
		return 1.2;
	}
	
	public static void main(String[] args) {
		
	}

}
