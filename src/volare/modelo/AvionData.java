/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class AvionData {
    
    private Connection connection = null;
    
    public AvionData(Conexion conexion){
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión");
        }
        
    }
    
    
    
    
}
