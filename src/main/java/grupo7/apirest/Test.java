package grupo7.apirest;

import grupo7.apirest.modelo.dao.DAOFactory;
import grupo7.apirest.modelo.entidades.Persona;

public class Test {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombres("Kenneth Leonardo");
        persona.setApellidos("Ulloa Tobar");
        persona.setSexo("M");
        DAOFactory.getFactory().getPersonaDAO().create(persona);
    }
}
