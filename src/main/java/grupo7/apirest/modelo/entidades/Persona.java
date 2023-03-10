package grupo7.apirest.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representación de una persona
 */
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombres;
    @Column
    private String apellidos;
    @Column
    private String sexo;

    public Persona(int id, String nombres, String apellidos, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nombres, persona.nombres) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(sexo, persona.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombres, apellidos, sexo);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
