package DAOS.orden;

import model.item.Producto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public int registrarOrden(Integer idUsuario, Integer idSucursal, float precioEnvio, LocalDateTime fechaPedido, List<Producto> articulos) {

        String consulta = "insert into orden values (null,"+idUsuario  +"," + idSucursal + "," + precioEnvio + ",'" + fechaPedido + "',false);" ;



        try {

            this.conn = newConnection();

            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            // obtener ultimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int id;
            if (generatedKeys.next()) {
                 id = generatedKeys.getInt(1);
            }else {
                return 0;
            }

            List<Producto> temps = new ArrayList<>(
                    new HashSet<>(articulos));

                for (Producto articulo : temps) {
                    consulta = "insert into articuloXorden values (null,"+ id +","+articulo.getId() +");";
                    stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                    stmt.executeUpdate();
            }
            return id;
        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }

    public void eliminar(Integer id) {
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

