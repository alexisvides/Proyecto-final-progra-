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
import org.interfaces.CrudPermiso;
import org.models.PERMISO;

/**
 *
 * @author Joseph
 */
public class DaoPermiso implements CrudPermiso {

    //Se crea un objeto publico del Cliente
    PERMISO producto = new PERMISO();
    //Variable para crear las sentencias SQL
    String strSql = "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public List listar() {
        ArrayList<PERMISO> lstPermiso = new ArrayList<>();
        try {
            strSql = "SELECT * FROM PERMISO";
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                PERMISO perm = new PERMISO();
                perm.setID_PERMISO(rs.getInt("ID_PERMISO"));
                perm.setID_MODULO(rs.getInt("ID_MODULO"));
                perm.setID_ROL(rs.getInt("ID_ROL"));
                perm.setACTIVO(rs.getInt("ACTIVO"));
                perm.setUSUARIO_CREA(rs.getString("USUARIO_CREA"));
                perm.setUSUARIO_MOD(rs.getString("USUARIO_MOD"));
                perm.setFECHA_CREA(rs.getString("FECHA_CREA"));
                perm.setFECHA_MOD(rs.getString("FECHA_MOD"));
                lstPermiso.add(perm);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstPermiso;
    }

    @Override
    public PERMISO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(PERMISO permiso) {

        strSql = "INSERT INTO PERMISO (ID_PERMISO, ID_MODULO, ID_ROL, ACTIVO, USUARIO_CREA, USUARIO_MOD, FECHA_CREA, FECHA_MOD) VALUES("
                + "SELECT (SELECT ISNULL(MAX(ID_PERMISO),0) + 1 FROM PERMISO), "
                + "'" + permiso.getID_MODULO()+ "', "
                + "" + permiso.getID_ROL()+ ", "
                + "" + permiso.getACTIVO()+ ", "
                + "'" + permiso.getUSUARIO_CREA()+ "', "
                + "'" + permiso.getUSUARIO_MOD()+ "', "
                + "'" + permiso.getFECHA_CREA()+ "', "
                + "'" + permiso.getFECHA_MOD()+ "') ";

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
    public boolean modificar(PERMISO permiso) {
        strSql = "UPDATE  PERMISO SET ID_MODULO = " + permiso.getID_MODULO()+ ", "
                + "ID_ROL = " + permiso.getID_ROL()+ ","
                + "ACTIVO = " + permiso.getACTIVO()+ " ,"
                + "USUARIO_CREA = '" + permiso.getUSUARIO_CREA()+ "', "
                + "USUARIO_MOD = '" + permiso.getUSUARIO_MOD()+ "', "
                + "FECHA_CREA = '" + permiso.getFECHA_CREA()+ "', "
                + "FECHA_MOD = '" + permiso.getFECHA_MOD()+ "' "
                + "WHERE ID_PERMISO =" + permiso.getID_PERMISO()+ "";

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
    public boolean eliminar(PERMISO permiso) {

        strSql = "DELETE FROM PERMISO WHERE ID_PERMISO = " + permiso.getID_PERMISO()+ "";

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
//    
//    @Override
//    public List busqueda(String parametro, String opcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
