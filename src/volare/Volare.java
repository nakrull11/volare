/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare;

import java.util.logging.Level;
import java.util.logging.Logger;
import volare.modelo.Conexion;
import volare.modelo.Pais;
import volare.modelo.PaisData;

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
        Pais pais;
    
       try {
            conexion = new Conexion("jdbc:mysql://localhost/volare", "root", "");
            paisData = new PaisData(conexion);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Volare.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       pais = new Pais("UR","Uruguay");
       
       //AGREGAR PAISES
       paisData.agregarPais(pais);
       
       //MOSTAR PAISES
       System.out.println(paisData.buscarPais(2).toString());
       
       //BORRAR PAISES
       //paisData.borrarPais(3);
       
       //LISTA DE PAISES
       System.out.println(paisData.obtenerPaises());
       pais.setCodigo("PR");
       pais.setNombre("Paraguay");
       pais.setId(4);
       //ACTULIZAR PAISES
       paisData.actualizarPais(pais);
       
       
        
    
         
        
    }
        
        
    }
    


