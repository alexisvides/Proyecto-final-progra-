<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Usuarios</title>
    </head>
    <body>
        <div class="container">      
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Usuario</h1>
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="Roles?accion=nuevo"  ><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Activo</th>
                                <th class="text-center">Creado</th>
                                <th class="text-center">Actualizado</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <%--
                            DaoUsuario daoUsuario = new DaoUsuario();
                            List<Usuario> lstUsuario = daoUsuario.listar();
                            Iterator<Usuario> iteratorUsuario = lstUsuario.iterator();
                            Usuario usuario = null;
                            while (iteratorUsuario.hasNext()){
                                usuario = iteratorUsuario.next();                        
                                usuario = daoUsuario.busqueda(String.valueOf(rol.getUsuario_crea()));
                                
                                
                        --%>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%--= usuario.getId_usuario()--%></td>
                                <td class="text-center"><%--= usuario.getNombre()--%></td>
                                <td class="text-center"><%--= usuario.getApellido()--%></td>
                                <td class="text-center"><%--= usuario.getRol()--%></td>
                                <td class="text-center"><%--= usuario.getActivo()--%></td>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= usuario.getFecha_crea()--%></td>
                            <%-- usuario = daoUsuario.busqueda(String.valueOf(usuario.getUsuario_mod())); --%>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= usuario.getFecha_mod()--%></td>
                                <td class="text-center">                                
                                    <a href="ControllerUsuario?accion=editar&id=<%--=usuario.getId_usuario()--%>">Editar</a>
                                    <a href="ControllerUsuario?accion=delete&id=<%--=usuario.getId_usuario()--%>">Eliminar</a>
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