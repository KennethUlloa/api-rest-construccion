package grupo7.apirest.modelo.recurso;

import grupo7.apirest.modelo.dao.DAOFactory;
import grupo7.apirest.utils.MensajePeticion;
import grupo7.apirest.modelo.entidades.Persona;

import javax.ws.rs.*;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Recurso para la gestión de personas a través de métodos CRUD y HTTP en donde: <br>
 * CREATE -> POST <br>
 * RETRIEVE -> GET <br>
 * UPDATE -> PUT <br>
 * DELETE -> DELETE <br>
 */
@Path("/personas")
public class RecursoPersona {

    /**
     * Este endpoint produce una lista en de todas las personas registradas.
     * No tiene subruta, se asume que si la petición llega por GET sin ningún parámetro, entonces el cliente desea
     * toda la lista de las personas registradas
     *
     * @return Lista de todas las personas registradas
     */

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Persona> list() {
        return DAOFactory.getFactory().getPersonaDAO().getAll();
    }

    /**
     * Este endpoint retorna una persona. Se localiza bajo la ruta /id donde id es el identificador único de
     * la persona que se desea consultar.
     *
     * @param id Identificador de la persona
     * @return Persona
     */

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public Persona getById(@PathParam("id") int id) {
        return DAOFactory.getFactory().getPersonaDAO().getById(id);
    }

    /**
     * Este endpoint realiza la actualización de una persona. Recibe una persona como parámetro, esta persona servirá como
     * el recurso para obtener los valores a actualizar en la persona almacenada. Si alguno de los atributos de la
     * persona que entra como parámetro está vacío (null) se ignora este atributo en la actualización y se continúa con
     * aquellos que tienen contenido. <br/>
     * <b>Respuestas</b><br/>
     * <table>
     *     <tr>
     *         <th>Estatus HTTP</th>
     *         <th>Mensaje</th>
     *     </tr>
     *     <tr>
     *         <td>400</td>
     *         <td>Persona no encontrada, no se puede actualizar</td>
     *     </tr>
     *     <tr>
     *         <td>200</td>
     *         <td>Actualización exitosa</td>
     *     </tr>
     * </table>
     * <b>Formato</b>
     * {"mensaje":"el mensaje de la petición"}
     *
     * @param p Persona con los datos que se intenta actualizar
     * @return Respuesta HTTP con un mensaje del estado de la petición realizada
     */

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response update(Persona p) {

        Persona actual = DAOFactory.getFactory().getPersonaDAO().getById(p.getId());
        if (actual == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new MensajePeticion("Persona no encontrada, no se puede actualizar")).build();
        }
        if (p.getNombres() != null) {
            actual.setNombres(p.getNombres());
        }

        if (p.getApellidos() != null) {
            actual.setApellidos(p.getApellidos());
        }

        if (p.getSexo() != null) {
            actual.setSexo(p.getSexo());
        }

        DAOFactory.getFactory().getPersonaDAO().update(actual);
        return Response.ok().entity(new MensajePeticion("Actualización exitosa")).build();
    }

    /**
     * Este endpoint se encarga de la eliminación de personas del registro. Se pasa el identificador de la persona a
     * eliminar bajo la ruta /{id}, donde id corresponde al identificador.
     * <b>Respuestas</b><br/>
     * <table>
     *     <tr>
     *         <th>Estatus HTTP</th>
     *         <th>Mensaje</th>
     *     </tr>
     *     <tr>
     *         <td>400</td>
     *         <td>No existe la persona con el id {ID}</td>
     *     </tr>
     *     <tr>
     *         <td>200</td>
     *         <td>Eliminación exitosa</td>
     *     </tr>
     * </table>
     * <b>Formato</b>
     * {"mensaje":"el mensaje de la petición"}
     *
     * @param id Identificado único de la persona que se desea eliminar.
     * @return Respuesta HTTP con un mensaje del estado de la petición realizada
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        Persona p = DAOFactory.getFactory().getPersonaDAO().getById(id);
        if (p == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new MensajePeticion("No existe la persona con el id: " + id)).build();
        }

        DAOFactory.getFactory().getPersonaDAO().deleteById(id);
        return Response.ok().entity(new MensajePeticion("Eliminación exitosa")).build();
    }

    /**
     * Este endpoint se encarga de registrar a una persona.
     * <b>Respuestas</b><br/>
     * <table>
     *     <tr>
     *         <th>Estatus HTTP</th>
     *         <th>Mensaje</th>
     *     </tr>
     *     <tr>
     *         <td>400</td>
     *         <td>Ya existe una persona con el id especificado</td>
     *     </tr>
     *     <tr>
     *         <td>200</td>
     *         <td>Persona creada exitosamente</td>
     *     </tr>
     * </table>
     * <b>Formato</b>
     * {"mensaje":"el mensaje de la petición"}
     * @param p Persona que se intenta registrar
     * @return Respuesta HTTP con un mensaje del estado de la petición realizada
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Persona p) {
        if (DAOFactory.getFactory().getPersonaDAO().getById(p.getId()) != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new MensajePeticion("Ya existe una persona con el id especificado")).build();
        }
        DAOFactory.getFactory().getPersonaDAO().create(p);
        return Response.ok().entity(new MensajePeticion("Persona creada exitosamente")).build();
    }
}
