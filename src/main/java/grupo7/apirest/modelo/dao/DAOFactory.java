package grupo7.apirest.modelo.dao;


import grupo7.apirest.modelo.jpa.JPADAOFactory;

/**
 * Factoría para los manejadores de las entidades
 */
public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();

	/**
	 * Obtención de la instancia de la factoría
	 * @return Factoría
	 */
	public static DAOFactory getFactory() {
		return factory;
	}
	public abstract PersonaDAO getPersonaDAO();
	
}