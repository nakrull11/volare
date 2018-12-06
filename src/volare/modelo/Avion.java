/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Avion {
    private int id;
    private String modelo;
    private ArrayList<Asiento>asiento;
    private Aerolinea cuitAerolinea;

    public Avion( String modelo, ArrayList<Asiento> asiento, Aerolinea cuitAerolinea) {
        this.id = -1;
        this.modelo = modelo;
        this.asiento = asiento;
        this.cuitAerolinea = cuitAerolinea;
    }
    
    public Avion (){
        
    }
    
    @Override
    public String toString(){
        return id+"-"+modelo+"-"+asiento+"-"+cuitAerolinea;
    }
    
    public void agregarAsiento(Asiento asiento){
        this.asiento.add(asiento);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ArrayList<Asiento> getAsiento() {
        return asiento;
    }

    public void setAsiento(ArrayList<Asiento> asiento) {
        this.asiento = asiento;
    }

    public Aerolinea getCuitAerolinea() {
        return cuitAerolinea;
    }

    public void setCuitAerolinea(Aerolinea cuitAerolinea) {
        this.cuitAerolinea = cuitAerolinea;
    }
    
    
    
}
