
package validouser;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    public Connection conexion;
    private String url = "jdbc:mysql://localhost:3306/redsocial"; // Solo hay que cambiar el nombre a tu base de datos.
    private String user = "root";
    private String key = "";

    public Connection getConectarSql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.key);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return conexion;
    }
}
