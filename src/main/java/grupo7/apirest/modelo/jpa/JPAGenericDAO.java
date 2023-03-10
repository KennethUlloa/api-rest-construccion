package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistenceClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> type) {
		this.persistenceClass = type;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("api-rest");
		em = emf.createEntityManager();
	}

	@Override
	public void create(T obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Fallo en create");
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
				
	}

	@Override
	public void update(T obj) {
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Fallo en create");
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteById(ID id) {
		T obj = getById(id);
		if(obj != null) {
			try {
				em.getTransaction().begin();
				em.remove(obj);
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Error en Delete JPA");
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			}
			
		}
		
	}

	@Override
	public T getById(ID id) {
		return em.find(persistenceClass, id);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
