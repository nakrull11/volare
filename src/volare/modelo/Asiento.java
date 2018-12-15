/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;


/**
 *
 * @author gustavo
 */
public class Asiento {
    private int id;
    private String numero;
    private boolean pasillo;
    private boolean estado;
    private Avion idAvion;

    public Asiento(String numero, boolean pasillo, boolean estado, Avion idAvion) {
        this.numero = numero;
        this.pasillo = pasillo;
        this.estado = estado;
        this.idAvion = idAvion;
    }
    
    public Asiento(){
    }
    
    @Override
    public String toString(){
        return "\n"+"Id Asiento: "+id+"\n"+"Numero Asiento: "+numero+"\n"+"Sobre el pasillo? :"+pasillo+"\n"+"Libre? :"+estado+"\n"+"Avion :"+idAvion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isPasillo() {
        return pasillo;
    }

    public void setPasillo(boolean pasillo) {
        this.pasillo = pasillo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Avion getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Avion idAvion) {
        this.idAvion = idAvion;
    }
    
    
    
    
    
}
