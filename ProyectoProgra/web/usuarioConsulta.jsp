<%@page import="java.util.Iterator"%>
<%@page import="org.models.USUARIO"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>
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
                            </tr>
                        </thead>
                         <%

                                DaoUsuario daoUsuario = new DaoUsuario();
                                List<USUARIO> lstUsuario = daoUsuario.listar();
                                Iterator<USUARIO> iteratorUsuario = lstUsuario.iterator();
                                USUARIO usuario = null;
                                while (iteratorUsuario.hasNext()) {
                                    usuario = iteratorUsuario.next();
                                   

                            %>                      
                        <tbody>
                            <tr>
                                <td class="text-center"><%= usuario.getID_USUARIO() %></td>
                                <td class="text-center"><%= usuario.getNOMBRE()%></td>
                                <td class="text-center"><%= usuario.getAPELLIDO()%></td>
                                <td class="text-center"><%= usuario.getID_ROL()%></td>
                                <td class="text-center"><%= usuario.getACTIVO()%></td>
                                <td class="text-center"><%= usuario.getFECHA_CREA()%></td>
                                <td class="text-center"><%= usuario.getFECHA_MOD()%></td>
                               
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