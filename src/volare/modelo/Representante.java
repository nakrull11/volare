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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import volare.modelo.Aerolinea;

/**
 *
 * @author Alumno
 */
public class Representante {
    
    private int credencial;
    private String nombre;
    private String apellido;
    private int dni;
    private String password;
    private Aerolinea empleador;
    private Connection connection;
    
public Representante(int credencial, String nombre, String apellido,int dni, String password, Aerolinea empleador) {
        this.credencial = credencial;
        this.nombre = nombre;
        this.apellido= apellido;
        this.dni= dni;
        this.password= password;
        this.empleador = empleador;
}

    public void crearVuelo(float precioVuelo, Date fechaSalida, Date fechaLlegada,Aeropuerto aeropuertoSalida,Aeropuerto aeropuertoLlegada,Avion unAvion){
       Vuelo nuevoVuelo = new Vuelo();
       nuevoVuelo.setPrecio(precioVuelo);
       nuevoVuelo.setFechaSalida(fechaSalida);
       nuevoVuelo.setFechaLlegada(fechaLlegada);
       nuevoVuelo.setAeropuertoSalida(aeropuertoSalida);
       nuevoVuelo.setAeropuertoLlegada(aeropuertoLlegada);
       nuevoVuelo.setAvion(unAvion);
    }
    
    public void modificarVuelo(Vuelo vuelo,Estado estado){
       vuelo.setEstado(estado);
    }
    
    public List<Pasajero> consultarCliente(){
        ////Se crea la lista de pasajeros
        List<Pasajero> pasajeros = new ArrayList<Pasajero>();
            try {            
                String sql = "SELECT * FROM pasajero;";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                Pasajero pasajero;//Se declara un objeto de tipo pasajero
            while(rs.next()){
                //Pasajero no admite un constructor vacio,
                //se carga a traves de los getters del ResultSet que tiene la informacion de la tabla pasajero en la DB
                pasajero = new Pasajero(rs.getInt("dni_pasajero"),rs.getInt("pasaporte_pasajero"),rs.getString("correo_pasajero"),rs.getString("nombre_pasajero"),rs.getString("apellido_pasajero"),rs.getDate("fechanacimiento_pasajero"),rs.getInt("tarjeta_pasajero"),rs.getString("password_pasajero"));
                pasajeros.add(pasajero);
                }
            statement.close();
           }catch (SQLException ex) {
                System.out.println("Error al obtener la lista de pasajeros: " + ex.getMessage());
        }
        return pasajeros;
        }
    
    
    
    ///////////////////////GETTERS Y SETTERS///////////////////////
    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public Aerolinea getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Aerolinea empleador) {
        this.empleador = empleador;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}