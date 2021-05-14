/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;
import java.sql.Date;
/**
 *
 * @author jonmi
 */
public class ROL {
public int ID_ROL;
public String NOMBRE;
public String DESCRIPCION;
public int ACTIVO;
public String USUARIO_CREA;
public String USUARIO_MOD;
public Date FECHA_CREA;
public Date FECHA_MOD;

    public ROL() {
    }

    public int getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(int ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getACTIVO() {
        return ACTIVO;
    }

    public void setACTIVO(int ACTIVO) {
        this.ACTIVO = ACTIVO;
    }

    public String getUSUARIO_CREA() {
        return USUARIO_CREA;
    }

    public void setUSUARIO_CREA(String USUARIO_CREA) {
        this.USUARIO_CREA = USUARIO_CREA;
    }

    public String getUSUARIO_MOD() {
        return USUARIO_MOD;
    }

    public void setUSUARIO_MOD(String USUARIO_MOD) {
        this.USUARIO_MOD = USUARIO_MOD;
    }

    public Date getFECHA_CREA() {
        return FECHA_CREA;
    }

    public void setFECHA_CREA(Date FECHA_CREA) {
        this.FECHA_CREA = FECHA_CREA;
    }

    public Date getFECHA_MOD() {
        return FECHA_MOD;
    }

    public void setFECHA_MOD(Date FECHA_MOD) {
        this.FECHA_MOD = FECHA_MOD;
    }


}
