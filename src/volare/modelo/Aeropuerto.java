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
public class Aeropuerto {
    private int id;
    private String codigo;
    private Ciudad ciudad;

    public Aeropuerto( String codigo, Ciudad ciudad) {
        this.id = -1;
        this.codigo = codigo;
        this.ciudad = ciudad;
    }
    
    public Aeropuerto(){
        
    }
    
    @Override
    public String toString(){
        return id+"-"+codigo+"-"+ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
