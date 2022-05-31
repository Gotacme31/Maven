/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author aly
 */

    import java.sql.*;
    
public class Conexion {
    public static Connection getConnection(){
    String url, username, password;
    
    url = "jdbc:mysql://localhost/empresa";
    username = "root";
    password = "alery050831";
    
    Connection con = null;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection(url, username, password);
        System.out.println("se conecto con la BD");
    }catch(Exception e){
        System.out.println("No se conecto");
        System.out.println(e.getMessage());
        }
    return con;
    }
}
