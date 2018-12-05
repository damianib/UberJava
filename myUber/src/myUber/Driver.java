package myUber;

import java.util.ArrayList;

import car.Car;

public class Driver {
	
	protected String name;
	protected String surname;
	protected String id;
	protected String state = "off-duty";
	protected double evaluation = 0.;
	protected int nbEvaluations = 0;
	protected ArrayList<Car> cars = new ArrayList<Car>();
	
	
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public void addCar(Car car) {
		this.cars.add(car);
	}
	public int getNbEvaluations() {
		return nbEvaluations;
	}
	public void setNbEvaluations(int nbEvaluations) {
		this.nbEvaluations = nbEvaluations;
	}
	
	public double getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
	}
	
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
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	/** Ajoute une evaluation au driver en prenant en compte les precedentes */
	public void ajouterEval(int stars) {
		this.evaluation = (this.nbEvaluations*this.evaluation+stars)/(this.nbEvaluations+1);
		this.nbEvaluations ++;
	}
	
	public Driver(String name, String surname, String id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	
}
