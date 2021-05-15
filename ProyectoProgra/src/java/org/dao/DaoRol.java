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
import org.interfaces.CrudRol;
import org.models.ROL;

/**
 *
 * @author Joseph
 */
public class DaoRol implements CrudRol{
    
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
         ArrayList<ROL> lstRol = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM ROL";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ROL rol = new ROL();
                rol.setID_ROL(rs.getInt("ID_ROL"));
                rol.setNOMBRE(rs.getString("NOMBRE"));
                rol.setDESCRIPCION(rs.getString("DESCRIPCION"));
                rol.setUSUARIO_CREA(rs.getString("USUARIO_CREA"));
                rol.setUSUARIO_MOD(rs.getString("USUARIO_MOD"));
                lstRol.add(rol);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstRol;
    }

    @Override
    public ROL list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insertar(ROL rol) {
       
        strSql = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION, USUARIO_CREA, USUARIO_MOD) VALUES ("
                + "(SELECT ISNULL(MAX(ID_ROL),0) + 1 FROM ROL), " +                 
                "'" + rol.getNOMBRE()+ "', " +       
                "'" + rol.getDESCRIPCION()+ "', " +
                "'" + rol.getUSUARIO_CREA()+ "', " +
                "'" + rol.getUSUARIO_MOD()+ "' )";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }
    
    @Override
    public boolean modificar(ROL rol) {
        strSql = "UPDATE  ROL SET NOMBRE = '" + rol.getNOMBRE()+ "', "
                + "DESCRIPCION = '" + rol.getDESCRIPCION()+ "', "
                + "USUARIO_CREA = '" + rol.getUSUARIO_CREA()+ "', "
                + "USUARIO_MOD = '" + rol.getUSUARIO_MOD()+ "', "
                + "WHERE ID_ROL = " + rol.getID_ROL()+ "";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;

    }

    @Override
    public boolean eliminar(ROL rol) {

        strSql = "DELETE FROM ROL WHERE ID_ROL = " + rol.getID_ROL()+ "";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}

