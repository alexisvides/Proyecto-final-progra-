package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Config.*;
import Modelo.Cliente;
import Intefaces.CrudCliente;

public class DaoCliente implements CrudCliente{
    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();
    Cliente c1 = new Cliente();
    
    String strSql =  "";
    String bitacora =  "";
    
    boolean respuesta = false;

    @Override
    public List listar() {
        ArrayList<Cliente>lstCliente = new ArrayList<>();
        
        strSql = "SELECT * FROM CLIENTE";
        try {   
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                Cliente clie = new Cliente();
                clie.setIdCliente(rs.getInt("ID_CLIENTE"));
                clie.setNombre(rs.getString("NOMBRE"));
                clie.setApellido(rs.getString("APELLIDO"));
                clie.setNit(rs.getString("NIT"));
                clie.setTelefono(rs.getString("TELEFONO"));
                clie.setDireccion(rs.getString("DIRECCION"));

                lstCliente.add(clie);
            }
            rs.close();
            conexion.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return lstCliente;
    }
    
    @Override
    public Cliente list(int id) {
        strSql = "SELECT * FROM CLIENTE " +
                     "WHERE ID_CLIENTE = " + id;
        
        try {            
            conexion.open();
            rs = conexion.executeQuery(strSql);                               
            
            while (rs.next()) {
                c.setIdCliente(rs.getInt("ID_CLIENTE"));
                c.setNombre(rs.getString("NOMBRE"));
                c.setApellido(rs.getString("APELLIDO"));
                c.setNit(rs.getString("NIT"));
                c.setTelefono(rs.getString("TELEFONO"));
                c.setDireccion(rs.getString("DIRECCION"));
            }
            rs.close();
            conexion.close();
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return c; 
    }
    
    @Override
    public Cliente buscar(int nit) {
        strSql = "SELECT * FROM CLIENTE" +
                 " WHERE NIT = '" + nit + "'";
        
        try {            
            conexion.open();
            rs = conexion.executeQuery(strSql);                               
            
            while (rs.next()) {
                c.setIdCliente(rs.getInt("ID_CLIENTE"));
                c.setNombre(rs.getString("NOMBRE"));
                c.setApellido(rs.getString("APELLIDO"));
                c.setNit(rs.getString("NIT"));
                c.setTelefono(rs.getString("TELEFONO"));
                c.setDireccion(rs.getString("DIRECCION"));
            }
            rs.close();
            conexion.close();
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return c; 
    }

    @Override
    public boolean add(Cliente cliente) {
        strSql = "INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, APELLIDO, NIT, TELEFONO, DIRECCION) "
               + "VALUES ((SELECT ISNULL(MAX(ID_CLIENTE),0) + 1 FROM CLIENTE), " +                 
                "'" + cliente.getNombre()+ "', " + 
                "'" + cliente.getApellido()+ "', " + 
                "'" + cliente.getNit()+ "', " +
                "'" + cliente.getTelefono()+ "', " +
                "'" + cliente.getDireccion()+ "')";       
               
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();
             
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean edit(Cliente cliente) {
        try {
            strSql = "UPDATE EMPLEADO" +
                    " SET NOMBRE = '" + cliente.getNombre()+ "'," +
                    " APELLIDO = '" + cliente.getApellido()+ "'," +
                    " NIT = '" + cliente.getNit()+ "'," +
                    " TELEFONO = '" + cliente.getTelefono()+ "'," +
                    " DIRECCION = '" + cliente.getDireccion()+ "'" +
                  " WHERE ID_CLIENTE = " + cliente.getIdCliente()+"";
            
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();      
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        strSql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = " + id;
        
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();         
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }
}
