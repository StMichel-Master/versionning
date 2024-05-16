package fr.stmichel;

import java.util.List;

import jakarta.persistence.*;

public class EmployeeDAO {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;

	/**
	 * 
	 * @param employe
	 */
	public void saveEmployee(Employee employe) {

        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.persist(employe);
            trans.commit();
            System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	/**
	 * 
	 * @return
	 */
	public List <Employee> getEmployees() {
        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        List<Employee> employees = null;
        try {
        	employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        }
        catch (Exception e) {
        	//TODO: handle exception
        }
        return employees;
    }
	
	public Employee getEmployee(int Id) {
		entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employe = null;
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		try {
			employe = entityManager.find(Employee.class, Id);
			trans.commit();
			System.out.println("OK");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return employe;
	}
	
	/**
     * 
     * @param employe
     */
    public void deleteEmployee(Employee employe) {
    	EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.remove(employe);
            trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    /**
     * 
     * @param employe
     */
    public void updateEmployee(Employee employe) {
    	EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.merge(employe);
            trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
