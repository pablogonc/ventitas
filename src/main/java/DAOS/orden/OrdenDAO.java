package DAOS.orden;

import java.sql.*;

public class OrdenDAO {
    private Connection conn;

    public Connection newConnection() {
        Connection conn ;
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

    public int registrarOrden(Integer idUsuario,Integer idSucursal, float precioEnvio, Date fechaPedido, Boolean confirmado) {

        String consulta = "insert into orden values (null,"+idSucursal  +",'" + idUsuario + "','" + precioEnvio + "','" + fechaPedido + "','" + confirmado + ";" ;

        try {

            this.conn = newConnection();

            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            // obtener ultimo id generado
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

    public void elimininar(Integer id) {
        String consulta = "DELETE FROM orden WHERE idOrden = '" + id + "';";

        try {
            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.execute();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete:" + ex);

        }
    }
}

