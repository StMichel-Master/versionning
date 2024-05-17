package fr.stmichel;

//import java.util.*;

//import jakarta.persistence.*;

public class Console {

	static ProjetDAO projetDAO = new ProjetDAO();
	static EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public static void main(String[] args) {
		Employee employee = new Employee("Nathan","Baillargea","Annecy", 2000);
		Projet projet = new Projet("Projet 1","Description projet 1", 1000, employee);
		employeeDAO.saveEmployee(employee);
		projetDAO.saveProjet(projet);
	}
}