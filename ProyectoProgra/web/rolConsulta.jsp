<%@page import="org.models.ROL"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoRol"%>
<jsp:include page="Plantilla.jsp"/>
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
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="ControllerRol?accion=agregar"><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Descripcion</th>
                                <th class="text-center">Usuario Creacion</th>
                                <th class="text-center">Usuario Modificacion</th>
                            </tr>
                        </thead>
                        <%
                            DaoRol daoRol = new DaoRol();
                            List<ROL> lstRol = daoRol.listar();
                            Iterator<ROL> iteratorRol = lstRol.iterator();
                            ROL rol = null;
                            while (iteratorRol.hasNext()){
                                rol = iteratorRol.next();
                        %>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%= rol.getID_ROL()%></td>
                                <td class="text-center"><%= rol.getNOMBRE()%></td>
                                <td class="text-center"><%= rol.getDESCRIPCION()%></td>
                                <td class="text-center"><%= rol.getUSUARIO_CREA() %></td>
                                <td class="text-center"><%= rol.getUSUARIO_MOD()%></td>
                                
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
