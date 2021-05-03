/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Pedido;

/**
 *
 * @author Joseph
 */
public interface CrudPedido {
    public List listar();
    public Pedido list (int id);
    public boolean insertar(Pedido editorial);
    public boolean modificar(Pedido editorial);
    public boolean eliminar(Pedido editorial);
    public List busqueda(String parametro, String opcion);
    
}
