/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.PERMISO;

/**
 *
 * @author Joseph
 */
public interface CrudPermiso {    
    public List listar();
    public PERMISO list (int id);
//    public boolean insertar(Producto producto);
//    public boolean modificar(Producto producto);
//    public boolean eliminar(Producto producto);
//    public List busqueda(String parametro, String opcion);
    
}
