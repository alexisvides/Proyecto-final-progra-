/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.Persona;
import org.interfaces.CrudPersona;

/**
 *
 * @author Joseph
 */
public class DaoPersona implements CrudPersona{
    
    //Se crea un objeto publico del Cliente
    Persona persona = new Persona();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public List listar() {
         ArrayList<Persona> lstPersona = new ArrayList<>();
         try {            
            strSql =    "SELECT * FROM CLIENTE";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdPersona(rs.getInt("ID_CLIENTE"));                
                per.setNombre(rs.getString("NOMBRE"));
                per.setApellido(rs.getString("APELLIDO"));
                per.setNit(rs.getString("NIT"));
                per.setTelefono(rs.getString("TELEFONO"));
                per.setDireccion(rs.getString("DIRECCION"));
                lstPersona.add(per);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPersona;
    }

    @Override
    public Persona list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Persona persona) {
       
        strSql = "INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO) "
                + "SELECT  (SELECT ISNULL(MAX(ID_CLIENTE),0) + 1 FROM CLIENTE), " +                 
                "'" +persona.getNombre()+ "', " +       
                 "'" + persona.getApellido()+ "', " +
                "'" + persona.getNit()+ "', " +
                "'" + persona.getDireccion()+ "', " +
                "'" + persona.getTelefono()+ "'"
                + "WHERE NOT EXISTS(SELECT 1 FROM CLIENTE WHERE NIT = '" + persona.getNit()+ "');";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public boolean modificar(Persona persona) {
        strSql = "UPDATE  CLIENTE SET NOMBRE='" +persona.getNombre()+ "', "+
              " APELLIDO='" +persona.getApellido()+ "',"+
               "DIRECCION='" +persona.getDireccion()+ "' ,"+
               "TELEFONO='" +persona.getTelefono()+ "' WHERE NIT='" +persona.getNit()+ "'";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;



    }

    @Override
    public boolean eliminar(Persona persona) {
        
        strSql = "DELETE FROM  CLIENTE WHERE NIT='" +persona.getNit()+ "'";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
