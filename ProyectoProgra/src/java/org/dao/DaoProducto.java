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
import org.models.Producto;
import org.interfaces.CrudProducto;

/**
 *
 * @author Joseph
 */
public class DaoProducto implements CrudProducto {

    //Se crea un objeto publico del Cliente
    Producto producto = new Producto();
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
        ArrayList<Producto> lstProducto = new ArrayList<>();
        try {
            strSql = "SELECT * FROM PRODUCTO";
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt("ID_PRODUCTO"));
                pro.setPrecio(rs.getFloat("PRECIO"));
                pro.setEstado(rs.getInt("ESTADO"));
                pro.setExistencia(rs.getInt("EXISTENCIA"));
                pro.setDescripcion(rs.getString("DESCRIPCION"));
                lstProducto.add(pro);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstProducto;
    }

    @Override
    public Producto list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Producto producto) {
        int estado1, estado2;
        estado1= producto.getExistencia();
        if(estado1 >0){
            estado2 = 1;
        }else{
            estado2=0;
        }

        strSql = "INSERT INTO PRODUCTO (ID_PRODUCTO, DESCRIPCION, PRECIO, EXISTENCIA, ESTADO) "
                + "SELECT  (SELECT ISNULL(MAX(ID_PRODUCTO),0) + 1 FROM PRODUCTO), "
                + "'" + producto.getDescripcion() + "', "
                + "" + producto.getPrecio() + ", "
                + "" + producto.getExistencia() + ", "
                + "" + estado2 + " "
                + "WHERE NOT EXISTS(SELECT 1 FROM PRODUCTO WHERE DESCRIPCION = '" + producto.getDescripcion() + "');";

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
        } catch (Exception ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }

    /**
     *
     * @param producto
     * @return
     */
    @Override
    public boolean modificar(Producto producto) {
        int estado1, estado2;
        estado1= producto.getExistencia();
        if(estado1 >0){
            estado2 = 1;
        }else{
            estado2=0;
        }
        strSql = "UPDATE  PRODUCTO SET DESCRIPCION='" + producto.getDescripcion() + "', "
                + " PRECIO=" + producto.getPrecio() + ","
                + "EXISTENCIA=" + producto.getExistencia() + " ,"
                + "ESTADO=" + estado2 + " WHERE ID_PRODUCTO =" + producto.getIdProducto() + "";

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
        } catch (Exception ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;

    }

    @Override
    public boolean eliminar(Producto producto) {

        strSql = "DELETE FROM  PRODUCTO WHERE ID_PRODUCTO=" + producto.getIdProducto() + "";

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
        } catch (Exception ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }

    /**
     *
     * @param parametro
     * @param opcion
     * @return
     */
    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
