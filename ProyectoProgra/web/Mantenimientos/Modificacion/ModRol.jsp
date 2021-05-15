<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.models.ROL"%>
<%@page import="org.dao.DaoRol"%>
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
                        <h1 class="text-center">Modificar Rol</h1>
                        <br>
                        <form id="form-work" class="" name="text-center border border-light p-5" action="ControllerRol" method="get">
                            <%
                            DaoRol daoUsuario = new DaoRol(); 
                            int id = Integer.parseInt((String)request.getAttribute("id_Cliente"));
                            ROL rol = (ROL)daoUsuario.list(id); 

                        %>
                            <div class="form-group align">
                                <div class="col-md-12">
                                    <label for ="nombre" class="control-label" >ID</label>
                                    <input value="<%=rol.getID_ROL()%>" name="id1" id="id1" class="form-control" placeholder="Nombre" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="nombre" class="control-label" >Nombre</label>
                                    <input value="<%=rol.getNOMBRE()%>" name="nombre" id="nombre" class="form-control" placeholder="Nombre" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="descripcion" class="control-label" >Descripcion</label>
                                    <input name="descripcion" value="<%=rol.getDESCRIPCION()%>" id="descripcion" class="form-control" placeholder="Descripcion" type="text">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="usuario_crea" class="control-label">Usuario Creacion</label>
                                    <input value="<%=rol.getUSUARIO_CREA()%>" name="usuario_crea" id="usuario_crea" placeholder="Usuario Creacion" type="text" class="form-control">
                                </div>
                                <br>
                                <div class="col-md-12">
                                    <label for ="usuario_mod" class="control-label">Usuario Modificacion</label>
                                    <input value="<%=rol.getUSUARIO_MOD()%>" name="usuario_mod" id="usuario_mod" placeholder="Usuario Modificacion" type="text" class="form-control">                           
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
