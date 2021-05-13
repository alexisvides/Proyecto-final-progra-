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
    
    //Se crea un objeto publico del Cliente
    ROL rol = new ROL();
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
            strSql =    "SELECT * FROM MUNICIPIO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ROL rol = new ROL();
                rol.setID_ROL(rs.getInt("ID_ROL"));
                rol.setNOMBRE(rs.getString("NOMBRE"));
                rol.setDESCRIPCION(rs.getString("DESCRIPCION"));
                rol.setACTIVO(rs.getInt("ACTIVO"));
                rol.setUSUARIO_CREA(rs.getString("USUARIO_CREA"));
                rol.setUSUARIO_MOD(rs.getString("USUARIO_MOD"));
                rol.setFECHA_CREA(rs.getString("FECHA_CREA"));
                rol.setFECHA_MOD(rs.getString("FECHA_MOD"));                
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
//
//    @Override
//    public boolean insertar(Municipio editorial) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean modificar(Municipio editorial) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean eliminar(Municipio editorial) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List busqueda(String parametro, String opcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

