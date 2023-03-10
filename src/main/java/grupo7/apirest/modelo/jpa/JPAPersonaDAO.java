package grupo7.apirest.modelo.jpa;


import grupo7.apirest.modelo.dao.PersonaDAO;
import grupo7.apirest.modelo.entidades.Persona;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Especificación del manejador para la persona usando JPA
 */
public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {
	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public List<Persona> getAll() {
		String JQL = "SELECT p FROM Persona p";
		TypedQuery<Persona> query = em.createQuery(JQL, Persona.class);
		return query.getResultList();
	}

}
