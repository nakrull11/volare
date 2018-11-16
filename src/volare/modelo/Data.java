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
     
////////////////////////METODOS TABLA AEROLINEA/////////////////////////////////
     public void agregarAerolinea (Aerolinea aerolinea){
         try {
             String sql= "INSERT INTO aerolinea (cuit_aerolinea, nombre_aerolinea) VALUES ( ? , ? );";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);             
             statement.setInt(1, aerolinea.getCuit());
             statement.setString(2, aerolinea.getNombre());
             statement.executeUpdate();
             statement.close();
             System.out.println("Se guardo"+" "+ aerolinea.getNombre()+" "+"exitosamente.");
         } catch (SQLException ex) {
             System.out.println("Error al insertar la aerolinea");
         }
    }
     
     public List<Aerolinea> obtenerAerolineas(){
         List<Aerolinea> aerolineas = new ArrayList<>();
         try {
             String sql="SELECT * FROM aerolinea;";
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet= statement.executeQuery();
             Aerolinea aerolinea;
             while(resultSet.next()){
                 aerolinea = new Aerolinea();
                 aerolinea.setCuit(resultSet.getInt("cuit_aerolinea"));
                 aerolinea.setNombre(resultSet.getString("nombre_aerolinea"));
                 aerolineas.add(aerolinea);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener las aerolineas: "+ex.getMessage());
         }
         return aerolineas;
     }
     
     public void borrarAerolinea (int cuit){         
         try {
             String sql = "DELETE FROM aerolinea WHERE cuit_aerolinea = ?;";             
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, cuit);
             statement.executeUpdate();
             System.out.println("Se ha borrado la aerolinea con exito");
             statement.close();             
         } catch (SQLException ex) {
             System.out.println("Error al borrar la aerolinea :"+ex.getMessage());
         }
    }
     
     public void actualizarAerolinea(Aerolinea aerolinea, int cuit, String nombre){
         try {
             String sql="UPDATE aerolinea SET cuit_aerolinea= ?, nombre_aerolinea= ? WHERE cuit_aerolinea= ?";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, cuit);
             statement.setString(2, nombre);
             statement.setInt(3, aerolinea.getCuit());
             System.out.println("Exito al actualizar la aerolinea");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al actualizar la aerolinea :"+ex.getMessage());
         }
     }
     
     public Aerolinea buscarAerolinea(int cuit){
         Aerolinea aerolinea = null;
         try {
             String sql = "SELECT * FROM aerolinea WHERE cuit_aerolinea= ?;";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, cuit);
             ResultSet resultSet = statement.executeQuery();
             while(resultSet.next()){
                 aerolinea.setCuit(resultSet.getInt("cuit_aerolinea"));
                 aerolinea.setNombre(resultSet.getString("nombre_aerolinea"));
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la aerolinea: "+ex.getMessage());
         }
         return aerolinea;
     }
//-----------------------------------------------------------------------------//

