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
import java.time.LocalDate;
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
    private AsientoData asientoData = null;
    private VueloData vueloData = null;
    private PasajeroData pasajeroData = null;
    
    public CompraData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            asientoData = new AsientoData(conexion);
            vueloData = new VueloData(conexion);
            pasajeroData = new PasajeroData(conexion);
            
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    
    }
    
    public void comprarAsiento(Asiento asiento){
        try {
            String sql = "UPDATE asiento SET estado_asiento = ? WHERE id_asiento= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, true);
            ps.setInt(2, asiento.getId());
            ps.executeUpdate();
            ps.close();
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al comprar el asiento"+ex.getMessage());
            
        }
        
    }
    
    public void generarCompra(int idVuelo,int dni,int idAsiento){
        
        try {
            String sql ="INSERT INTO compra (fecha_reserva,estado_compra,id_vuelo,dni_pasajero,id_asiento) VALUES (CURRENT_TIMESTAMP,'normal', ? , ? , ? );";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idVuelo);
            ps.setInt(2, dni);
            ps.setInt(3, idAsiento);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al generar la compra: "+ex.getMessage());
          
        }
                                    
    }
    
    
    
    /*public List<Compra> consultarCompras(int dni){               
        
        List<Compra> compras = new ArrayList<>();
        try {
            
            
            String sql="SELECT * FROM compras WHERE compras.dni_pasajero = ?;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Compra compra = new Compra();
                compra.setEstado(rs.getString("estado_compra"));
                compra.setFechaReserva(rs.getDate("fecha_reserva"));
                compra.setId(rs.getInt("id_compra"));
                //Asiento asiento = asientoData.obtenerAsiento(rs.getInt("id_asiento"));
                //compra.setNumeroAsiento(asiento);
                Vuelo vuelo = vueloData.consultarVuelo(rs.getInt("id_vuelo"));
                compra.setVuelo(vuelo);
                Pasajero pasajero = pasajeroData.obtenerPasajero(dni);
                compra.setPasajero(pasajero);
                compras.add(compra);
                
            }
                            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de compras: "+ex.getMessage());
        }
        
        return compras;
    }*/
    
}
