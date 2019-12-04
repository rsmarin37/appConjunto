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
public class Casa {
    private int idcasa;
    private String numero;
    private int propietario_id;

    public int getIdcasa() {
        return idcasa;
    }

    public void setIdcasa(int idcasa) {
        this.idcasa = idcasa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public void setPropietario_id(int propietario_id) {
        this.propietario_id = propietario_id;
    }
    
    
}
