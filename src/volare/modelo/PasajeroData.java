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
public class PasajeroData extends Data {
    
    private Connection connection = null;
    
    public PasajeroData(Conexion conexion) {
        super(conexion);
        try {
            connection = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
    
   
    
    
    
    
    public boolean guardarPasajero(Pasajero pasajero){
        try {
            String sql = "INSERT INTO pasajero (dni_pasajero,pasaporte_pasajero,correo_pasajero,nombre_pasajero,apellido_pasajero,fechanacimiento_pasajero,password_pasajero) VALUES ( ? , ? , ? , ? , ? , ? , ?); ";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasajero.getDni());
            ps.setInt(2, pasajero.getPasaporte());
            ps.setString(3, pasajero.getCorreoElectronico());
            ps.setString(4, pasajero.getNombre());
            ps.setString(5, pasajero.getApellido());
            ps.setDate(6, Date.valueOf(pasajero.getFechaNacimiento()));
            ps.setString(7, pasajero.getPassword());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar el pasajero"+ex.getMessage());
            return false;
        }
        
        return true;
    
    }
    
    public List<Pasajero> obtenerPasajeros(){
            String tabla = "pasajero";//String "pasajero" que es el nombre de la tabla en nuestra DB
            List<Pasajero> pasajeros = new ArrayList<>();//Array List vacio de tipo Pasajero
            Pasajero pasajero;//Objeto de tipo pasajero para cargar con los datos de la db
            ResultSet resultado = super.consultar(tabla);//se crea un objeto de tipo ResultSet resultado que se carga con 
            //los datos que trae el metodo de la super clase Data, consultar, pasandole por parametro en nombre de la tabla
        
        try {
            
            while(resultado.next()){//Se crea el pasajero con los datos de la tabla correspondiente
                pasajero = new Pasajero();
                pasajero.setDni(resultado.getInt("dni_pasajero"));
                pasajero.setNombre(resultado.getString("nombre_pasajero"));
                pasajero.setApellido(resultado.getString("apellido_pasajero"));
                pasajero.setCorreoElectronico(resultado.getString("correo_pasajero"));
                pasajero.setFechaNacimiento(resultado.getDate("fechanacimiento_pasajero").toLocalDate());
                pasajero.setNumeroTarjeta(resultado.getInt("tarjeta_pasajero"));
                pasajero.setPassword(resultado.getString("password_pasajero"));
                pasajero.setPasaporte(resultado.getInt("pasaporte_pasajero"));
                pasajeros.add(pasajero);
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de pasajeros :"+ex.getMessage());
        }
        
        return pasajeros;//Se devuelve la lista
    }
    
    public Pasajero obtenerPasajero(int dni){
        Pasajero pasajero = null;
        try {
            
            String sql = "SELECT * FROM pasajero WHERE dni_pasajero= ? ;";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pasajero = new Pasajero();
                pasajero.setNombre(rs.getString("nombre_pasajero"));
                pasajero.setApellido(rs.getString("apellido_pasajero"));
                pasajero.setCorreoElectronico(rs.getString("correo_pasajero"));
                pasajero.setPassword(rs.getString("password_pasajero"));
                pasajero.setFechaNacimiento(rs.getDate("fechanacimiento_pasajero").toLocalDate());
                pasajero.setNumeroTarjeta(rs.getInt("tarjeta_pasajero"));
                pasajero.setPasaporte(rs.getInt("pasaporte_pasajero"));
                pasajero.setDni(dni);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener el cliente :"+ex.getMessage());
        }
        return pasajero;
    }
    
    
     public String obtenerCorreo (int dni){
         Pasajero pasajero;
         String correo=null;
         try {
             String sql="SELECT correo_pasajero FROM pasajero WHERE dni_pasajero= ? ;";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, dni);
             ResultSet rs = statement.executeQuery();
             while(rs.next()){
                 pasajero=new Pasajero();
                 pasajero.setCorreoElectronico(rs.getString("correo_pasajero"));
                 correo=pasajero.getCorreoElectronico();
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener el correo del pasajero: "+ex.getMessage());
         }
         return correo;
     }
     
      public String obtenerPassPasajero (int dni){
         Pasajero pasajero;
         String pass=null;
         try {
             String sql="SELECT password_pasajero FROM pasajero WHERE dni_pasajero= ? ;";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, dni);
             ResultSet rs = statement.executeQuery();
             while(rs.next()){
                 pasajero=new Pasajero();
                 pasajero.setPassword(rs.getString("password_pasajero"));
                 pass = pasajero.getPassword();
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener el pass: "+ex.getMessage());
         }
         return pass;
     }
    
}
