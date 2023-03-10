package grupo7.apirest.utils;

/**
 * Objeto de representación para enviar mensajes al cliente respecto al estado de una petición
 */
public class MensajePeticion {
    private String mensaje;

    public MensajePeticion(String mensaje) {
        this.mensaje = mensaje;
    }

    public MensajePeticion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
