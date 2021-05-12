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
public class USUARIO {
public int ID_USUARIO;
public String NOMBRE;
public String APELLIDO;
public String USUARIO;
public String PASSWORD;
public int ID_ROL;
public int ACTIVO;
public String FECHA_CREA;
public String FECHA_MOD; 
public String USUARIO_CREA;
public String USUARIO_MOD;
public int CODIGO;

    public USUARIO() {
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
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

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    



}
