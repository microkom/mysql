/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.*;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion login = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        int retorno = 0;
        
        try{
            con = login.conectar();
            System.out.println("\tConexión establecida");
            
            stmt = con.prepareStatement("INSERT INTO Categorias VALUES(?,?,?)");
            stmt.setInt(1, 10);
            stmt.setString(2,"Pasta");
            stmt.setString(3,"Productos de pasta");
            stmt.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
