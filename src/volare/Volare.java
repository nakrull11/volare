/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import volare.modelo.Aerolinea;
import volare.modelo.Conexion;
import volare.modelo.Data;
import volare.modelo.Pais;
import volare.modelo.PaisData;
import volare.modelo.Pasajero;
import volare.modelo.PasajeroData;
import volare.modelo.Representante;

/**
 *
 * @author franncode <github.com/franncode>
 */
public class Volare {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion conexion;
        PaisData paisData = null;
        Data data;
        Pais pais;
        PasajeroData pasajeroData=null;
        Representante gustavo;
        
       try {
            conexion = new Conexion("jdbc:mysql://localhost/volare", "root", "");
            data = new Data(conexion);
            pasajeroData = new PasajeroData (conexion);
            //paisData = new PaisData(conexion);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Volare.class.getName()).log(Level.SEVERE, null, ex);
        }
       pasajeroData.obtenerPasajeros().forEach(pasajero -> {System.out.println(pasajero.toString());});
               
      
       //pais = new Pais("PE","Peru");
       
       //AGREGAR PAISES
       //data.agregarPais(pais);
       
       //MOSTAR PAISES
       //System.out.println(paisData.buscarPais(2).toString());
       
       //BORRAR PAISES
       //data.borrarPais(5);
       
       //BUSCAR PAIS
       //System.out.println(data.buscarPais(1));
       
       //LISTA DE PAISES
       //System.out.println(paisData.obtenerPaises());
       
       //ACTULIZAR PAISES
       //pais.setCodigo("PE");
       //pais.setNombre("Peru");
       //pais.setId(6);
       //data.actualizarPais(pais,5,"CH","Chile");
       
          
    }
        
        
    }
    


