<%-- 
    Document   : personaModificacion
    Created on : 23/04/2021, 01:21:59 PM
    Author     : vides
--%>


<%@page import="org.models.Producto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.Persona"%>
<%@page import="org.models.Pedido"%>
<%@page import="org.models.Municipio"%>
<%@page import="org.models.Departamento"%>
<%@page import="org.dao.DaoPersona"%>
<%@page import="org.dao.DaoProducto"%>
<%@page import="org.dao.DaoPedido"%>
<%@page import="org.dao.DaoMunicipio"%>
<%@page import="org.dao.DaoDepartamento"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Libro</title>
    </head>
    <body>

        <%
            DaoProducto daoProducto = new DaoProducto();
            List<Producto> lstProducto = daoProducto.listar();
            Iterator<Producto> iteratorProducto = lstProducto.iterator();
            Producto producto = null;

            DaoDepartamento daoDepartamento = new DaoDepartamento();
            List<Departamento> lstDepartamento = daoDepartamento.listar();
            Iterator<Departamento> iteratorDepartamento = lstDepartamento.iterator();
            Departamento departamento = null;

            DaoMunicipio daoMunicipio = new DaoMunicipio();
            List<Municipio> lstMunicipio = daoMunicipio.listar();
            Iterator<Municipio> iteratorMunicipio = lstMunicipio.iterator();
            Municipio municipio = null;

            DaoPersona daoPersona = new DaoPersona();
            List<Persona> lstPersona = daoPersona.listar();
            Iterator<Persona> iteratorPersona = lstPersona.iterator();
            Persona persona = null;
            DaoPedido daoPedido = new DaoPedido();
            List<Pedido> lstPedido = daoPedido.listar();
            Iterator<Pedido> iteratorPedido = lstPedido.iterator();
            Pedido pedido = null;
        %>

        <h1>Ingreso Pedidos</h1>
        <br/>
        <form id="form-work" class="" name="form-work" action="ControllerProducto" method="get">               
            <div >
                <label for ="idcliente" class="control-label" >Seleccione al cliente</label>
                <select name="idcliente" id="idcliente" class="form-control" >
                    <% while (iteratorPersona.hasNext()) {
                                    persona = iteratorPersona.next();%> 
                    <option value=<%= persona.getIdPersona()%>><%= persona.getNombre()%></option>
                    <%}%>
                </select>  
                <label for ="nit" class="control-label" >Selecciones producto </label>
                <select name="idproducto" id="idproducto" class="form-control" >
                    <option value="0">Selectione una opcion</option>
                    <% while (iteratorProducto.hasNext()) {
                            producto = iteratorProducto.next();
                            String nombre;
                            int nit;
                            nit = producto.getIdProducto();
                            nombre = producto.getDescripcion();
                    %> 
                    <option value=<%= producto.getIdProducto()%>><% out.print(nombre); %></option>
                    <%}%>
                </select>  
                <label class="control-label" for ="descripcion">Cantidad</label>
                <input name="cantidad" class="form-control" placeholder="cantidad" type="text">

                <label for ="precio" class="control-label">Observación</label>
                <input name="observacion" placeholder="observacion" type="text" class="form-control">

                
                <label for ="nit" class="control-label" >DEPARTAMENTO </label>
                <select name="iddepartamento" id="iddepartamento" class="form-control" >
                    <option value="0">Selectione una opcion</option>
                    <% while (iteratorDepartamento.hasNext()) {
                            departamento = iteratorDepartamento.next();
                            
                    %> 
                    <option value=<%= departamento.getIdDepartamento()%>><%=departamento.getNombre() %></option>
                    <%}%>
                </select>
                <label for ="nit" class="control-label" >Municipio </label>
                <select name="idmunicipio" id="idmunicipio" class="form-control" >
                    <option value="0">Selectione una opcion</option>
                    <% while (iteratorMunicipio.hasNext()) {
                            municipio = iteratorMunicipio.next();
                            
                    %> 
                    <option value=<%= municipio.getIdMunicipio()%>><%=municipio.getNombre() %></option>
                    <%}%>
                </select>
                


                <button id="accion" name="accion" value="create" class="btn btn-success btn-lg btn-block info" type="submit">Modificar</button>                    

            </div>

        </form>


    </body>
</html>
