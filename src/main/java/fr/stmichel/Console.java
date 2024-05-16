package fr.stmichel;

public class Console {
	/*private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;*/
	static EmployeeDAO employeeDAO = new EmployeeDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee("Jean", "Dupont", "Paris", 2000);
		employeeDAO.saveEmployee(employee);
	}
}
