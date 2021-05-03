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
        
            <h1>Registro de productos</h1>
            <br/>
            <form id="form-work" class="" name="form-work" action="ControllerProducto" method="get">               
                <div >
            
                        <label class="control-label" for ="descripcion">DESCRIPCION</label>
                        <input value="" name="descripcion" class="form-control" placeholder="descripcion" type="text">
                   
                        <label for ="precio" class="control-label">PRECIO</label>
                        <input value="" name="precio" placeholder="precio" type="text" class="form-control">
                   
                        <label for ="existencia" class="control-label"  >EXISTENCIA</label>
                         <input value="" name="existencia" class="form-control" placeholder="existencia" type="text">
                      
                       


                        <button id="accion" name="accion" value="create" class="btn btn-success btn-lg btn-block info" type="submit">Aceptar</button>                    
                   
                </div>
                 
            </form>
        
        
    </body>
</html>
