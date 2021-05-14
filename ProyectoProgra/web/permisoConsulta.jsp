<%-- 
    Document   : permisoConsulta
    Created on : 12/05/2021, 07:06:28 AM
    Author     : Ale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Permisos</title>
    </head>
    <body>
       
        <div class="container">      
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Permisos</h1>
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="Roles?accion=nuevo"  ><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Modulo</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Activo</th>
                                <th class="text-center">Creado</th>
                                <th class="text-center">Actualizado</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <%--
                            DaoPermiso daoPermiso = new DaoPermiso();
                            DaoUsuario daoUsuario = new  DaoUsuario();
                            List<Permiso> lstPermiso = daoPermiso.listar();
                            Iterator<Permiso> iteratorPermiso = lstPermiso.iterator();
                            Permiso permiso = null;
                            Usuario usuario = null;
                            while (iteratorPermiso.hasNext()){
                                permiso = iteratorPermiso.next();                        
                                usuario = daoUsuario.busqueda(String.valueOf(rol.getUsuario_crea()));
                                
                                
                        --%>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%--= permiso.getId_permiso()--%></td>
                                <td class="text-center"><%--= permiso.getModulo()--%></td>
                                <td class="text-center"><%--= permiso.getRol()--%></td>
                                <td class="text-center"><%--= rol.getActivo()--%></td>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= permiso.getFecha_crea()--%></td>
                            <%-- usuario = daoUsuario.busqueda(String.valueOf(permiso.getUsuario_mod())); --%>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= permiso.getFecha_mod()--%></td>
                                <td class="text-center">                                
                                    <a href="ControllerPermisos?accion=editar&id=<%--=permiso.getId_permiso()--%>">Editar</a>
                                    <a href="ControllerPermisos?accion=delete&id=<%--=permiso.getId_permiso()--%>">Eliminar</a>
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
