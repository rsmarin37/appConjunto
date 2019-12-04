/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sm
 */
public class Propietario {
    private int idpropietarioCC;
    private String nombre;
    private String apellido;
    private String telefono;
    private String celular;

    public int getIdpropietarioCC() {
        return idpropietarioCC;
    }

    public void setIdpropietarioCC(int idpropietarioCC) {
        this.idpropietarioCC = idpropietarioCC;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
