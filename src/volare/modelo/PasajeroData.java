/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class PasajeroData extends Data {
    
    public PasajeroData(Conexion conexion) {
        super(conexion);
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
                pasajero.setFechaNacimiento(resultado.getDate("fechanacimiento_pasajero"));
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
    
    
    
    
}
