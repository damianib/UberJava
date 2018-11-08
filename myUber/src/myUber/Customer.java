package myUber;

import java.util.ArrayList;

public class Customer {
	
	protected String name;
	protected String surname;
	protected int id;
	protected ArrayList<Double> gps;
	protected String creditCard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Double> getGps() {
		return gps;
	}
	public void setGps(ArrayList<Double> gps) {
		this.gps = gps;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public Customer(String name, String surname, int id, ArrayList<Double> gps, String creditCard) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.gps = gps;
		this.creditCard = creditCard;
	}

}
