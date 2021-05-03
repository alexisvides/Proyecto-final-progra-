/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Persona;


/**
 *
 * @author Joseph
 */
public interface CrudPersona {
    public List listar();
    public Persona list (int id);
    public boolean insertar(Persona persona);
    public boolean modificar(Persona persona);
    public boolean eliminar(Persona persona);
    public List busqueda(String parametro, String opcion);
}
