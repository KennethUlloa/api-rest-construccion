package grupo7.apirest.modelo.jpa;

import grupo7.apirest.modelo.dao.DAOFactory;
import grupo7.apirest.modelo.dao.PersonaDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return new JPAPersonaDAO();
	}

}
