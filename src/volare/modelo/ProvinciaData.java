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
 * @author Usuario
 */
public class ProvinciaData {
    private Connection connection = null;
    private PaisData paisData =null;
    
    public ProvinciaData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            paisData = new PaisData(conexion);
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
        
    }
    
    public Provincia obtenerProvincia(int id){
            Provincia provincia=null;
        try {
            
            String sql = "SELECT * FROM provincia WHERE id_provincia = ? ;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                provincia = new Provincia();
                provincia.setId(rs.getInt("id_provincia"));
                provincia.setNombre(rs.getString("nombre_provincia"));
                provincia.setPais(paisData.buscarPais(rs.getInt("id_pais")));
                
            }
            return provincia;
        } catch (SQLException ex) {
            System.out.println("Error al obtener la provincia :"+ex.getMessage());
        }
        return provincia;
    }
    
    
    
}
