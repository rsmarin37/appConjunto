
import control.Conexion;
import control.ConsultasDB;
import vista.PPal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sm
 */
public class Main {
    public static void main(String[] args) {
        new PPal().setVisible(true);    
        Conexion con = new Conexion();
        con.getConnection();
    }
    
}
