/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class Data {
     private Connection connection = null;
     
     public Data(Conexion conexion){
         
         try {
             connection=conexion.getConexion();
         } catch (SQLException ex) {
             System.out.println("Error al conectarse: " + ex.getMessage());
         }
     }
     
     public ResultSet consultar(int id, String tabla, String primaryKey){
         ResultSet resultSet=null;
         try {
             String sql = "SELECT * FROM"+" "+tabla+" "+"WHERE"+" "+primaryKey+"="+id+";";
             PreparedStatement statement = connection.prepareStatement(sql);
             resultSet= statement.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
         }
         return resultSet;
     }
     
     public ResultSet consultar(String tabla){
         ResultSet resultSet=null;
         try {
             String sql = "SELECT * FROM"+" "+tabla+" "+";";
             PreparedStatement statement = connection.prepareStatement(sql);
             resultSet= statement.executeQuery();
         } catch (SQLException ex) {
             System.out.println("error al ejecutar la consulta :"+ex.getMessage());
         }
         return resultSet;
     }
     
  }

