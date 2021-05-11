/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author jonmi
 */
public class PERMISO {
   public int ID_PERMISO;
public int ID_MODULO;
public int ID_ROL;
public int ACTIVO;
public String USUARIO_CREA;
public String USUARIO_MOD;
public String FECHA_CREA;
public String FECHA_MOD;

    public PERMISO() {
    }

    public int getID_PERMISO() {
        return ID_PERMISO;
    }

    public void setID_PERMISO(int ID_PERMISO) {
        this.ID_PERMISO = ID_PERMISO;
    }

    public int getID_MODULO() {
        return ID_MODULO;
    }

    public void setID_MODULO(int ID_MODULO) {
        this.ID_MODULO = ID_MODULO;
    }

    public int getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(int ID_ROL) {
        this.ID_ROL = ID_ROL;
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

    public String getFECHA_CREA() {
        return FECHA_CREA;
    }

    public void setFECHA_CREA(String FECHA_CREA) {
        this.FECHA_CREA = FECHA_CREA;
    }

    public String getFECHA_MOD() {
        return FECHA_MOD;
    }

    public void setFECHA_MOD(String FECHA_MOD) {
        this.FECHA_MOD = FECHA_MOD;
    }


}
