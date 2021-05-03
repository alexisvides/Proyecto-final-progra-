<%-- 
    Document   : personaModificacion
    Created on : 23/04/2021, 01:21:59 PM
    Author     : vides
--%>


<%@page import="org.models.Producto"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoProducto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Libro</title>
    </head>
    <body>

        <%
             DaoProducto daoProducto = new  DaoProducto();
                        List<Producto> lstProducto = daoProducto.listar();
                        Iterator<Producto> iteratorProducto = lstProducto.iterator();
                        Producto producto = null;



        %>
        
            <h1>Modificación Producto</h1>
            <br/>
            <form id="form-work" class="" name="form-work" action="ControllerProducto" method="get">               
                <div >
                        <label for ="id" class="control-label" >Selecciones el id del producto</label>
                        <select name="id" id="id" class="form-control" >
                            <% while (iteratorProducto.hasNext()){
                                producto = iteratorProducto.next();  %> 
                             <option value=<%= producto.getIdProducto()%>><%= producto.getDescripcion()%></option>
                            <%}%>
                        </select>  
                        <label class="control-label" for ="descripcion">Nueva Descripcion</label>
                        <input name="descripcion" class="form-control" placeholder="descripcion" type="text">
                   
                        <label for ="precio" class="control-label">Precio</label>
                        <input name="precio" placeholder="precio" type="text" class="form-control">
                   
                       <label for ="existencia" class="control-label" >Existencia</label>
                         <input  name="existencia" class="form-control" placeholder="existencia" type="text">

                        <button id="accion" name="accion" value="modificar" class="btn btn-success btn-lg btn-block info" type="submit">Modificar</button>                    
                   
                </div>
                 
            </form>
        
        
    </body>
</html>
