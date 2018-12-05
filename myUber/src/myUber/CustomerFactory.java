package myUber;

import java.util.ArrayList;

public class CustomerFactory {
	
	static int compteurCustomer = 0;
	static ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
	
	/** Permet de creer un nouveau customer ajoute directement a listOfCustomers*/
	public static void createCustomer(String name, String surname, String creditCard, GPS gps) {
		compteurCustomer ++;
		String str = Integer.toString(compteurCustomer);
		String ID = "Customer" + str;
		Customer customer = new Customer(name, surname, ID, creditCard, gps);
		listOfCustomers.add(customer);
	}	
	
	public static ArrayList<Customer> getListOfCustomers() {
		return listOfCustomers;
	}
	public void supprimerCustomer (Customer customer) {
		listOfCustomers.remove(customer);
	}
	public int getNbrOfCustomer () {
		return compteurCustomer;
	}
}