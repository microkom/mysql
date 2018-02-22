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

        try {
            con = login.conectar();
            System.out.println("\tConexión establecida");
            /*
            // INSERCION 
            stmt = con.prepareStatement("INSERT INTO Categorias VALUES(?,?,?)");
            stmt.setInt(1, 11);
            stmt.setString(2, "Pasta de oro");
            stmt.setString(3, "Productos de pasta");
            retorno = stmt.executeUpdate();
            if (retorno>0){
                System.out.println(retorno+" ejecutados");
            }
            
            //ACTUALIZACION
            stmt = con.prepareStatement("UPDATE Categorias SET Descripcion='nueva descripcion' WHERE IdCategoria=?");
            stmt.setInt(1, 10);            
            retorno = stmt.executeUpdate();
            if (retorno>0){
                System.out.println(retorno+" ejecutados");
            }

            //ELIMINACION
            stmt = con.prepareStatement("DELETE FROM Categorias WHERE IdCategoria=?");
            stmt.setInt(1, 10);            
            retorno = stmt.executeUpdate();
            if (retorno>0){
                System.out.println(retorno+" ejecutados");
            }
             */
            
            stmt = con.prepareStatement("SELECT * FROM Productos WHERE Categoria=?");
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("NomProducto") + " \t" + rs.getInt("Precio"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            login.desconectar(con);
            System.out.println("\tConexión cerrada");
        }

    }

}
