package grupo7.apirest.modelo.jpa;

import grupo7.apirest.modelo.dao.DAOFactory;
import grupo7.apirest.modelo.dao.PersonaDAO;

/**
 * Punto de entrada para el acceso a la base de datos usando JPA
 */
public class JPADAOFactory extends DAOFactory {
	/**
	 * Obtención de acceso hacia manejador de personas con JPA
	 * @return
	 */
	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

}
