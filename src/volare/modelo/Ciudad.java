/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

/**
 *
 * @author ULP
 */
public class Ciudad {
    private int id;
    private String nombre;
    private Provincia provincia;

    public Ciudad( String nombre, Provincia provincia) {
        this.id = -1;
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    @Override
    public String toString(){
        
       return id+" "+nombre+" "+provincia; 
    }
    
    public Ciudad(){
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
}
