<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permisos</title>
    </head>
    <body
                        <%
                            Permiso permiso = (Permiso)request.getAttribute("permiso");
                            String selected = "";
                            if(permiso.getActivo() == 1){
                            	selected = "selected";
                            }
                        %>  
        <div class="container">   
            <h1 class='text-center'>Rol  <%=permiso.getId_permiso() %></h1>         
            <div class="row">
                <div class="col-sm-4 col-offset-sm-4">
                    <form id="form-work" class="form" name="form-work" action="Permiso" method="get">
                                <input type="hidden" name="id" value="<%= permiso.getId_permiso() %>">
                                <input type="hidden" name="usuario_crea" value="<%= permiso.getUsuario_crea() %>">
                                <input type="hidden" name="usuario_mod" value="<%= permiso.getUsuario_mod() %>">
                                <input type="hidden" name="fecha_crea" value="<%= permiso.getFecha_crea() %>">
                                <input type="hidden" name="fecha_mod" value="<%= permiso.getFecha_mod() %>">

                        <div class="form-group">
                            <div class="form-group">
                                <label for ="modulo" class="control-label" >Modulo</label>
                                <input type="text" class="form-control" name="modulo" value="<%= permiso.getModulo() %>">
                            </div>
                            <div class="form-group">
                                <label for ="rol" class="control-label" >Rol</label>
                                <textarea class="form-control" name="rol"><%=permiso.getRol() %></textarea>
                            </div>  
                            <div class="form-group">
                                <label for ="activo" class="control-label" >Activo</label>
                                <select class="form-control" name="activo">
                                	<option value="0">No</option>
                                	<option value="1" <%= selected %>>Si</option>
                                </select>
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

