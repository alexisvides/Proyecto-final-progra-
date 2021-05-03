<%-- 
    Document   : libroIngreso
    Created on : 26/02/2021, 07:40:06 PM
    Author     : Joseph
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Libro</title>
    </head>
    <body>
        
            <h1>Registro de  personas</h1>
            <br/>
            <form id="form-work" class="" name="form-work" action="ControllerPersona" method="get">               
                <div >
            
                        <label class="control-label" for ="nombre">Nombre</label>
                        <input value="" name="nombre" class="form-control" placeholder="nombre" type="text">
                   
                        <label for ="apellido" class="control-label">Apellido</label>
                        <input value="" name="apellido" placeholder="apellido" type="text" class="form-control">
                   
                        <label for ="nit" class="control-label"  >Nit</label>
                         <input value="" name="nit" class="form-control" placeholder="nit" type="text">
                      
                       <label for ="telefono" class="control-label" >Telefono</label>
                         <input value="" name="telefono" class="form-control" placeholder="telefono" type="text">

                       <label class="control-label" for ="direccion">Direccion</label>
                        <input value="" name="direccion" class="form-control" placeholder="direccion" type="text">

                        <button id="accion" name="accion" value="create" class="btn btn-success btn-lg btn-block info" type="submit">Aceptar</button>                    
                   
                </div>
                 
            </form>
        
        
    </body>
</html>
