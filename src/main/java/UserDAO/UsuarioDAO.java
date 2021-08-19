package UserDAO;

import Tests.Persona;

import java.sql.*;

public class UsuarioDAO {

    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/ventitasSA";

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

    public boolean esValido(String usuario){
        String consulta = "SELECT COUNT(*) AS cantidad FROM usuario WHERE usuario = '" + usuario + "';";
        try {
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            rs.next();  // TODO chequear

            return rs.getInt("cantidad") == 0;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error," + ex);
            return false;
        }

    }

    public int registrarse(String nombre, String contrasenia) {

        String consulta = "INSERT INTO persona (nombre, edad) VALUES ('" + nombre + "'," + contrasenia + ");";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener �ltimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }

}
