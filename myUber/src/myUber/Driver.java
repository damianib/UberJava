package myUber;

public class Driver {
	
	protected String name;
	protected String surname;
	protected int id;
	protected String state;
	protected double evaluation;
	protected int nbEvaluations;
	
	
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
	
	public void ajouterEval(int stars) {
		this.evaluation = (this.nbEvaluations*this.evaluation+stars)/(this.nbEvaluations+1);
		this.nbEvaluations ++;
	}
	
	public Driver(String name, String surname, int id, String state) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.state = state;
	}
	
}