///////////////////////METODOS TABLA AEROPUERTO/////////////////////////////////
    public void agregarAeropuerto(Aeropuerto aeropuerto, Ciudad ciudad){
         try {
             String sql = "INSERT INTO aeropuerto (codigo_aeropuerto, id_ciudad) VALUES ( ? , ? );";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setString(1, aeropuerto.getCodigo());
             statement.setInt(2, ciudad.getId());
             statement.executeUpdate();
             System.out.println("Se guardo"+" "+aeropuerto.getCodigo()+" "+"con exito.");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al guardar el aeropuerto: "+ex.getMessage());
         }
    }
    
    public List<Aeropuerto> obtenerAeropuertos(Ciudad ciudad){
        List<Aeropuerto> aeropuertos = new ArrayList<>(); 
        try {             
             String sql = "SELECT * FROM aeropuerto WHERE id_ciudad=?;";
             PreparedStatement statement= connection.prepareStatement(sql);
             statement.setInt(1, ciudad.getId());
             ResultSet resultSet = statement.executeQuery();
             Aeropuerto aeropuerto;
             while(resultSet.next()){
                 aeropuerto = new Aeropuerto();
                 aeropuerto.setCodigo(resultSet.getString("codigo_aeropuerto"));
                 aeropuerto.setCiudad(ciudad);
                 aeropuertos.add(aeropuerto);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de vuelo: "+ex.getMessage());
         }
        return aeropuertos;
    }
    
    public void borrarAeropuerto(int id){
         try {
             String sql ="DELETE * FROM aeropuerto WHERE id_aeropuerto= ?;";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.executeUpdate();
             System.out.println("Se ha borrando con exito");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al borrar el aeropuerto: "+ex.getMessage());
         }
    }   
    
    public void actualizarAeropuerto(Aeropuerto aeropuerto,int id,String codigo,Ciudad ciudad){
         try {
             String sql ="UPDATE aeropuerto SET id_aeropuerto=? , codigo_aeropuerto=? , id_ciudad= ? WHERE id_aeropuerto= ?;";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.setString(2, codigo);
             statement.setInt(3, ciudad.getId());
             statement.setInt(4, aeropuerto.getId());
             statement.executeUpdate();
             System.out.println("Exito al actualizar el aeropuerto");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al actualizar el aeropuerto: "+ex.getMessage());
         }
    }
    
    public Aeropuerto buscarAeropuerto(int id, Ciudad ciudad){
        Aeropuerto aeropuerto=null; 
        try {            
             String sql="SELECT * FROM aeropuerto WHERE id_aeropuerto=?;";
             PreparedStatement statement= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             while(resultSet.next()){
                 aeropuerto= new Aeropuerto();
                 aeropuerto.setCodigo(resultSet.getString("codigo_aeropuerto"));
                 aeropuerto.setCiudad(ciudad);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al buscar el aeropuerto: "+ex.getMessage());
         }
        return aeropuerto;
    }
//-----------------------------------------------------------------------------// 
    
///////////////////////METODOS TABLA ASIENTO////////////////////////////////////
    public void agregarAsiento(Asiento asiento,Avion avion){
         try {
             String sql="INSERT INTO asiento (numero_asiento,pasillo_asiento,id_avion) VALUES ( ? , ? , ? );";
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setString(1, asiento.getNumero());
             statement.setBoolean(2, asiento.isPasillo());
             statement.setInt(3, avion.getId());
             avion.agregarAsiento(asiento);
             statement.executeUpdate();
             System.out.println("Se guardo el asiento"+" "+asiento.getNumero()+" "+"con exito");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al guardar el asiento: "+ex.getMessage());
         }
    }
    
    public List<Asiento> obtenerAsientosDisponibles (Avion avion){
        List<Asiento> asientos = new ArrayList<>(); 
        try {
             String sql = "SELECT * FROM asiento WHERE id_avion=? AND estado_asiento=1";
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, avion.getId());
             ResultSet resultSet = statement.executeQuery();
             Asiento asiento;
             while(resultSet.next()){
                 asiento = new Asiento();
                 asiento.setNumero(resultSet.getString("numero_asiento"));
                 asiento.setPasillo(resultSet.getBoolean("pasillo_asiento"));
                 asiento.setEstado(resultSet.getBoolean("estado_asiento"));
                 asientos.add(asiento);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de asientos: "+ex.getMessage());
         }
        return asientos;
        
    }
    
    public void borrarAsiento (int id){
         try {
             String sql = "DELETE * FROM asiento WHERE id_asiento=?;";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.executeUpdate();
             System.out.println("Se ha borrado con exito");
             statement.close();
         } catch (SQLException ex) {
                System.out.println("Error al borrar el asiento");
         }
    }
    
    public void actualizarAsiento (Asiento asiento,int id,String numero,boolean pasillo,boolean estado,Avion idAvion){
         try {
             String sql="UPDATE asiento SET id_asiento = ?, numero_asiento= ?, pasillo_asiento= ?, estado_asiento= ?, id_avion= ? WHERE id_asiento= ?;";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             statement.setString(2, numero);
             statement.setBoolean(3, pasillo);
             statement.setBoolean(4, estado);
             statement.setInt(5, idAvion.getId());
             statement.setInt(6, asiento.getId());
             statement.executeUpdate();
             System.out.println("Exito al actualizar el asiento");
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al actualizar el asiento: "+ex.getMessage());
         }
    }
    
    public Asiento buscarAsiento(int id,Avion avion){
        Asiento asiento=null; 
        try {            
             String sql="SELECT * FROM asiento WHERE id_asiento= ?;";
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             while(resultSet.next()){
                 asiento = new Asiento();
                 asiento.setId(resultSet.getInt("id_asiento"));
                 asiento.setNumero((resultSet.getString("numero_asiento")));
                 asiento.setPasillo(resultSet.getBoolean("pasillo_asiento"));
                 asiento.setEstado(resultSet.getBoolean("estado_asiento"));
                 asiento.setIdAvion(avion);
             }
             statement.close();
         } catch (SQLException ex) {
             System.out.println("Error al buscar el asiento");
         }
        return asiento;
    }
    
    
//-----------------------------------------------------------------------------//

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
            statement.close();
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
            String slq="UPDATE pais SET id_pais= ?,codigo_pais= ?, nombre_pais= ? WHERE id_pais= ?;";
            
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
            System.out.println("Error al buscar el pais: "+ex.getMessage());
        }
        
        return pais;
    }
