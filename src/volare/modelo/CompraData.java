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
public class CompraData{
    private Connection connection = null;
    
    public CompraData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    
    }
    
    
    
    
    public List<Compra> consultarCompras(Date fechaMenor,Date fechaMayor){               
        List<Compra> compras = new ArrayList<>();
        try {
            
            String sql="SELECT * FROM compra c WHERE c.fecha_reserva > ? AND c.fecha_reserva < ?;";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, fechaMenor);
            ps.setDate(2, fechaMayor);
            ResultSet resultado = ps.executeQuery();
            
            
 
            
            while(resultado.next()){
               Pasajero pasajero = new Pasajero();
               pasajero.setDni(resultado.getInt("dni_pasajero"));
               Vuelo vuelo = new Vuelo();
               vuelo.setId(resultado.getInt("id_vuelo"));
               Asiento asiento = new Asiento();
               asiento.setId(resultado.getInt("id_asiento"));
               Estado estado = new Estado();
               estado.setId(resultado.getInt("id_estado"));
               Compra compra = new Compra();
               compra.setPrecio(7500);
               compra.setEstado(estado);
               compra.setFechaReserva(resultado.getDate("fecha_reserva"));
               compra.setVuelo(vuelo);
               compra.setPasajero(pasajero);
               compra.setNumeroAsiento(asiento);
               
               compras.add(compra);
               
               
               
                
             }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de precios :"+ex.getMessage());
        }
        return compras;
    }
    
}
