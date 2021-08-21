package userDAO;

import Tests.Persona;
import model.user.Administrador;
import model.user.Normal;
import model.user.Usuario;
import sesion.Sesion;

import java.sql.*;

public class UsuarioDAO {

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

    public int registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion) {

        String consulta = "insert into usuario values (null,'" + nombre + "','" + contrasenia + "','" + direccion + "'," + telefono +",'" + mail +"','" + metodoNotificacion +"',false);" ;

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

    public Usuario iniciarSesion(Sesion sesion, String nombre, String contrasenia) {
        String consulta = "select * from usuario  where usuario='"+nombre+"' and contrasenia = '" + contrasenia + "';" ;

        try {
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            rs.next();  // TODO chequear
            Usuario usuario;


            if(rs.getBoolean("esAdmin")){
                usuario= new Administrador(sesion,
                        rs.getInt("idUsuario"),
                        nombre,
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("mail"),
                        rs.getString("notificacion"));
            }else{
                usuario = new Normal(sesion,
                        rs.getInt("idUsuario"),
                        nombre,
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("mail"),
                        rs.getString("notificacion")
                );
            }

            return usuario;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error," + ex);
            return null;
        }

    }

    public void elimininar(int id) {
        String consulta = "DELETE FROM usuario WHERE idUsuario = " + id + ";";

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
