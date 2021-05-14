package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.MODULO;
import org.interfaces.CrudModulo;

public class DaoModulo implements CrudModulo{
    
    MODULO mod = new MODULO();
    String strSql =  "";
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    boolean respuesta = false;

    @Override
    public List listar() {
         ArrayList<MODULO> lstModulo = new ArrayList<>();
         try {            
            strSql = "SELECT * MODULO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                MODULO mod = new MODULO();
                mod.setID_MODULO(rs.getInt("ID_MODULO"));                
                mod.setNOMBRE(rs.getString("NOMBRE"));
                mod.setDESCRIPCION(rs.getString("DESCRIPCION"));
                mod.setPATH(rs.getString("PATH"));
                mod.setNIVEL(rs.getInt("NIVEL"));
                mod.setORDEN(rs.getInt("ORDEN"));
                mod.setID_MODULO_PADRE(rs.getInt("ID_MODULO_PADRE"));
                mod.setACTIVO(rs.getInt("ACTIVO"));
                mod.setUSUARIO_CREA(rs.getString("USUARIO_CREA"));
                mod.setUSUARIO_MOD(rs.getString("USUARIO_MOD"));
                mod.setFECHA_CREA(rs.getString("FECHA_CREA"));
                mod.setFECHA_MOD(rs.getString("FECHA_MOD"));
                                
                lstModulo.add(mod);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstModulo;
    }

    @Override
    public MODULO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(MODULO modulo) {
        strSql = "INSERT INTO MODULO (ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ORDEN, ID_MODULO_PADRE, ACTIVO, "
                + "USUARIO_CREA, USUARIO_MOD, FECHA_CREA, FECHA_MOD) VALUES("
                + "SELECT  (SELECT ISNULL(MAX(ID_MODULO),0) + 1 FROM MODULO), " +
                "'" + modulo.getNOMBRE()+ "', " +
                "'" + modulo.getDESCRIPCION()+ "', " +
                "'" + modulo.getPATH()+ "', " +
                "" + modulo.getNIVEL()+ ", " +
                "" + modulo.getORDEN()+ ", " +
                "" + modulo.getID_MODULO_PADRE()+ ", " + 
                "" + modulo.getACTIVO()+ ", " +
                "'" + modulo.getUSUARIO_CREA()+ "', " +
                "'" + modulo.getUSUARIO_MOD()+ "', " +
                "'" + modulo.getFECHA_CREA()+ "', " +
                "'" + modulo.getFECHA_MOD()+ "' )";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public boolean modificar(MODULO modulo) {
        strSql = "UPDATE  CLIENTE SET NOMBRE = '" +modulo.getNOMBRE()+ "', "+
                 "DESCRIPCION = '" + modulo.getDESCRIPCION()+ "', "+
                 "PATH = '" + modulo.getPATH()+ "' , " +
                 "NIVEL = " + modulo.getNIVEL()+ ", " +
                 "ORDEN = " + modulo.getORDEN()+ ", " +
                 "ID_MODULO_PADRE = " + modulo.getID_MODULO_PADRE()+ ", " +
                 "ACTIVO = " + modulo.getACTIVO()+ ", " +
                 "USUARIO_CREA = '" + modulo.getUSUARIO_CREA()+ "', "+
                 "USUARIO_MOD = '" + modulo.getUSUARIO_MOD()+ "', "+
                 "FECHA_CREA = '" + modulo.getFECHA_CREA()+ "', "+
                 "FECHA_MOD = '" + modulo.getDESCRIPCION()+ "', "+
                 "WHERE ID_MODULO = " + modulo.getID_MODULO()+ "";
        
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;



    }

    @Override
    public boolean eliminar(MODULO modulo) {
        
        strSql = "DELETE FROM MODULO WHERE ID_MODULO = " + modulo.getID_MODULO() + "";
        
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return respuesta;
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
