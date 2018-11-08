package myUber;

public class Driver {
	
	public String name;
	public String surname;
	public int id;
	public String state;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Driver(String name, String surname, int id, String state) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.state = state;
	}
	
	

}
