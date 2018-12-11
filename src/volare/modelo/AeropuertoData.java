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

/**
 *
 * @author gustavo
 */
public class AeropuertoData {
    private Connection connection = null;
    
    public AeropuertoData(Conexion conexion) {
       try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    public void agregarAeropuerto(Aeropuerto aeropuerto, Ciudad ciudad){
         try {
             String sql = "INSERT INTO aeropuerto (codigo_aeropuerto, id_ciudad) VALUES ( ? , ? );";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setString(1, aeropuerto.getCodigo());
             statement.setInt(2, ciudad.getId());
             statement.executeUpdate();
             System.out.println("Se guardo"+" "+aeropuerto.getCodigo()+" "+"con exito.");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al guardar el aeropuerto: "+ex.getMessage());
         }
    }
    
    public List<Aeropuerto> obtenerAeropuertos(Ciudad ciudad){
        List<Aeropuerto> aeropuertos = new ArrayList<>(); 
        try {             
             String sql = "SELECT * FROM aeropuerto WHERE id_ciudad=?;";
             PreparedStatement statement= connection.prepareStatement(sql);
             statement.setInt(1, ciudad.getId());
             ResultSet resultSet = statement.executeQuery();
             Aeropuerto aeropuerto;
             while(resultSet.next()){
                 aeropuerto = new Aeropuerto();
                 aeropuerto.setCodigo(resultSet.getString("codigo_aeropuerto"));
                 aeropuerto.setCiudad(ciudad);
                 aeropuertos.add(aeropuerto);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de vuelo: "+ex.getMessage());
         }
        return aeropuertos;
    }
    
    public void borrarAeropuerto(int id){
         try {
             String sql ="DELETE * FROM aeropuerto WHERE id_aeropuerto= ?;";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.executeUpdate();
             System.out.println("Se ha borrando con exito");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al borrar el aeropuerto: "+ex.getMessage());
         }
    }   
    
    public void actualizarAeropuerto(Aeropuerto aeropuerto,int id,String codigo,Ciudad ciudad){
         try {
             String sql ="UPDATE aeropuerto SET id_aeropuerto=? , codigo_aeropuerto=? , id_ciudad= ? WHERE id_aeropuerto= ?;";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.setString(2, codigo);
             statement.setInt(3, ciudad.getId());
             statement.setInt(4, aeropuerto.getId());
             statement.executeUpdate();
             System.out.println("Exito al actualizar el aeropuerto");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al actualizar el aeropuerto: "+ex.getMessage());
         }
    }
    
    public Aeropuerto buscarAeropuerto(int id, Ciudad ciudad){
        Aeropuerto aeropuerto=null; 
        try {            
             String sql="SELECT * FROM aeropuerto WHERE id_aeropuerto=?;";
             PreparedStatement statement= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             while(resultSet.next()){
                 aeropuerto= new Aeropuerto();
                 aeropuerto.setCodigo(resultSet.getString("codigo_aeropuerto"));
                 aeropuerto.setCiudad(ciudad);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al buscar el aeropuerto: "+ex.getMessage());
         }
        return aeropuerto;
    }
    
    
}
