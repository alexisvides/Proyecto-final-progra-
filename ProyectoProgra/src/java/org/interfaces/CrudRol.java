/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ROL;

/**
 *
 * @author vides
 */
public interface CrudRol {
   public List listar();
   public ROL list (int id);
//    public boolean insertar(Municipio editorial);
//    public boolean modificar(Municipio editorial);
//    public boolean eliminar(Municipio editorial);
//    public List busqueda(String parametro, String opcion);   
}
