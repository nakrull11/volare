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
public class AerolineaData {
    
    private Connection connection;
    
    public AerolineaData(Conexion conexion){
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    public Aerolinea obtenerAerolinea(int cuit){
        Aerolinea aerolinea=null;
        try {
            
            
            String sql= "SELECT * FROM aerolinea WHERE cuit_aerolinea= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cuit);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                aerolinea = new Aerolinea();
                aerolinea.setCuit(rs.getInt("cuit_aerolinea"));
                aerolinea.setNombre(rs.getString("nombre_aerolinea"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AerolineaData.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return aerolinea;
        
    }
    
    
    
}
