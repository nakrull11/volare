/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Alumno
 */
public class Pasajero {
   private int pasaporte;
   private int dni;
    private String correoElectronico;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int numeroTarjeta;
    private String password;
    
public Pasajero(int pasaporte, int dni, String correoElectronico, String nombre, String apellido, LocalDate fechaNacimiento, int numeroTarjeta, String password) {
        this.pasaporte = pasaporte;
        this.dni=dni;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido= apellido;
        this.numeroTarjeta= numeroTarjeta;
        this.password= password;
}

    public Pasajero() {
        
    }

   @Override
   public String toString(){
        return "pasaporte: "+pasaporte+"\n"+"dni: "+dni+"\n"+"correo electronico: "+correoElectronico+"\n"+"nombre: "+nombre+"\n"+"apellido: "+apellido+"\n"+"fecha de nacimiento: "+fechaNacimiento+" "+"numero de tarjeta :"+
                numeroTarjeta+"\n "+"password: "+
                password;
    }

public int getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(int pasaporte) {
        this.pasaporte = pasaporte;
    }
    
     public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
  public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  public void modificarCompra (Compra compraHecha) {
      compraHecha.setId(-1);
      compraHecha.setFechaReserva(null);
      compraHecha.setPasajero(null);
      compraHecha.setNumeroAsiento(null);
  }  

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
  

