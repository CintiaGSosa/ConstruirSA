/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construirsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raven
 */
public class ConstruirSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //carga de Drivers
            Class.forName("org.mariadb.jdbc.Driver");
            
            // conexion a la base de datos
            
           Connection conexion=DriverManager.getConnection("jdbc:mariadb://localhost:3306/construirsa", "root", "");
           
           
           //----------------------------------------------------
          /* //j) Insertar 3 empleados.
           
           String sql="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) VALUES (28456120,'Aurelio','Marcos',3,1),(14956023,'Magno','Alejandro',1,1),"
                   + "(16120351,'De Arco','Juana',2,1)";
           PreparedStatement ps=conexion.prepareStatement(sql);
           int reg= ps.executeUpdate();
            System.out.println(reg);*/
            
           //----------------------------------------------------
          /* //l) Listar todas las herramientas con stock superior a 10.
           
           String sql="SELECT * FROM herramienta WHERE stock > 10 ";
           PreparedStatement ps= conexion.prepareStatement(sql);
           ResultSet R=ps.executeQuery();
           
           while(R.next()){
               
               System.out.println("ID: "+ R.getInt("id_Herramienta"));
               System.out.println("NOMBRE: "+ R.getString("nombre"));
               System.out.println("DESCRIPCION: "+ R.getString("descripcion"));
               System.out.println("STOCK: "+ R.getInt("stock"));
               System.out.println("ESTADO: "+ R.getBoolean("estado"));
           }*/
          //----------------------------------------------------
         /*// m) Dar de baja al primer empleado ingresado a la base de datos.
         String sql="UPDATE empleado SET estado=0 WHERE id_Empleado=1";
         PreparedStatement ps=conexion.prepareStatement(sql);
         int registro=ps.executeUpdate();
            System.out.println(registro);*/
        
         
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Error carga de Drivers "+ ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion con base de datos "+ ex.getMessage());
        }
    }
    
}
