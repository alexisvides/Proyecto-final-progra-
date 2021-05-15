<%@page import="java.util.Iterator"%>
<%@page import="org.models.USUARIO"%>
<%@page import="org.models.LOGIN"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <nav class="navbar navbar-expand-lg navbar-light  ">
            <%--a class="navbar-brand title" href="Controller?accion=inicio"><font color="black">Inicio</font></a--%>
            
            <div class="collapse navbar-collapse">

                <ul class="navbar-nav ml-auto">
                    <li style="float: left;" title="Administrar roles" class="nav-item">
                        <a class="nav-link active" href="ControllerRol?accion=vista">Roles</a>
                        <a class="nav-link active" href="ControllerModulo?accion=vista">Modulo</a>
                        <a class="nav-link active" href="ControllerUsuario?accion=vista">Usuarios</a>
                        <a class="nav-link active" href="ControllerUsuario?accion=cerrar">Cerrar Sesión</a>
                        

                    </li>
                </ul>

            </div>
        </nav>
    </body>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>     
        <script src="//kit.fontawesome.com/ab9769543f.js" crossorigin="anonymous"></script>
    
</html>
