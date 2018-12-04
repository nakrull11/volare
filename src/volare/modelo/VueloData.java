/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.sql.Connection;
import java.sql.Date;
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
public class VueloData{
    
    private Connection connection = null;
    public VueloData(Conexion conexion) {
       try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    /*public Vuelo consultarVuelos(Ciudad ciudadDestino, Date fecha){
        
    
    }*/
    
    public float devolverPrecio(int id){
        float precio=0;
        try {
            String sql= "SELECT DISTINCT v.precio_vuelo FROM compra c INNER JOIN vuelo v ON c.id_vuelo = v.id_vuelo WHERE c.id_vuelo= ?;";
            PreparedStatement ps_precio =connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps_precio.setFloat(1, id);
            ResultSet rs = ps_precio.executeQuery();
            while(rs.next()){
                precio = rs.getFloat("precio_vuelo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VueloData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return precio;
        
    }
    
}
