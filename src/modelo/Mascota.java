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
public class Mascota {
    private int idmascota;
    private String nombre;
    private String tipo;
    private String foto;
    private int documento_propietario;

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getDocumento_propietario() {
        return documento_propietario;
    }

    public void setDocumento_propietario(int documento_propietario) {
        this.documento_propietario = documento_propietario;
    }
    
    
}
