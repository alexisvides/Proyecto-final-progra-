<%@page import="org.models.MODULO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>
<%@page import="org.dao.DaoModulo"%>
<jsp:include page="Plantilla.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Modulo</title>
    </head>
    <body>
       
        <div class="container">      
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Modulo</h1>
                    <a class="btn btn-primary pull-right" style="color:white!important;" href="ControllerModulo?accion=agregar"  ><b><i class="glyphicon glyphicon-plus"></i> Agregar Nuevo</b></a>
                    <br>
                    <br>
                    <table border="1" width="1" cellspacing="1" class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Descripcion</th>
                                <th class="text-center">Modulo Padre</th>
                                <th class="text-center">Usuario Creacion</th>
                                <th class="text-center">Usuario Modificacion</th>
                            </tr>
                        </thead>
                        <%
                            DaoModulo daoModulo = new DaoModulo();
                            List<MODULO> lstModulo = daoModulo.listar();
                            Iterator<MODULO> iteratorModulo = lstModulo.iterator();
                            MODULO modulo = null;
                            while (iteratorModulo.hasNext()){
                                modulo = iteratorModulo.next();                        
                                
                                
                       %>                     
                        <tbody>
                            <tr>
                                <td class="text-center"><%= modulo.getID_MODULO()%></td>
                                <td class="text-center"><%= modulo.getNOMBRE()%></td>
                                <td class="text-center"><%= modulo.getDESCRIPCION()%></td>
                                <td class="text-center"><%= modulo.getID_MODULO_PADRE()%></td>
                                <td class="text-center"><%= modulo.getUSUARIO_CREA()%></td>                            
                                <td class="text-center"><%= modulo.getUSUARIO_MOD()%></td>
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