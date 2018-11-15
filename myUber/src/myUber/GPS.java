package myUber;

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
	
	public static double distance(GPS a, GPS b) {
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		return (Math.sqrt(dx*dx + dy*dy));
	}

}
