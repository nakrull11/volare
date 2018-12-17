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
public class AvionData {
    
    private Connection connection = null;
    private AsientoData asientoData;
    private AerolineaData aerolineaData = null;
    
    public AvionData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            asientoData = new AsientoData(conexion);
            aerolineaData = new AerolineaData (conexion);
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
        
    }
    
    
    public Avion obtenerAvion(int id){
        Avion avion = null;
        try {
            
            String sql = "SELECT * FROM avion WHERE id_avion = ?;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                avion = new Avion();
                avion.setId(rs.getInt("id_avion"));
                avion.setModelo(rs.getString("modelo_avion"));
                avion.setAsiento(rs.getInt("asiento_avion"));
                avion.setCuitAerolinea(aerolineaData.obtenerAerolinea(rs.getInt("cuit_aerolinea")));
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener el avion: "+ex.getMessage());
        }
        return avion;
    }
    
    
}
