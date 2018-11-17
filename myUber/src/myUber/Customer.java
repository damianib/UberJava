package myUber;

import java.util.ArrayList;

public class Customer {
	
	protected String name;
	protected String surname;
	protected String id;
	protected GPS gps;
	protected String creditCard;
	ArrayList<String> MailBox = new ArrayList<String>();
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GPS getGps() {
		return gps;
	}
	public void setGps(GPS gps) {
		this.gps = gps;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public void sendMessage(String message) {
		this.MailBox.add(message);
	}
	
	public Customer(String name, String surname, String id, String creditCard, GPS gps) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.creditCard = creditCard;
		this.gps = gps;
	}

}
