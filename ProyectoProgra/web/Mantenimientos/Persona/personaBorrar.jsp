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
            DaoPersona daoPersona = new DaoPersona();
            List<Persona> lstPersona = daoPersona.listar();
            Iterator<Persona> iteratorPersona = lstPersona.iterator();
            Persona persona = null;


        %>

        <h1>Eliminación personas</h1>
        <br/>
        <form id="form-work" class="" name="form-work" action="ControllerPersona" method="get">               
            <div >
                <label for ="nit" class="control-label" >Selecciones el Nit del cliente a borrar</label>
                <select name="nit" id="nit" class="form-control" >
                    <% while (iteratorPersona.hasNext()) {
                            persona = iteratorPersona.next();
                    String nit, nombre;
                    nit = persona.getNit();
                    nombre=persona.getNombre();
                    %> 
                    <option value=<%= persona.getNit()%>><% out.print(nit+" "+" "+nombre); %></option>
                    <%}%>
                </select>  
                <button id="accion" name="accion" value="eliminar" class="btn btn-success btn-lg btn-block info" type="submit">ELIMINAR</button>

            </div>

        </form>
<br><br><br><br><br><br><br><br><br><br><br><br><br>

    </body>
</html>
