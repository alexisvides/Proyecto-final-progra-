<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo</title>
    </head>
    <body
                        <%
                            ModificarModulo modulo = (ModificarModulo)request.getAttribute("modulo");
                            String selected = "";
                            if(modulo.getActivo() == 1){
                            	selected = "selected";
                            }
                        %>  
        <div class="container">   
            <h1 class='text-center'>Modulo  <%=modulo.getId_modulo() %></h1>         
            <div class="row">
                <div class="col-sm-4 col-offset-sm-4">
                    <form id="form-work" class="form" name="form-work" action="Modulo" method="get">
                                <input type="hidden" name="id" value="<%= modulo.getId_modulo() %>">
                                <input type="hidden" name="usuario_crea" value="<%= modulo.getUsuario_crea() %>">
                                <input type="hidden" name="usuario_mod" value="<%= modulo.getUsuario_mod() %>">
                                <input type="hidden" name="fecha_crea" value="<%= modulo.getFecha_crea() %>">
                                <input type="hidden" name="fecha_mod" value="<%= modulo.getFecha_mod() %>">
                                <input type="hidden" name="path" value="<%= modulo.getPath() %>">

                        <div class="form-group">
                            <div class="form-group">
                                <label for ="nombre" class="control-label" >Nombre</label>
                                <input type="text" class="form-control" name="nombre" value="<%= modulo.getNombre() %>">
                            </div>  
                            <div class="form-group">
                                <label for ="activo" class="control-label" >Activo</label>
                                <select class="form-control" name="activo">
                                	<option value="0">No</option>
                                	<option value="1" <%= selected %>>Si</option>
                                </select>
                            </div>  
                            <div class="form-group">
                                <label for ="descripcion" class="control-label" >Descripcion</label>
                                <textarea class="form-control" name="descripcion"><%=modulo.getDescripcion() %></textarea>
                            </div>
                            <div class="form-group">
                                <label for ="nivel" class="control-label" >Nivel</label>
                                <input type="number" class="form-control" name="nivel" value="<%= modulo.getNivel() %>">
                            </div>
                            <div class="form-group">
                                <label for ="orden" class="control-label" >Orden</label>
                                <input type="number" class="form-control" name="orden" value="<%= modulo.getOrden() %>">
                            </div>
                            <div class="form-group">
                                <label for ="moduloPadre" class="control-label" >Modulo Padre</label>
                                <input type="number" class="form-control" name="moduloPadre" value="<%= modulo.getModuloPadre() %>">
                            </div> 
                            <div class="col-md-12 form-group">
                                <button id="accion" name="accion" value="Modificar" class="btn btn-success btn-block pull-right" type="submit">Modificar</button>
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
