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
    private AvionData avionData=null;
    public AsientoData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            //avionData = new AvionData(conexion);
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión: "+ex.getMessage());
        }
    }
    
    
    
    public List<Asiento> obtenerAsientosDisponiblesAvion(Avion avion){
        List<Asiento> asientos = new ArrayList <>();
        try {
            String sql ="SELECT * FROM asiento WHERE estado_asiento = false AND asiento.id_avion= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, avion.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Asiento asiento = new Asiento();
                asiento.setEstado(rs.getBoolean("estado_asiento"));
                asiento.setNumero(rs.getString("numero_asiento"));
                asiento.setPasillo(rs.getBoolean("pasillo_asiento"));
                asiento.setIdAvion(avion);
                asiento.setId(rs.getInt("id_asiento"));
                asientos.add(asiento);
                }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de asientos :"+ex.getMessage());
        }
        return asientos;
    }
    
    public ArrayList<Asiento> obtenerAsientosAvion(Avion avion){
        ArrayList<Asiento> asientos = new ArrayList <> ();
        try {
            
            
            String sql = "SELECT * FROM asiento WHERE asiento.id_avion = ?;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, avion.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Asiento asiento = new Asiento ();
                asiento.setEstado(rs.getBoolean("estado_asiento"));
                asiento.setNumero(rs.getString("numero_asiento"));
                asiento.setPasillo(rs.getBoolean("pasillo_asiento"));
                asiento.setIdAvion(avion);
                asiento.setId(rs.getInt("id_asiento")); 
                asientos.add(asiento);
            }
            
                      
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de asientos :"+ex.getMessage());
        }
       return asientos;   
    }
    
    
    public Asiento obtenerAsiento(int id){
        Asiento asiento = null;
        try {
            
            String sql ="SELECT * FROM asiento WHERE id_asiento= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                asiento = new Asiento();
                asiento.setEstado(rs.getBoolean("estado_asiento"));
                asiento.setNumero(rs.getString("numero_asiento"));
                asiento.setPasillo(rs.getBoolean("pasillo_asiento"));
                //Avion avion = avionData.obtenerAvion(rs.getInt("id_avion"));
                //asiento.setIdAvion(avion);
                asiento.setId(rs.getInt("id_asiento"));                            
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener al asiento: "+ex.getMessage());
        }
        
        return asiento;      
        
    }
    
    
    
    
    
    
}
