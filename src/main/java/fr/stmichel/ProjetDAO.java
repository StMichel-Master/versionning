package fr.stmichel;

import java.util.List;

import jakarta.persistence.*;

public class ProjetDAO {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	
	public void saveProjet(Projet projet) {
		entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.persist(projet);
            trans.commit();
            System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Projet> getProjets(){
		entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        List<Projet> projets = null;
        try {
        	projets = entityManager.createQuery("from Projet", Projet.class).getResultList();
        }
        catch (Exception e) {
        	//TODO: handle exception
        }
        return projets;
	}
	
	public Projet getProjet(int Id) {
		entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Projet projet = null;
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		try {
			projet = entityManager.find(Projet.class, Id);
			trans.commit();
			System.out.println("OK");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return projet;
	}
	
	public void deleteProjet(Projet projet) {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.remove(projet);
            trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateProjet(Projet projet) {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("java_ee_db");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        try {
        	entityManager.merge(projet);
            trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
