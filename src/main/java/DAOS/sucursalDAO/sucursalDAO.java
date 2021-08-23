package DAOS.sucursalDAO;

import apis.locationService.LocationService;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import model.user.Administrador;
import model.user.Normal;
import model.user.Usuario;
import sesion.Sesion;

import java.sql.*;

public class sucursalDAO {
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

    public int registrarSucursal(Ubicacion ubicacion, int telefono){
        String consulta = "insert into sucursal values (null,'"  + ubicacion.getDireccion() + "'," + telefono + ");";

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

    public Sucursal obtenerSucursal(String direccion) {
        String consulta = "select * from sucursal where direccion ='" + LocationService.getUbicacion(direccion).getDireccion() + "';" ;

        try {
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            rs.next();  // TODO chequear
            Sucursal sucursal;

            sucursal = new Sucursal(rs.getInt("idSucursal"),
                    LocationService.getUbicacion(rs.getString("direccion")),
                    rs.getInt("telefono")
                    );

            return sucursal;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error," + ex);
            return null;
        }

    }

}
