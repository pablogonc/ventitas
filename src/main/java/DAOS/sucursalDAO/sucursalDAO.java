package DAOS.sucursalDAO;

import apis.locationService.LocationService;
import model.item.Producto;
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

    public void setStock(Sucursal sucursal){
        String consulta = "select * from articuloXsucursal where idSucursal =" +sucursal.getId() +";" ; //todo

        try {
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while(rs.next()){
                int id = rs.getInt("idArticulo");
                Producto articulo = sucursal.articulos.stream().filter(art ->  art.getId()==id).findFirst().orElse(null);
                sucursal.getEventos().agregarOperacion(articulo.getNombre());
                sucursal.getStock().put(articulo,rs.getInt("stock"));
            }


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error," + ex);

        }
    }

    public void setEncargados(Sucursal sucursal){
        String consulta = "select * from encargado E, usuario U where E.idUsuario= U.idUsuario and idSucursal =" +sucursal.getId() +";" ; //todo

        try {
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while(rs.next()){
                Sesion sesion = new Sesion(sucursal);
                sesion.getUsuario().iniciarSesion(rs.getString("nombreUsuario"),rs.getString("contrasenia")); //todo cambiar por un instanciador que no inicie la sesion
                sucursal.agregarEncaragado(rs.getString("encargo"),(Administrador)  sesion.getUsuario());
            }


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error," + ex);

        }
    }

    public void updateStock(int idsucursal,int idart,int stock) {
        String consulta = " update articuloXsucursal set stock= "+ stock +" where idSucursal =" + idsucursal + " and idArticulo="+ idart + ";" ;

        try {
            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en update:" + ex);

        }

    }

    public void insertStock(int idsucursal,int idart,int stock) {
        String consulta = " insert into articuloXsucursal values (null,"+idsucursal +","+ idart +"," + stock +");";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
        }

    }

    public void insertEncargado(int idsucursal,int iduser,String encargo) {
        String consulta = " insert into encargado values (null,"+idsucursal +","+ iduser +",'" + encargo +"');";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
        }

    }

    public void deleteEncargado(int idsucursal,int iduser,String encargo) {
        String consulta = "delete * from encargado where idSucursal ="+idsucursal  +"and idUsuario="+iduser + " and encargo='"+encargo + "';";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.execute();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en delete");
        }

    }

}
