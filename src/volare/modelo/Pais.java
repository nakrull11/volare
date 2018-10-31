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
public class Pais {
    private int id= -1;
    private String codigo;
    private String nombre;

    public Pais(String codigo, String nombre) {
        id = -1;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return id+"-"+nombre;
    }
    public Pais(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
}
