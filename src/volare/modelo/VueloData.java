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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class VueloData{
    
    private Connection connection = null;
    private  AeropuertoData aeropuertoData=null; 
    public VueloData(Conexion conexion) {
       try {
            connection = conexion.getConexion();
            aeropuertoData = new AeropuertoData(conexion);
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    public List<Vuelo> consultarVuelos(Ciudad ciudadDestino){
        List<Vuelo> vuelos = new ArrayList<>();
        try {
            
            
            String sql =    "SELECT * FROM vuelo WHERE vuelo.id_aeropuerto_llegada= ? ";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ciudadDestino.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vuelo vuelo = new Vuelo ();
                vuelo.setFechaLlegada(rs.getDate("fechallegada_vuelo"));
                vuelo.setFechaSalida(rs.getDate("fechasalida_vuelo"));
                vuelo.setPrecio(rs.getFloat("precio_vuelo"));
                vuelo.setRefuerzo(rs.getBoolean("refuerzo_vuelo"));
                Aeropuerto aeropuerto = new Aeropuerto();
                aeropuerto = aeropuertoData.buscarAeropuerto(rs.getInt("id_aeropuerto_llegada"));
                vuelo.setAeropuertoLlegada(aeropuerto);
                Aeropuerto aeropuertoSalida = new Aeropuerto();
                aeropuertoSalida = aeropuertoData.buscarAeropuerto(rs.getInt("id_aeropuerto_salidad"));
                
                vuelos.add(vuelo);
                
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de vuelos :"+ex.getMessage());
        }
        return vuelos;
    
    }
    
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
             System.out.println("Error al devolver los precios: "+ex.getMessage());
        }
        
        return precio;
        
    }
    
}
