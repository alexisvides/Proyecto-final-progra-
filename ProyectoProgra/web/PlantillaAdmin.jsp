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
        <title>Inicio</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//kit.fontawesome.com/ab9769543f.js" crossorigin="anonymous"></script>        
        <script src="//cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark bg-dark">            
                <a class="text-white navbar-brand" href="ControllerUsuario?accion=vista">
                    <i class="fas fa-cheese"></i> Restaunrante Ratatouille
                </a>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto menu">
                        <li style="float: left;" title="Administrar roles" class="nav-item">
                            <a class="nav-link active" href="ControllerRol?accion=vista">Roles</a>                            
                        </li>
                        <li style="float: left;" title="Administrar roles" class="nav-item">
                            <a class="nav-link active" href="ControllerModulo?accion=vista">Modulo</a>
                        </li>
                        <li style="float: left;" title="Administrar roles" class="nav-item">
                            <a class="nav-link active" href="ControllerUsuario?accion=vista">Usuarios</a>
                        </li>
                        <li style="float: left;" title="Administrar roles" class="nav-item">
                            <a class="nav-link active" href="ControllerUsuario?accion=cerrar">Cerrar Sesión</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>        
    </body>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-3.4.1.slim.min.js" crossorigin="anonymous"></script>
</html>
