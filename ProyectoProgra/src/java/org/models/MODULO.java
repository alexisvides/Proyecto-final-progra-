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
public class MODULO {
   public int ID_MODULO;
public String NOMBRE;
public String DESCRIPCION;
public String PATH;
public int NIVEL;
public int ORDEN; 
public int ID_MODULO_PADRE;
public int ACTIVO;
public String USUARIO_CREA;
public String USUARIO_MOD;
public String FECHA_CREA;
public String FECHA_MOD;

    public MODULO() {
    }

    public int getID_MODULO() {
        return ID_MODULO;
    }

    public void setID_MODULO(int ID_MODULO) {
        this.ID_MODULO = ID_MODULO;
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

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public int getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(int NIVEL) {
        this.NIVEL = NIVEL;
    }

    public int getORDEN() {
        return ORDEN;
    }

    public void setORDEN(int ORDEN) {
        this.ORDEN = ORDEN;
    }

    public int getID_MODULO_PADRE() {
        return ID_MODULO_PADRE;
    }

    public void setID_MODULO_PADRE(int ID_MODULO_PADRE) {
        this.ID_MODULO_PADRE = ID_MODULO_PADRE;
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
