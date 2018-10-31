/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import volare.modelo.Pais;
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
public class PaisData {
    private Connection connection = null;
    
    public PaisData(Conexion conexion){
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
    }
    
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
        } catch (SQLException ex) {
            System.out.println("Error al borrar un pais: "+ex.getMessage());
        }
    }
    
    public void actualizarPais(Pais pais){
    
        try {
            String slq="UPDATE pais SET codigo_pais= ?, nombre_pais= ? WHERE id_pais= ?";
            
            PreparedStatement statement = connection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1,pais.getCodigo());
            
            statement.setString(2,pais.getNombre());
            
            statement.setInt(3,pais.getId());
            
            statement.executeUpdate();
            
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
    
}
