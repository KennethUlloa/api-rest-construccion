package grupo7.apirest.utils;

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
