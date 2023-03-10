package grupo7.apirest.modelo.dao;


import grupo7.apirest.modelo.jpa.JPADAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();
	public static DAOFactory getFactory() {
		return factory;
	}
	public abstract PersonaDAO getPersonaDAO();
	
}