//-----------------------------------------------------------------------------//
    
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
     
     public String obtenerPassPasajero (int dni){
         Pasajero pasajero=null;
         String pass=null;
         try {
             String sql="SELECT password_pasajero FROM pasajero WHERE dni_pasajero=?;";
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
     
     public String obtenerCorreo (int dni){
         Pasajero pasajero=null;
         String correo= null;
         try {
             String sql="SELECT correo_pasajero FROM pasajero WHERE dni_pasajero=?;";
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
             Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
         }
         return correo;
     }
     
     public List<Vuelo> consultarVuelo(Aerolinea aerolinea){
        ////Se crea la lista de vuelo
        List<Vuelo> vuelo = new ArrayList<Vuelo>();
            try {            
                String sql = "SELECT * FROM vuelo WHERE nombre_aerolinea="+" "+aerolinea.getNombre()+";";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                
            statement.close();
           }catch (SQLException ex) {
                System.out.println("sin vuelos disponibles  " + ex.getMessage());
        }
        return vuelo;
     }
     
     public List<Vuelo> consultarVuelo(Aerolinea aerolinea,Ciudad ciudadDestino){
        ////Se crea la lista de vuelo
        List<Vuelo> vuelo = new ArrayList<Vuelo>();
            try {            
                String sql = "SELECT * FROM vuelo * WHERE nombre_aerolinea ="+" "+aerolinea.getNombre()+" "+"AND id_aeropuerto_llegada="+" "+ciudadDestino.getId()+";";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
               
            statement.close();
           }catch (SQLException ex) {
                System.out.println("sin vuelos disponibles  " + ex.getMessage());
        }
        return vuelo;
        
    }
//-----------------------------------------------------------------------------//

///////////////////////////////////METODOS TABLA PASAJEROS//////////////////////
     public void modificarCompra (Compra compraHecha, int dni) {            
         Estado reembolso = new Estado ();
         reembolso.setDisponibilidad("Reembolsado");
         compraHecha.setEstado(reembolso);
         try {
             String sql= ("UPDATE compra SET estado_compra= ? WHERE dni_pasajero= ?;");
             PreparedStatement ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, reembolso.getDisponibilidad());
             ps.setInt(2, dni);
             ps.executeUpdate();
             ps.close();
             System.out.println("la compra ha sido cancelada con exito");
         } catch (SQLException ex) {
            System.out.println("se ha produccido un error al modificar la compra");
         }
     }
     
     public List<Compra> consultarCompra(Pasajero pasajero){
            List <Compra> listaCompras = new ArrayList<> ();//Se crea la lista vacia para guardar las compras
         try {
             String sql = "SELECT * FROM compra WHERE dni_pasajero ="+" "+pasajero.getDni()+";";

             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             Compra compra;
             while(rs.next()){
                 Compra unacompra= new Compra();
                 unacompra.setFechaReserva(rs.getDate("fecha_reserva"));
                 unacompra.setPasajero(pasajero);
             }
             ps.executeUpdate();
             
             ps.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de compras");
         }
         
         return listaCompras;
     }
  
     public List<Compra> consultarCompra(Pasajero pasajero, int mes){
            List <Compra> listaComprasDelMes = new ArrayList<> ();//Se crea la lista vacia para guardar las compras del mes
         try {
             String sql = "SELECT * FROM compra WHERE dni_pasajero ="+" "+pasajero.getDni()+";";

             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             Compra compra;
             while(rs.next()){
                 Compra unacompra= new Compra();
                 unacompra.setFechaReserva(rs.getDate("fecha_reserva"));
                 unacompra.setPasajero(pasajero);
             }
             ps.executeUpdate();
             
             ps.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de compras");
         }
         
         return listaComprasDelMes;
     }
    
     public List<Compra> consultarCompra(Pasajero pasajero, Data FechaInicio, Data fechaFinal){
            List <Compra> listaComprasDeUnaFecha = new ArrayList<> ();//Se crea la lista vacia para guardar las compras de una fecha ha otra
         try {
             String sql = "SELECT * FROM compra WHERE dni_pasajero ="+" "+pasajero.getDni()+";";

             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             Compra compra;
             while(rs.next()){
                 Compra unacompra= new Compra();
                 unacompra.setFechaReserva(rs.getDate("fecha_reserva"));
                 unacompra.setPasajero(pasajero);
             }
             ps.executeUpdate();
             
             ps.close();
         } catch (SQLException ex) {
             System.out.println("Error al obtener la lista de compras");
         }
         
         return listaComprasDeUnaFecha;
   }


  }

