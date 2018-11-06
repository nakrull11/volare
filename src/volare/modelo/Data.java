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
public class Data {
     private Connection connection = null;
     
     public Data(Conexion conexion){
         
         try {
             connection=conexion.getConexion();
         } catch (SQLException ex) {
             System.out.println("Error al conectarse: " + ex.getMessage());
         }
     }
     
///////////////////////METODOS TABLA PAIS///////////////////////////////////////   
    public void agregarPais(Pais pais){
        try {
                //Statement SQL//
            String sql = "INSERT INTO pais (codigo_pais, nombre_pais) VALUES ( ? , ? );";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                //Se carga los datos al statement para el insert//
            statement.setString(1, pais.getCodigo());
            statement.setString(2, pais.getNombre());
               
                //Se ejecuta un update//
            statement.executeUpdate();
            System.out.println("Se guardo"+" "+pais.getNombre()+" "+"exitosamente.");
        } catch (SQLException ex) {
           System.out.println("Error al insertar un pais");
        }
    }
    
    public List<Pais> obtenerPaises(){
        List<Pais> paises = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pais;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Pais pais;
            while(resultSet.next()){
                pais = new Pais();
                pais.setId(resultSet.getInt("id_pais"));
                pais.setCodigo(resultSet.getString("codigo_pais"));
                pais.setNombre(resultSet.getString("nombre_pais"));
                
                paises.add(pais);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de paises: " +ex.getMessage());
        }
        
        return paises;
        }
    
    public void borrarPais(int id){
    
        try {
            String slq= " DELETE FROM pais WHERE id_pais =?;";
            
            PreparedStatement statement = connection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Se ha borrado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar un pais: "+ex.getMessage());
        }
    }
    
    public void actualizarPais(Pais pais,int id,String codigo,String nombre){
    
        try {
            String slq="UPDATE pais SET id_pais= ?,codigo_pais= ?, nombre_pais= ? WHERE id_pais= ?";
            
            PreparedStatement statement = connection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1,id);
            
            statement.setString(2,codigo);
            
            statement.setString(3,nombre);
            
            statement.setInt(4,pais.getId());
            
            statement.executeUpdate();
            
            System.out.println("Exito al actualizar.");
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el pais: "+ex.getMessage());
        }
        
    }
    
    public Pais buscarPais(int id){
        Pais pais= null;
        try {
            
            
            String sql="SELECT * FROM pais WHERE id_pais= ?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                pais= new Pais();
                pais.setId(resultSet.getInt("id_pais"));
                pais.setCodigo(resultSet.getString("codigo_pais"));
                pais.setNombre(resultSet.getString("nombre_pais"));
                
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaisData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pais;
    }
////////////////////////////////////////////////////////////////////////////////
    
///////////////////////METODOS TABLA REPRESENTATE///////////////////////////////
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
     
     public void modificarVuelo(Vuelo vuelo,Estado estado){
         vuelo.setEstado(estado);
         try {
             
             String sql="UPDATE vuelo SET id_estado= ?;";
             PreparedStatement ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             
             ps.setInt(1,estado.getId());
             
             ps.executeUpdate();
             
             ps.close();
         } catch (SQLException ex) {
             System.out.println("Ocurrio un error al modificar el estado: " + ex.getMessage());;
         }
    }
////////////////////////////////////////////////////////////////////////////////

  ////////////////////////////////METODOS TABLA PASAJEROS///////////////////////
     public void modificarCompra (Compra compraHecha, int dni) {
             compraHecha.setId(-1);
             compraHecha.setFechaReserva(null);
             compraHecha.setPasajero(null);
             compraHecha.setNumeroAsiento(null);
         try {
            
             
             String sql= ("DELETE * FROM compra WHERE dni_pasajero= ?;");
             PreparedStatement ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, dni);
             ps.executeUpdate();
             ps.close();
             System.out.println("la compra ha sido cancelada con exito");
         } catch (SQLException ex) {
            System.out.println("se ha produccido un error al modificar la compra");
         }
     }   
}
