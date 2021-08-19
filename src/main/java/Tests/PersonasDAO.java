package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonasDAO {

    private List<Persona> personas;
    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/utndds";
            conn = DriverManager.getConnection(connectionUrl, "root", "");

            // Do something with the Connection
            //System.out.println("Conexi�n realizada");

            return conn;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public List<Persona> selectActivas() {

        try {

            // generacion de query
            String consulta = "SELECT * FROM persona WHERE activo = 1";

            // Conexi�n
            this.conn = newConnection();

            // Ejecuci�n
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada l�nea retornada
            List<Persona> personas = new ArrayList<>();

            while (rs.next()) {
                Persona obj = new Persona();

                // get nombre y apellido
                String str = rs.getString("nombre");
                String[] newStr = str.split("\\s+");
                obj.setNombre(newStr[0]);
                obj.setApellido(newStr[1]);

                // get edad
                obj.setEdad(rs.getInt("edad"));

                personas.add(obj);
            }

            return personas;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

}

