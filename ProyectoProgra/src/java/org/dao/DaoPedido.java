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
import org.models.Pedido;
import org.interfaces.CrudPedido;

/**
 *
 * @author Joseph
 */
public class DaoPedido implements CrudPedido{
    
    //Se crea un objeto publico del Cliente
    Pedido pedido = new Pedido();
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
         ArrayList<Pedido> lstPedido = new ArrayList<>();
         try {            
            strSql =    "SELECT * FROM PEDIDO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdCliente(rs.getInt("ID_CLIENTE"));                
                pedido.setIdDepartamento(rs.getInt("ID_DEPARTAMENTO"));
                pedido.setIdMunicipio(rs.getInt("ID_MUNICIPIO"));
                pedido.setIdPedido(rs.getInt("ID_PEDIDO"));
                pedido.setEstado(rs.getInt("ESTADO"));
                pedido.setObservacion(rs.getString("OBSERVACION"));
                pedido.setTotal(rs.getInt("TOTAL"));
                pedido.setTotal_usd(rs.getInt("TOTAL_USD"));
                lstPedido.add(pedido);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPedido;
    }

    @Override
    public Pedido list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Pedido pedido) {
        strSql =    "SELECT * FROM PRODUCTO";
       
        strSql = "INSERT INTO PEDIDO (ID_PEDIDO, ID_CLIENTE,OBSERBACION, ID_DEPARTAMENTO, ID_MUNICIPIO, ID_ESTADO, TOTAL,TOTAL_USD) "
                + "SELECT  (SELECT ISNULL(MAX(ID_PEDIDO),0) + 1 FROM PEDIDO), " +                 
                      
                 "" + pedido.getIdCliente()+ ", " +
                "'" + pedido.getObservacion()+ "', " +
                "" + pedido.getIdDepartamento()+ ", " +
                "" + pedido.getIdMunicipio()+ ","
                + ""+pedido.getTotal()+","
                + ""+pedido.getTotal_usd()+""
                + "WHERE NOT EXISTS(SELECT 1 FROM PEDIDO WHERE NIT = " + pedido.getIdPedido()+ ");";


        strSql = "INSERT INTO PEDIDO_DETALLE (ID_PEDIDO, ID_CLIENTE,OBSERBACION, ID_DEPARTAMENTO, ID_MUNICIPIO, ID_ESTADO, TOTAL,TOTAL_USD) "
                + "SELECT  (SELECT ISNULL(MAX(ID_PEDIDO),0) + 1 FROM PEDIDO), " +                 
                "" +pedido.getIdPedido()+ ", " +       
                 "" + pedido.getIdCliente()+ ", " +
                "'" + pedido.getObservacion()+ "', " +
                "" + pedido.getIdDepartamento()+ ", " +
                "" + pedido.getIdMunicipio()+ ","
                + ""+pedido.getTotal()+","
                + ""+pedido.getTotal_usd()+""
                + "WHERE NOT EXISTS(SELECT 1 FROM PEDIDO WHERE NIT = " + pedido.getIdPedido()+ ");";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public boolean modificar(Pedido pedido) {
        //strSql = "UPDATE  CLIENTE SET NOMBRE='" +pedido.getNombre()+ "', "+
          //    " APELLIDO='" +pedido.getApellido()+ "',"+
            //   "DIRECCION='" +pedido.getDireccion()+ "' ,"+
              // "TELEFONO='" +pedido.getTelefono()+ "' WHERE NIT='" +pedido.getNit()+ "'";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;



    }

    @Override
    public boolean eliminar(Pedido pedido) {
        
        strSql = "DELETE FROM  PEDIDO WHERE ID_PEDIDO='" +pedido.getIdPedido()+ "'";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPedido.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
