/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.util.Date;

/**
 *
 * @author francisco
 */
public class Vuelo {

    private int id;
    private float precio;
    private Date fechaSalida;
    private Date fechaLlegada;
    private boolean refuerzo;
    private Aeropuerto aeropuertoSalida;
    private Aeropuerto aeropuertoLlegada;
    private Estado estado;
    private Avion avion;
    private Aerolinea cuitAerolinea;

    public Aerolinea getCuitAerolinea() {
        return cuitAerolinea;
    }

    public void setCuitAerolinea(Aerolinea cuitAerolinea) {
        this.cuitAerolinea = cuitAerolinea;
    }

    public String toString(){
        return id+"-"+precio+"-"+fechaSalida+"-"+fechaLlegada+"-"+refuerzo+"-"+aeropuertoSalida+"-"+aeropuertoLlegada+"-"+estado+"-"+avion+"-"+cuitAerolinea;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public boolean isRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(boolean refuerzo) {
        this.refuerzo = refuerzo;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
