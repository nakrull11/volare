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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class CiudadData {
    private Connection connection = null;
    private ProvinciaData provinciaData;
    
    public CiudadData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            provinciaData = new ProvinciaData(conexion);
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
        
    }
    
    public Ciudad obtenerCiudad(int id){
        Ciudad ciudad = null;
        try {
            String sql= "SELECT * FROM ciudad WHERE id_ciudad = ? ;";
            PreparedStatement ps =connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ciudad = new Ciudad ();
                ciudad.setId(rs.getInt("id_ciudad"));
                ciudad.setNombre(rs.getString("nombre_ciudad"));
                ciudad.setProvincia(provinciaData.obtenerProvincia(rs.getInt("id_provincia")));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CiudadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ciudad;
    }
    
    
}
