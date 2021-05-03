/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.Departamento;

/**
 *
 * @author vides
 */
public interface CrudDepartamento {
      public List listar();
    public Departamento list (int id);
    public boolean insertar(Departamento editorial);
    public boolean modificar(Departamento editorial);
    public boolean eliminar(Departamento editorial);
    public List busqueda(String parametro, String opcion);
}
