package control;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Caja;
import modelo.Casa;
import modelo.Mascota;
import modelo.Propietario;

public class ConsultasDB extends Conexion{
    
    //------------------------------------------------------------
    //------------------------------------------------------------
    //----------------PROPIETARIO..............-------------------
    //------------------------------------------------------------
    //------------------------------------------------------------
    
    public boolean RegistrarPropietario(Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "insert into propietario (idpropietarioCC, nombre, apellido, telefono, celular) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdpropietarioCC());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getCelular());       
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar propietario a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarPropietario(Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "UPDATE propietario set nombre = ?, apellido = ?, telefono = ?, celular = ? where idpropietario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCelular());
            ps.setInt(5, p.getIdpropietarioCC());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el propietario a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarPropietario(Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "delete from propietario where idpropietarioCC = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdpropietarioCC());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean buscarPropietario(Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        ResultSet rs;
        
        String sql = "select * from propietario where idpropietario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdpropietarioCC());
            rs = ps.executeQuery();
            
            while(rs.next()){
                p.setIdpropietarioCC(rs.getInt("idpropietario"));
                p.setNombre((rs.getString("nombre")));
                p.setApellido((rs.getString("apellido")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    //------------------------------------------------------------
    //------------------------------------------------------------
    //----------------MASCOTA..............-------------------
    //------------------------------------------------------------
    //------------------------------------------------------------
    
    public boolean RegistrarMascota(Mascota m, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "insert into mascota (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getTipo());
            ps.setString(3, m.getFoto());
            ps.setInt(4, p.getIdpropietarioCC());       
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar mascota a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarMascota(Mascota m, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "UPDATE propietario set nombre = ?, tipo = ?, foto = ?, documento_propietario = ? where idmascota = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getTipo());
            ps.setString(3, m.getFoto());
            ps.setInt(4, p.getIdpropietarioCC());
            ps.setInt(5, m.getIdmascota());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la mascota en la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarMascota(Mascota m){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "delete from mascota where idmascota = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, m.getIdmascota());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //------------------------------------------------------------
    //------------------------------------------------------------
    //----------------.......CASA..............-------------------
    //------------------------------------------------------------
    //------------------------------------------------------------
    
    public boolean RegistrarCasa(Casa c, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "insert into casa (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumero());
            ps.setInt(2, p.getIdpropietarioCC());       
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar la casa a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean RegistrarCasa(Casa c){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "insert into casa (numero, propietario_ID) values (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumero()); 
            ps.setInt(2, c.getPropietario_id()); 
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar la casa a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarCasa(Casa c, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "UPDATE propietario set numero = ?, propietario_ID = ? where idcasa = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumero());
            ps.setInt(2, p.getIdpropietarioCC());
            ps.setInt(3, c.getIdcasa());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la mascota en la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarCasa(Casa c){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "delete from casa where idcasa = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdcasa());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean buscarCasa(Casa c){
        PreparedStatement ps;
        Connection con = getConnection();
        ResultSet rs;
        
        String sql = "select idcasa, numero, propietario_ID from casa where numero = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumero());
            rs = ps.executeQuery();
            
            if(rs.next()){
                c.setIdcasa(rs.getInt("idcasa"));
                c.setNumero((rs.getString("numero")));
                c.setPropietario_id((rs.getInt("propietario_ID")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public ArrayList<Casa> listarCasa(String cod){
        ArrayList<Casa> arrayCasa = new ArrayList<>();
        Casa c = new Casa();
        PreparedStatement ps;
        Connection con = getConnection();
        ResultSet rs;
        
        String sql = "select idcasa, numero, propietario_ID from casa";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                c.setIdcasa(rs.getInt("idcasa"));
                c.setNumero((rs.getString("numero")));
                c.setPropietario_id((rs.getInt("propietario_ID")));
                arrayCasa.add(c);
                System.out.println("--"+arrayCasa.get(i).getNumero());
                i++;
            }
            return arrayCasa;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    //------------------------------------------------------------
    //------------------------------------------------------------
    //----------------.......CAJA..............-------------------
    //------------------------------------------------------------
    //------------------------------------------------------------
    
    public boolean RegistrarCaja(Caja c, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "insert into caja (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getTipo());
            ps.setDouble(2, c.getValor());
            ps.setDate(3, (Date) c.getFecha());
            ps.setString(4, c.getConcepto());
            ps.setInt(5, p.getIdpropietarioCC());       
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar registro de caja a la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarCaja(Caja c, Propietario p){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "UPDATE propietario set tipo = ?, valor = ?, fecha = ?,concepto = ?, documento_id = ? where idcaja = ?";
        
        try {
            ps = con.prepareStatement(sql);
             ps.setString(1, c.getTipo());
            ps.setDouble(2, c.getValor());
            ps.setDate(3, (Date) c.getFecha());
            ps.setString(4, c.getConcepto());
            ps.setInt(5, p.getIdpropietarioCC()); 
            ps.setInt(6, c.getIdcaja());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la mascota en la base de datos\n"+e);
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarCaja(Caja c){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "delete from mascota where idmascota = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdcaja());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
}