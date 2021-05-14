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
import org.models.USUARIO;
import org.interfaces.CrudUsuario;

/**
 *
 * @author Joseph
 */
public class DaoUsuario implements CrudUsuario{
    
    //Se crea un objeto publico del Cliente
    USUARIO persona = new USUARIO();
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
         ArrayList<USUARIO> lstUsuario = new ArrayList<>();
         try {            
            strSql =    "SELECT * FROM USUARIO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                USUARIO usua = new USUARIO();
                usua.setID_USUARIO(rs.getInt("ID_USUARIO"));                
                usua.setNOMBRE(rs.getString("NOMBRE"));
                usua.setAPELLIDO(rs.getString("APELLIDO"));
                usua.setUSUARIO(rs.getString("USUARIO"));
                usua.setPASSWORD(rs.getString("PASSWORD"));
                usua.setID_ROL(rs.getInt("ID_ROL"));
                usua.setACTIVO(rs.getInt("ACTIVO"));
                usua.setFECHA_CREA(rs.getString("FECHA_CREA"));
                usua.setFECHA_MOD(rs.getString("FECHA_MOD"));
                usua.setUSUARIO_CREA(rs.getString("USUARIO_CREA"));
                usua.setUSUARIO_MOD(rs.getString("USUARIO_MOD"));
                usua.setCODIGO(rs.getInt("CODIGO"));
                lstUsuario.add(usua);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstUsuario;
    }

    @Override
    public USUARIO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(USUARIO user) {
       
        strSql = "INSERT INTO USUARIO (ID_USUARIO, NOMBRE, APELLIDO, USUARIO, PASSWORD, ID_ROL, ACTIVO, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, CODIGO) VALUES ("
                + "SELECT  (SELECT ISNULL(MAX(ID_USUARIO),0) + 1 FROM USUARIO), " +                 
                "'" + user.getNOMBRE()+ "', " +       
                 "'" + user.getAPELLIDO()+ "', " +
                "'" + user.getUSUARIO()+ "', " +
                "'" + user.getPASSWORD()+ "', " +
                "'" + user.getID_ROL()+ "'" + 
                "'" + user.getACTIVO()+ "'" + 
                "'" + user.getFECHA_CREA()+ "', " +
                "'" + user.getFECHA_MOD()+ "', " +
                "'" + user.getUSUARIO_CREA()+ "', " +
                "'" + user.getUSUARIO_MOD()+ "', " +
                "'" + user.getCODIGO()+ "')";
        
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
    public boolean modificar(USUARIO user) {
        strSql = "UPDATE USUARIO SET NOMBRE = '" + user.getNOMBRE()+ "', " +
               "APELLIDO = '" + user.getAPELLIDO()+ "',"+
               "USUARIO = '" + user.getUSUARIO()+ "' ,"+
               "PASSWORD = '" + user.getPASSWORD() + "' " + 
               "ID_ROL = " + user.getPASSWORD() + " " + 
               "ID_ROL = " + user.getID_ROL()+ " " + 
               "ACTIVO = '" + user.getFECHA_CREA()+ "' " + 
               "FECHA_MOD = '" + user.getFECHA_MOD()+ "' " + 
               "USUARIO_CREA = '" + user.getUSUARIO_CREA()+ "' " + 
               "USUARIO_MOD = '" + user.getUSUARIO_MOD()+ "' " + 
               "CODIGO = " + user.getCODIGO()+ " "
               + "WHERE ID_USUARIO = '" + user.getID_USUARIO()+ "'";
        
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
    public boolean eliminar(USUARIO user) {
        
        strSql = "DELETE FROM USUARIO WHERE ID_USUARIO = '" + user.getID_USUARIO()+ "'";
        
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
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}