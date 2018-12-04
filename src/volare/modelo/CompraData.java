/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
            
            String sql="SELECT * FROM compra c WHERE c.fecha_reserva>"+" "+fechaMenor+" "+"AND"+" "+"c.fecha_reserva<"+" "+fechaMayor+";";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultado = ps.executeQuery();
            Compra compra;
            while(resultado.next()){
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;
    }
    
}
