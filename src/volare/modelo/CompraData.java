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
    
    public CompraData(Conexion conexion){
        try {
            connection = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    
    }
    
    public boolean comprarAsiento(Asiento asiento){
        try {
            String sql = "UPDATE asiento SET estado_asiento = ? WHERE id_asiento= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, false);
            ps.setInt(2, asiento.getId());
            ps.executeUpdate();
            ps.close();
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al comprar el asiento"+ex.getMessage());
            return false;
        }
        return true;
    }
    
    
    
    public List<Compra> consultarCompras(Date fechaMenor,Date fechaMayor){               
        List<Compra> compras = new ArrayList<>();
        PasajeroData pasajeroData=null;
        try {
            
            String sql="SELECT fecha_reserva,id_vuelo,dni_pasajero,id_asiento,id_estado FROM compra c WHERE c.fecha_reserva > ? AND c.fecha_reserva < ?;";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, fechaMenor);
            ps.setDate(2, fechaMayor);
            ResultSet resultado = ps.executeQuery();
             while(resultado.next()){
               Pasajero pasajero = new Pasajero();//Se crea el pasajero para agregar a a lista                
               pasajero.setDni(resultado.getInt("dni_pasajero"));//Se setea el dni de la tabla
                String sqlPasajero = "SELECT * FROM pasajero WHERE dni_pasajero="+" "+pasajero.getDni()+";";//Se seleciona todos los datos
                PreparedStatement psPasajero = connection.prepareStatement(sqlPasajero, Statement.RETURN_GENERATED_KEYS);
                ResultSet rsPasajero = psPasajero.executeQuery();
                while(rsPasajero.next()){//Se carga todos los datos del pasajero
                    pasajero.setNombre(rsPasajero.getString("nombre_pasajero"));
                    pasajero.setApellido(rsPasajero.getString("apellido_pasajero"));
                    pasajero.setCorreoElectronico(rsPasajero.getString("correo_pasajero"));
                    pasajero.setFechaNacimiento(rsPasajero.getDate("fechanacimiento_pasajero").toLocalDate());
                    pasajero.setNumeroTarjeta(rsPasajero.getInt("tarjeta_pasajero"));
                    pasajero.setPasaporte(rsPasajero.getInt("pasaporte_pasajero"));
                    pasajero.setPassword(rsPasajero.getString("password_pasajero"));
                }
               Vuelo vuelo = new Vuelo();//Se crea el vuelo
               vuelo.setId(resultado.getInt("id_vuelo"));//Se le setea el id
                String sqlVuelo= "SELECT * FROM vuelo WHERE id_vuelo="+" "+vuelo.getId()+";";//Se seleciona todos los vuelos que corresponde a ese id
                PreparedStatement psVuelo = connection.prepareStatement(sqlVuelo, Statement.RETURN_GENERATED_KEYS);
                ResultSet rsVuelo = psVuelo.executeQuery();
                while(rsVuelo.next()){//Se carga el vuelo con los datos del result set
                    vuelo.setPrecio(rsVuelo.getFloat("precio_vuelo"));
                    vuelo.setFechaSalida(rsVuelo.getDate("fechasalida_vuelo"));
                    vuelo.setFechaLlegada(rsVuelo.getDate("fechallegada_vuelo"));
                    vuelo.setRefuerzo(rsVuelo.getBoolean("refuerzo_vuelo"));          
                }
               Asiento asiento = new Asiento();
               asiento.setId(resultado.getInt("id_asiento"));
                String sqlAsiento = "SELECT * FROM asiento WHERE id_asiento="+" "+asiento.getId()+";";
                PreparedStatement psAsiento = connection.prepareStatement(sqlAsiento,Statement.RETURN_GENERATED_KEYS);
                ResultSet rsAsiento = psAsiento.executeQuery();
                while(rsAsiento.next()){
                    asiento.setEstado(rsAsiento.getBoolean("estado_asiento"));
                    asiento.setNumero(rsAsiento.getString("numero_asiento"));
                    asiento.setPasillo(rsAsiento.getBoolean("pasillo_asiento"));
                    Avion avion = new Avion ();
                    String sqlAvion = "SELECT * FROM avion WHERE";
                }
              
               Compra compra = new Compra();
               compra.setPrecio(7500);
               compra.setEstado("normal");//se ingresa el estado por defecto "normal"
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
