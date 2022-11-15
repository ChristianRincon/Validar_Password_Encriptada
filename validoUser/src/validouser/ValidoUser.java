
package validouser;

import java.sql.*;
import java.util.Scanner;

public class ValidoUser {
  
    public static void main(String[] args) {
        
        conexion conn = new conexion();
        Connection con = conn.getConectarSql();   
        Scanner input = new Scanner(System.in);
        
        try{
            System.out.print("Ingrese su mail: "); // Solicito email
            String mail = input.nextLine();
        
            System.out.print("Ingrese su clave: "); // Solicito clave
            String clave = input.nextLine();
            
            String query = "SELECT * FROM persona p WHERE p.CorreoElectronico ='" + mail + "' " ;
            Statement st = conn.conexion.createStatement();
            ResultSet rs = st.executeQuery(query); // Ejecuto la query   
            
	    // Comenzamos a evaluar
            while(rs.next()){
                // Comparo lo ingresado en el input de Java con lo que encripté con PHP y tengo alojado en phpMyAdmin
                boolean check = BCrypt.checkpw(clave, rs.getString("Password"));
                if(check){
                    System.out.println("Bienvenido/a " + rs.getString("Nombre") + " " + rs.getString("Apellido"));
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }         
            conn.conexion.close();
            
        }catch (Exception e) {
            System.out.println("Error " + e);
        }        
    }
}
