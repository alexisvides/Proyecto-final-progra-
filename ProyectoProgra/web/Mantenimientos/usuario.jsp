

<%@page import="java.util.Iterator"%>
<%@page import="org.models.USUARIO"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body
                       
                             <%
                        
                        DaoUsuario daoUsuario = new  DaoUsuario();
                        List<USUARIO> lstUsuario = daoUsuario.listar();
                        Iterator<USUARIO> iteratorUsuario = lstUsuario.iterator();
                        USUARIO usuario = null;
                        while (iteratorUsuario.hasNext()){
                            usuario = iteratorUsuario.next();                        
                           
                        %>  
        <div class="container">   
            <div class="row">
                <div class="col-sm-4 col-offset-sm-4">
                    <form id="form-work" class="form" name="form-work" action="Usuario" method="get">
                                <input type="hidden" name="id" value="<%= usuario.getId_usuario() %>">
                                <input type="hidden" name="usuario_crea" value="<%= usuario.getUsuario_crea() %>">
                                <input type="hidden" name="usuario_mod" value="<%= usuario.getUsuario_mod() %>">
                                <input type="hidden" name="fecha_crea" value="<%= usuario.getFecha_crea() %>">
                                <input type="hidden" name="fecha_mod" value="<%= usuario.getFecha_mod() %>">

                        <div class="form-group">
                            <div class="form-group">
                                <label for ="nombre" class="control-label" >Nombre</label>
                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getNombre() %>">
                            </div> 
                            <div class="form-group">
                                <label for ="apellido" class="control-label" >Apellido</label>
                                <input type="text" class="form-control" name="apellido" value="<%= usuario.getApellido() %>">
                            </div> 
                            <div class="form-group">
                                <label for ="usuario" class="control-label" >Usuario</label>
                                <input type="text" class="form-control" name="usuario" value="<%= usuario.getUsuario() %>">
                            </div>
                            <div class="form-group">
                                <label for ="password" class="control-label" >Password</label>
                                <input type="password" class="form-control" name="password" value="<%= usuario.getPassword() %>">
                            </div>
                            <div class="form-group">
                                <label for ="rol" class="control-label" >Rol</label>
                                <input type="number" class="form-control" name="rol" value="<%= usuario.getRol() %>">
                            </div> 
                            <div class="form-group">
                                <label for ="activo" class="control-label" >Activo</label>
                                <select class="form-control" name="activo">
                                	<option value="0">No</option>
                                	<option value="1" <%= selected %>>Si</option>
                                </select>
                            </div>  
                            <div class="form-group">
                                <label for ="codigo" class="control-label" >Codigo</label>
                                <input type="number" class="form-control" name="codigo" value="<%= usuario.getCodigo() %>">
                            </div>
                            <div class="col-md-12 form-group">
                                <button id="accion" name="accion" value="save" class="btn btn-success btn-block pull-right" type="submit">Guardar</button>                    
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <br/>
        </div>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>     
        <script src="//kit.fontawesome.com/ab9769543f.js" crossorigin="anonymous"></script>
    </body>
</html>
