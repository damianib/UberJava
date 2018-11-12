package myUber;

public class MyUber {
	
	public static double rate(Ride ride, double length, String traffic) {
		
		return ride.basicRate(length)*length*ride.trafficRate(traffic);
		
	}
	
	public static void main(String[] args) {
		Standard maVoiture = new Standard(42.42, "voiture42");
		System.out.println(maVoiture.getNbrSeat());
	}

}
