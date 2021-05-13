<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Modulo</title>
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
        <div class="container">      
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Modulo</h1>
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="Roles?accion=nuevo"  ><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Modulo</th>
                                <th class="text-center">Descripcion</th>
                                <th class="text-center">Activo</th>
                                <th class="text-center">Creado</th>
                                <th class="text-center">Actualizado</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <%--
                            DaoModulo daoModulo = new DaoModulo();
                            DaoUsuario daoUsuario = new  DaoUsuario();
                            List<Modulo> lstModulo = daoModulo.listar();
                            Iterator<Modulo> iteratorModulo = lstModulo.iterator();
                            Modulo modulo = null;
                            Usuario usuario = null;
                            while (iteratorModulo.hasNext()){
                                modulo = iteratorModulo.next();                        
                                usuario = daoUsuario.busqueda(String.valueOf(rol.getUsuario_crea()));
                                
                                
                        --%>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%--= modulo.getId_modulo()--%></td>
                                <td class="text-center"><%--= modulo.getNombre()--%></td>
                                <td class="text-center"><%--= modulo.getDescripcion()--%></td>
                                <td class="text-center"><%--= modulo.getActivo()--%></td>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= modulo.getFecha_crea()--%></td>
                            <%-- usuario = daoUsuario.busqueda(String.valueOf(modulo.getUsuario_mod())); --%>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= modulo.getFecha_mod()--%></td>
                                <td class="text-center">                                
                                    <a href="ControllerModulo?accion=editar&id=<%--=modulo.getId_modulo()--%>">Editar</a>
                                    <a href="ControllerModulo?accion=delete&id=<%--=modulo.getId_modulo()--%>">Eliminar</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>     
        <script src="//kit.fontawesome.com/ab9769543f.js" crossorigin="anonymous"></script>
    </body>
</html>