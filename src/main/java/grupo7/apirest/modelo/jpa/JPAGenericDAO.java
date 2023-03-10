package grupo7.apirest.modelo.jpa;

import grupo7.apirest.modelo.dao.GenericDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Implementación genérica del acceso a la base de datos con JPA
 * @param <T> Tipo de la entidad que se va a manejar (anotada como Entidad)
 * @param <ID> Tipo del identificador de la entidad manejada
 */
public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistenceClass;
	protected EntityManager em;

	/**
	 * Constructor genérico
	 * @param type Tipo de la entidad a manejar
	 */
	public JPAGenericDAO(Class<T> type) {
		this.persistenceClass = type;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("api-rest");
		em = emf.createEntityManager();
	}

	/**
	 * Método para el almacenamiento de un objeto.
	 * @param obj Objeto que se desea persistir
	 */
	@Override
	public void create(T obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
				
	}

	/**
	 * Método para la actualización de un objeto.
	 * @param obj Objeto que se desea persistir
	 */
	@Override
	public void update(T obj) {
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	/**
	 * Método para la eliminación de objetos.
	 * @param id Identificador del objeto a eliminar
	 */
	@Override
	public void deleteById(ID id) {
		T obj = getById(id);
		if(obj != null) {
			try {
				em.getTransaction().begin();
				em.remove(obj);
				em.getTransaction().commit();
			} catch (Exception e) {
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			}
			
		}
		
	}

	/**
	 * Método para obtener un único objeto.
	 * @param id Identificador del objeto a consultar.
	 * @return Objeto consultado o null si no se encuentra
	 */
	@Override
	public T getById(ID id) {
		return em.find(persistenceClass, id);
	}

	/**
	 * Método para obtener todos los objetos almacenados que representan una Entidad
	 * @return Lista de objetos
	 */
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
