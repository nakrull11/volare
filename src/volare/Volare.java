/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import volare.modelo.Aerolinea;
import volare.modelo.AsientoData;
import volare.modelo.Avion;
import volare.modelo.AvionData;
import volare.modelo.Ciudad;
import volare.modelo.CiudadData;
import volare.modelo.CompraData;
import volare.modelo.Conexion;
import volare.modelo.Data;
import volare.modelo.Pais;
import volare.modelo.PaisData;
import volare.modelo.Pasajero;
import volare.modelo.PasajeroData;
import volare.modelo.VueloData;

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
        Ciudad ciudad;
        CiudadData ciudadData=null;
        CompraData compraData = null;
        PasajeroData pasajeroData=null;
        VueloData vueloData=null;
        AvionData avionData=null;
        AsientoData asientoData = null;
        

               

       try {
            conexion = new Conexion("jdbc:mysql://localhost/volare", "root", "");
            data = new Data(conexion);
            pasajeroData = new PasajeroData (conexion);
            vueloData = new VueloData(conexion);
            avionData = new AvionData(conexion);
            compraData = new CompraData(conexion);
            ciudadData = new CiudadData(conexion);
            asientoData = new AsientoData(conexion);
            //paisData = new PaisData(conexion);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al establecer la conexion :"+ex.getMessage());
        }
       Avion boeing = new Avion();
       boeing = avionData.obtenerAvion(1);
       Ciudad sanLuis = new Ciudad();
       sanLuis = ciudadData.obtenerCiudad(1);
       Ciudad laPaz = new Ciudad ();
       laPaz = ciudadData.obtenerCiudad(4);
       System.out.println(vueloData.consultarVuelos(sanLuis, laPaz));
       //vueloData.consultarVuelos(ciudad, ciudad);
        //System.out.println(boeing);
       //System.out.println(avionData.obtenerAvion(1));
       //System.out.println(asientoData.obtenerAsientosAvion(boeing));
       //System.out.println(asientoData.obtenerAsientosDisponiblesAvion(boeing));
       //System.out.println(ciudad = ciudadData.obtenerCiudad(4));
       //System.out.println(vueloData.consultarVuelos(ciudad));
       //compraData.consultarCompras(Date.valueOf("2018-12-02"),Date.valueOf("2018-12-05")).forEach(compra -> {System.out.println(compra.toString());});
       //System.out.println(pasajeroData.obtenerCorreo(37723905));
       //System.out.println(pasajeroData.obtenerPassPasajero(37723905));
       //System.out.println(compraData.consultarCompras(Date.valueOf("2018-12-02"),Date.valueOf("2018-12-05")));
       /*pasajeroData.obtenerPasajeros().forEach(pasajero -> {System.out.println(pasajero.toString());});*/
         
               
      
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
    


