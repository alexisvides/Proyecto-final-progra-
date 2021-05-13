/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.USUARIO;


/**
 *
 * @author Joseph
 */
public interface CrudUsuario {
    public List listar();
    public USUARIO list (int id);
    public boolean insertar(USUARIO usuario);
    public boolean modificar(USUARIO usuario);
    public boolean eliminar(USUARIO usuario);
    public List busqueda(String parametro, String opcion);
}
