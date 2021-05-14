<%-- 
    Document   : Plantilla
    Created on : 13/05/2021, 08:18:51 PM
    Author     : vides
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">
            <%--a class="navbar-brand title" href="Controller?accion=inicio"><font color="black">Inicio</font></a--%>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li title="Administrar roles" class="nav-item">
                        <a class="nav-link active" href="ControllerRoles?accion=ver">Roles</a>
                        <a class="nav-link active" href="ControllerModulo?accion=ver">Modulo</a>
                        <a class="nav-link active" href="ControllerPermiso?accion=ver">Permisos</a>
                        <a class="nav-link active" href="ControllerUsuario?accion=ver">Usuarios</a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
