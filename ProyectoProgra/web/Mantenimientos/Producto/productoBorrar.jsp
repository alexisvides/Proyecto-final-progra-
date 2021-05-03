
<%@page import="org.models.Producto"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoProducto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       
    </head>
    <body>

        <%
            DaoProducto daoProducto = new DaoProducto();
            List<Producto> lstProducto = daoProducto.listar();
            Iterator<Producto> iteratorProducto = lstProducto.iterator();
            Producto producto = null;


        %>

        <h1>Eliminación de productos</h1>
        <br/>
        <form id="form-work" class="" name="form-work" action="ControllerProducto" method="get">               
            <div >
                <label for ="nit" class="control-label" >Selecciones producto a borrar</label>
                <select name="id" id="id" class="form-control" >
                    <option value="0">Selectione una opcion</option>
                    <% while (iteratorProducto.hasNext()) {
                            producto = iteratorProducto.next();
                    String  nombre;
                    int nit;
                    nit = producto.getIdProducto();
                    nombre=producto.getDescripcion();
                    %> 
                    <option value=<%= producto.getIdProducto()%>><% out.print(nit+"|| "+" "+nombre); %></option>
                    <%}%>
                </select>  
                <button id="accion" name="accion" value="eliminar" class="btn btn-success btn-lg btn-block info" type="submit">ELIMINAR</button>

            </div>

        </form>
<br><br><br><br><br><br><br><br><br><br><br><br><br>

    </body>
</html>
