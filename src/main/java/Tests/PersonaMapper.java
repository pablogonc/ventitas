package Tests;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper {

    private String nombre;
    private String apellido;
    private int edad;

    public PersonaMapper(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int insert() {
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.insert(this.nombre + ' ' + this.apellido, this.edad);
    }
}
