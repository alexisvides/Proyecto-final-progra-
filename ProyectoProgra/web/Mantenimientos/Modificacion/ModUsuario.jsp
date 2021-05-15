<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.models.USUARIO"%>
<%@page import="org.dao.DaoUsuario"%>
<jsp:include page="../../PlantillaAdmin.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <div class="" style="margin-left: 38%; margin-top: 3%; background-color: #000; width: 500px; padding: 1%; color: #fff">
            <div class="row">
                <div class="col-lg-12">                    
                    <div class="center-block">
                        <h1 class="text-center">Modificar Usuario</h1>
                        <br>
                        <form id="form-work" class="" name="text-center border border-light p-5" action="ControllerUsuario" method="get">                                                   
                           
                            <%
                            DaoUsuario daoUsuario = new DaoUsuario(); 
                            int id = Integer.parseInt((String)request.getAttribute("id_Cliente"));
                            USUARIO usuario = (USUARIO)daoUsuario.list(id); 

                        %>
                            <div class="form-group align">
                                <div class="col-md-12">
                                    <label for ="nombre" class="control-label" >id</label>
                                    <input value="<%= usuario.getID_USUARIO()%>"  name="id1" id="id1" class="form-control" placeholder="Nombre" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="nombre" class="control-label" >Nombre</label>
                                    <input value="<%= usuario.getNOMBRE()%>"  name="nombre" id="nombre" class="form-control" placeholder="Nombre" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="apellido" class="control-label" >Apellido</label>
                                    <input value="<%= usuario.getAPELLIDO()%>" name="apellido" id="apellido" class="form-control" placeholder="Apellido" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="usuario" class="control-label" >Usuario</label>
                                    <input name="usuario" id="usuario" value="<%= usuario.getUSUARIO()%>" class="form-control" placeholder="Usuario" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="pass" class="control-label" >Contraseña</label>
                                    <input name="pass" id="pass" class="form-control" value="<%= usuario.getPASSWORD()%>"placeholder="Contraseña" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="id_rol" class="control-label" >Id Rol</label>
                                    <input name="id_rol" id="id_rol" value="<%= usuario.getID_ROL()%>"class="form-control" placeholder="Id Rol" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="activo" class="control-label" >Activo</label>
                                    <input name="activo" id="activo" value="<%= usuario.getACTIVO()%>"class="form-control" placeholder="Activo" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="codigo" class="control-label">Codigo</label>
                                    <input name="codigo" id="codigo" value="<%= usuario.getCODIGO()%>"placeholder="Codigo" type="text" class="form-control">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <button id="accion" name="accion" value="modificar" class="btn btn-success btn-lg btn-block info" type="submit">Registrar</button>                    
                                </div>
                            </div>                       
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>     
        <script src="//kit.fontawesome.com/ab9769543f.js" crossorigin="anonymous"></script>
</html>
