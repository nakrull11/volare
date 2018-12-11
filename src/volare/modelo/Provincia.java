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
public class Provincia {
    private int id;
    private Pais pais;
    private String nombre;

    public Provincia( Pais pais, String nombre) {
        this.id = -1;
        this.pais = pais;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return pais+" "+nombre;
    }
    
    public Provincia(){
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
