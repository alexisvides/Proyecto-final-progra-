/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.MODULO;

/**
 *
 * @author Joseph
 */
public interface CrudModulo {
    public List listar();
    public MODULO list (int id);
    public boolean insertar(MODULO modulo);
    public boolean modificar(MODULO modulo);
    public boolean eliminar(MODULO modulo);
    public List busqueda(String parametro, String opcion);
    
}
