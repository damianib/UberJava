package myUber;

import java.util.ArrayList;

public class CustomerFactory {
	
	static int compteurCustomer = 0;
	static ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public static void createDriver(String name, String surname, String creditCard) {
		compteurCustomer ++;
		String str = Integer.toString(compteurCustomer);
		String ID = "Customer" + str;
		Customer customer = new Customer(name, surname, ID, creditCard);
		listOfCustomers.add(customer);
	}	
	
	public ArrayList<Customer> getListOfCustomers() {
		return listOfCustomers;
	}
	public void supprimerCustomer (Customer customer) {
		listOfCustomers.remove(customer);
	}
	public int getNbrOfCustomer () {
		return compteurCustomer;
	}
}