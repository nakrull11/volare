package volare.modelo;

import java.util.Date;

/**
 *
 * @author francisco
 */
public class Compra {

    private int id;
    private Date fechaReserva;
    private Vuelo vuelo;
    private Pasajero pasajero;
    private Asiento asiento;
    private float precio;
    private Estado estado;
    
    
    @Override
    public String toString(){
        return  fechaReserva+" "+vuelo+" "+pasajero+" "+asiento+" "+precio+" "+estado;
    }
    public void setEstado(Estado estado){
        this.estado=estado;
    }
    
    public Estado getEstado(){
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setNumeroAsiento(Asiento numeroAsiento) {
        this.asiento = numeroAsiento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
