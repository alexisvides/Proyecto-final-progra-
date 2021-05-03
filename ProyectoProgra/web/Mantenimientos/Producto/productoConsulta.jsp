<%-- 
    Document   : EditorialConsulta
    Created on : 20/02/2021, 07:55:18 AM
    Author     : Joseph
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.Producto"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Editorial</title>
    </head>
    <body>
        <div class="container">            
            <h1>Consulta productos</h1>
            
                <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Descripción</th>
                            <th class="text-center">Precio</th>
                            <th class="text-center">Existencia</th>                           
                            <th class="text-center">Estado</th>
                        </tr>
                    </thead>
                    <%
                        
                        DaoProducto daoProducto = new  DaoProducto();
                        List<Producto> lstProducto = daoProducto.listar();
                        Iterator<Producto> iteratorProducto = lstProducto.iterator();
                        Producto producto = null;
                        while (iteratorProducto.hasNext()){
                            producto = iteratorProducto.next();                        
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center"><%= producto.getIdProducto()%></td>
                            <td class="text-center"><%= producto.getDescripcion()%></td>
                            <td class="text-center"><%= producto.getPrecio()%></td>
                            <td class="text-center"><%= producto.getExistencia()%></td> 
                            <%
                            int estado = producto.getEstado();
                            if(estado==1){
                               %> <td class="text-center">DISPONIBLE</td> 
                           <% }else{ %>
                             <td class="text-center">NO DISPONIBLE</td> 
                           <%}%>
                                                     
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                   

            
        </div>
        
    </body>
</html>
