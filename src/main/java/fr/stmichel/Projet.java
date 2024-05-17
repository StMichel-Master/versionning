package fr.stmichel;

import jakarta.persistence.*;

@Entity
@Table(name = "projet")
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom",length = 25)
	private String nom;
	@Column(name = "description",length = 255)
	private String description;
	@Column(name = "budget")
	private int budget;
	@OneToOne
	@JoinColumn(name = "employeId", nullable = false)
	private Employee employe;
	public Projet(String nom, String description, int budget, Employee employe) {
		super();
		this.nom = nom;
		this.description = description;
		this.budget = budget;
		this.employe = employe;
	}
	public Projet() {
		super();
		this.nom = "";
		this.description = "";
		this.budget = 0;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public Employee getEmploye() {
		return employe;
	}
	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	public int getId() {
		return id;
	}
}
