package grupo7.apirest.modelo.jpa;


import grupo7.apirest.modelo.dao.PersonaDAO;
import grupo7.apirest.modelo.entidades.Persona;

import javax.persistence.TypedQuery;
import java.util.List;

public class JPAPersonaDAO extends modelo.jpa.JPAGenericDAO<Persona, Integer> implements PersonaDAO {
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
