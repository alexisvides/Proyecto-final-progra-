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
        
        <link href="Styles/Site.css" rel="stylesheet" type="text/css"/>
        <link href="Content/bootstrap.css" rel="stylesheet" type="text/css"/>
       <script src="Scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
       <script src="Scripts/bootstrap.min.js" type="text/javascript"></script>
    </head>
    
    <body>
        <form id="Form1" >
        <nav class="navbar navbar-default" role="navigation"  >
            <%--a class="navbar-brand title" href="Controller?accion=inicio"><font color="black">Inicio</font></a--%>
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>                    
                    </div>
            <div class="navbar-header">
                <ul class="navbar-nav ml-auto">
                    <li title="Administrar roles" class="navbar-brand">
                        <a class="nav-link active" href="ControllerRoles?accion=vista">Roles</a><br/>
                    </li>
                    <li class="navbar-brand">
                        <a class="nav-link active" href="ControllerModulo?accion=vista">Modulo</a>
                    </li> 

                    <li class="navbar-brand">
                        <a class="nav-link active" href="ControllerUsuario?accion=vista">Usuarios</a>
                    </li>                 
                    <li  class="navbar-brand">
                        <a class="nav-link active" href="ControllerUsuario?accion=cerrar"> Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
            </div>
                
        </nav>
            <div class="container body-content">
                <div style=" float:right;">                    
                </div>
            <footer>
            </footer>
    </body>
</html>
