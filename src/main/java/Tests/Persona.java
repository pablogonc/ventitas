package Tests;

public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    public Persona () {

    }

    public Persona (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;

        PersonaMapper oMapper = new PersonaMapper (this.nombre, this.apellido, this.edad);
        this.id = oMapper.insert();
    }

    public boolean baja() {
        PersonaDAO oPersonaDAO = new PersonaDAO();
        return oPersonaDAO.updateActivo(this.id);
    }

    public boolean bajaTotal() {
        PersonaDAO oPersonaDAO = new PersonaDAO();
        return oPersonaDAO.delete(this.id);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return this.id;
    }
}
