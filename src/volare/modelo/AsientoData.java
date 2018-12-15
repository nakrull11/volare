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
public class AsientoData {
    private Connection connection;
    
    public AsientoData(Conexion conexion){
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    
    
    public List<Asiento> obtenerAsientosDisponibles(){
        List<Asiento> asientos = new ArrayList <>();
        try {
            String sql ="SELECT * FROM asiento WHERE estado_asiento = false;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Asiento asiento = new Asiento();
                asiento.setEstado(rs.getBoolean("estado_asiento"));
                asiento.setNumero(rs.getString("numero_asiento"));
                asiento.setPasillo(rs.getBoolean("pasillo_asiento"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asientos;
    }
    
    public List<Asiento> obtenerAsientosAvion(Avion avion){
        List<Asiento> asientos = new ArrayList <> ();
        try {
            
            
            String sql = "SELECT * FROM asiento WHERE asiento.id_avion = ?;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, avion.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
                
            }
            
                      
        } catch (SQLException ex) {
            Logger.getLogger(AsientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return asientos;   
    }
    
    
}
