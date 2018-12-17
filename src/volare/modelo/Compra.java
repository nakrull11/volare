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
    private String estado;
    
    
    @Override
    public String toString(){
        return  fechaReserva+" "+vuelo+" "+pasajero+" "+asiento+" "+estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    
    public String getEstado(){
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

}
