<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Roles</title>
    </head>
    <body>
        <div class="container">      
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Roles</h1>
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="Roles?accion=nuevo"  ><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Descripcion</th>
                                <th class="text-center">Activo</th>
                                <th class="text-center">Creado</th>
                                <th class="text-center">Actualizado</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <%--
                            DaoRol daoRol = new DaoRol();
                            DaoUsuario daoUsuario = new  DaoUsuario();
                            List<Rol> lstRol = daoRol.listar();
                            Iterator<Rol> iteratorRol = lstRol.iterator();
                            Rol rol = null;
                            Usuario usuario = null;
                            while (iteratorRol.hasNext()){
                                rol = iteratorRol.next();                        
                                usuario = daoUsuario.busqueda(String.valueOf(rol.getUsuario_crea()));
                                
                                
                        --%>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%--= rol.getId_rol()--%></td>
                                <td class="text-center"><%--= rol.getNombre()--%></td>
                                <td class="text-center"><%--= rol.getDescripcion()--%></td>
                                <td class="text-center"><%--= rol.getActivo()--%></td>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= rol.getFecha_crea()--%></td>
                            <%-- usuario = daoUsuario.busqueda(String.valueOf(rol.getUsuario_mod())); --%>
                                <td class="text-center"><%--= usuario.getNombre() --%><%--= usuario.getApellido() --%><br><%--= rol.getFecha_mod()--%></td>
                                <td class="text-center">                                
                                    <a href="ControllerRol?accion=editar&id=<%--=rol.getId_rol()--%>">Editar</a>
                                    <a href="ControllerRol?accion=delete&id=<%--=rol.getId_rol()--%>">Eliminar</a>
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
