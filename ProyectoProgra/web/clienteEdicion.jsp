<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.DaoCliente"%>
<jsp:include page="../../index.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="" style="margin-left: 38%; margin-top: 1%; background-color: #000; width: 500px; padding: 1%; color: #fff">
        <div class="row">
            <div class="col-sm-12" style="width: 50%">
                <div class="center-block">
                    <h1 class="text-center">Actualizar Empleado</h1>                    
                    <br>
                    <form id="form-work" class="" name="text-center border border-light p-5" action="Controlador" method="get">
                        <%
                            DaoCliente daoCliente = new DaoCliente(); 
                            int id = Integer.parseInt((String)request.getAttribute("id_Cliente"));
                            Cliente empleado = (Cliente)daoCliente.list(id); 
                        %>
                        <div class="form-group align">                            
                            <div class="col-md-12">
                                <h1 class="text-center"></h1>
                                <input name="id" id="id" class="form-control" hidden="true" placeholder="Id" type="number" value="<%= empleado.getIdCliente()%>">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="idchafa" class="control-label" >Id</label>
                                <input name="idchafa" id="idchafa" class="form-control" disabled placeholder="Id" type="number" value="<%= empleado.getIdCliente()%>">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="nombre" class="control-label" >Nombre</label>
                                <input name="nombre" id="nombre" class="form-control" placeholder="Nombre" type="text" value="<%= empleado.getNombre()%>">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="apellido" class="control-label" >Apellido</label>
                                <input name="apellido" id="apellido" class="form-control" placeholder="Apellido" type="text" value="<%= empleado.getApellido()%>">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="nit" class="control-label">Nit</label>
                                <input name="nit" id="nit" placeholder="Nit" type="text" class="form-control" step="any" value="<%= empleado.getNit()%>">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="telefono" class="control-label">Telefono</label>
                                <input name="telefono" id="telefono" placeholder="Telefono" type="text" class="form-control" min="0" max="3" value="<%= empleado.getTelefono()%>">                           
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label for ="direccion" class="control-label">Dirección</label>
                                <input name="direccion" id="direccion" placeholder="Direccion" type="text" class="form-control" min="0" max="1" value="<%= empleado.getDireccion()%>">                           
                            </div>
                            <br>
                            <div class="col-md-12">
                                <button id="accion" name="accion" value="actualizar" class="btn btn-success btn-lg btn-block info" type="submit">Actualizar</button>                    
                            </div>
                        </div>                       
                    </form>
                </div>
            </div>
        </div>
    </div>    
    </body>
</html>
