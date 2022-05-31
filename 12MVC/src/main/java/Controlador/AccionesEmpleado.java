/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.empleados;

/**
 *
 * @author aly
 * esta clase son los metodos de accceso
 */

public class AccionesEmpleado {
    //CRUD
    
    //registro
    public static int resgistroEmpleado(empleados e){
        int estatus = 0;
        try{
            //establecer la coneccion con la bd
            Connection con = Conexion.getConnection();
            String q = "insert into empleados(nombre, password, email, pais)" + "values(?, ?, ?, ?)";
            
            //ahora debo de preparar la sentencia
            
            PreparedStatement ps= con.prepareStatement(q);
            
            //objeto del empleado
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPais());
            
            //ejecutar la querry
            
            estatus= ps.executeUpdate();
            
            System.out.println("Registro exitoso");
            con.close();
        }catch (Exception ex){
            System.out.println("Error al registrar al empleado");
            System.out.println(ex.getMessage());
        }
        return estatus;
    }
    //consultar todos los empleados
    public static List<empleados>getAllEmpleados(){
        //primero declarar el arraylist
           List<empleados> lista= new ArrayList<empleados>();
           try{
               
               //establecer la coneccion
               Connection con= Conexion.getConnection();
               
               String q= "select * from empleados";
               
               PreparedStatement ps= con.prepareStatement(q);
               
               ResultSet rs= ps. executeQuery();
               
               while(rs.next()){
               //donde se crea el objeto del empleado
               empleados e= new empleados();
               e.setId(rs.getInt(1));
               e.setNombre(rs.getString(2));
               e.setPassword(rs.getString(3));
               e.setEmail(rs.getString(4));
               e.setPais(rs.getString(5));
               lista.add(e);
               }
               System.out.println("se consulto al empleado");
               con.close();
           }catch(Exception ex){
               System.out.println("no se pudo consultar al empleado");
               System.out.println(ex.getMessage());
           }
           return lista;
    }
    //buscar empleado por id
    
    public static empleados buscarEmpleadoID(int id){
        //primero declarar el arraylist
           empleados e= new empleados();
           try{
               
               //establecer la coneccion
               Connection con= Conexion.getConnection();
               
               String q= "select * from empleados where id = ?";
                
               PreparedStatement ps= con.prepareStatement(q);
               
               ps.setInt(1,id);
               
               ResultSet rs= ps. executeQuery();
               
               if(rs.next()){
               //donde se crea el objeto del empleado
               
               e.setId(rs.getInt(1));
               e.setNombre(rs.getString(2));
               e.setPassword(rs.getString(3));
               e.setEmail(rs.getString(4));
               e.setPais(rs.getString(5));
               
               }
               System.out.println("se consulto al empleado");
               con.close();
           }catch(Exception ex){
               System.out.println("no se pudo consultar al empleado");
               System.out.println(ex.getMessage());
           }
           return e;
    }
       public static empleados buscarEmpleadoNombre(String Nombre, int id){
        //primero declarar el arraylist
           empleados e= new empleados();
           try{
               
               //establecer la coneccion
               Connection con= Conexion.getConnection();
               
               String q= "select * from empleados where nombre = ?";
                
               PreparedStatement ps= con.prepareStatement(q);
               
               ps.setInt(1,id);
               
               ResultSet rs= ps. executeQuery();
               
               if(rs.next()){
               //donde se crea el objeto del empleado
               
               e.setId(rs.getInt(1));
               e.setNombre(rs.getString(2));
               e.setPassword(rs.getString(3));
               e.setEmail(rs.getString(4));
               e.setPais(rs.getString(5));
               
               }
               System.out.println("se consulto al empleado");
               con.close();
           }catch(Exception ex){
               System.out.println("no se pudo consultar al empleado");
               System.out.println(ex.getMessage());
           }
           return e;
    }
       public static int eliminarEmpleado(int id){
        //necesito saber el estado de la query para ver si se ejecuto o no
           int estatus=0;
           try{
               
               //establecer la coneccion
               Connection con= Conexion.getConnection();
               
               String q= "delete from empleados where id = ?";
                
               PreparedStatement ps= con.prepareStatement(q);
               
               ps.setInt(1,id);
               
               estatus = ps. executeUpdate();               
               
               
               System.out.println("se elimino al empleado");
               con.close();
           }catch(Exception ex){
               System.out.println("no se pudo eliminar al empleado");
               System.out.println(ex.getMessage());
           }
           return estatus;
    }
       public static int actualizarEmpleado(empleados e){
        //necesito saber el estado de la query para ver si se ejecuto o no
           int estatus=0;
           try{
               
               //establecer la coneccion
               Connection con= Conexion.getConnection();
               
               String q= "update empleados set nombre = ?," 
                       + "password= ?, email= ?, pais = ?"
                       + "where id = ?";
                
               PreparedStatement ps= con.prepareStatement(q);
               
               ps.setString(1, e.getNombre());
               ps.setString(2, e.getPassword());
               ps.setString(3, e.getEmail());
               ps.setString(4, e.getPais());
               ps.setInt(5,e.getId());
               
               estatus = ps. executeUpdate();               
               
               
               System.out.println("se actualizo al empleado");
               con.close();
           }catch(Exception ex){
               System.out.println("no se pudo actualizar al empleado");
               System.out.println(ex.getMessage());
           }
           return estatus;
    }

    public static int registroEmpleado(empleados e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
