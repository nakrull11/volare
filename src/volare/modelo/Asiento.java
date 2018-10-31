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
    private int numero;
    private boolean pasillo;
    private boolean estado;
    private Avion idAvion;

    public Asiento(int numero, boolean pasillo, boolean estado, Avion idAvion) {
        this.numero = numero;
        this.pasillo = pasillo;
        this.estado = estado;
        this.idAvion = idAvion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
