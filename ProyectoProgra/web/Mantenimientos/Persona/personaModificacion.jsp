<%-- 
    Document   : personaModificacion
    Created on : 23/04/2021, 01:21:59 PM
    Author     : vides
--%>


<%@page import="org.models.Persona"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoPersona"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Libro</title>
    </head>
    <body>

        <%
             DaoPersona daoPersona = new  DaoPersona();
                        List<Persona> lstPersona = daoPersona.listar();
                        Iterator<Persona> iteratorPersona = lstPersona.iterator();
                        Persona persona = null;



        %>
        
            <h1>Modificación personas</h1>
            <br/>
            <form id="form-work" class="" name="form-work" action="ControllerPersona" method="get">               
                <div >
                        <label for ="nit" class="control-label" >Selecciones el Nit del cliente</label>
                        <select name="nit" id="nit" class="form-control" >
                            <% while (iteratorPersona.hasNext()){
                                persona = iteratorPersona.next();  %> 
                             <option value=<%= persona.getNit()%>><%= persona.getNit()%></option>
                            <%}%>
                        </select>  
                        <label class="control-label" for ="nombre">Nombre</label>
                        <input name="nombre" class="form-control" placeholder="nombre" type="text">
                   
                        <label for ="apellido" class="control-label">Apellido</label>
                        <input name="apellido" placeholder="apellido" type="text" class="form-control">
                   
                       <label for ="telefono" class="control-label" >Telefono</label>
                         <input  name="telefono" class="form-control" placeholder="telefono" type="text">

                       <label class="control-label" for ="direccion">Direccion</label>
                        <input  name="direccion" class="form-control" placeholder="direccion" type="text">

                        <button id="accion" name="accion" value="modificar" class="btn btn-success btn-lg btn-block info" type="submit">Modificar</button>                    
                   
                </div>
                 
            </form>
        
        
    </body>
</html>
