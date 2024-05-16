package fr.stmichel;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "salaire")
	private int salaire;
	
	public Employee() {
		super();
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.salaire = 0;
	}
	public Employee(String nom, String prenom, String adresse, int salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.salaire = salaire;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	@Override
	public String toString() {
		return "Employee [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", salaire=" + salaire + "]";
	}
}
