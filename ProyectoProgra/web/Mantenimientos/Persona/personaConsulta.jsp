

<%@page import="java.util.Iterator"%>
<%@page import="org.models.Persona"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <div class="container">            
            <h1>Consulta de clientes</h1>
           
                <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">NOMBRE</th>
                            <th class="text-center">APELLIDO</th>                            
                            <th class="text-center">NIT</th>                                 
                            <th class="text-center">TELEFONO</th>                             
                            <th class="text-center">DIRECCIÓN</th> 
                            
                        </tr>
                    </thead>
                    <%                        
                        DaoPersona daoPersona = new  DaoPersona();
                        List<Persona> lstPersona = daoPersona.listar();
                        Iterator<Persona> iteratorPersona = lstPersona.iterator();
                        Persona persona = null;
                        while (iteratorPersona.hasNext()){
                           persona = iteratorPersona.next();                        
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center"><%= persona.getIdPersona()%></td>
                            <td class="text-center"><%= persona.getNombre()%></td>
                            <td class="text-center"><%= persona.getApellido()%></td>                                                   
                            <td class="text-center"><%= persona.getNit()%></td>                                                         
                            <td class="text-center"><%= persona.getTelefono()%></td>                                                        
                            <td class="text-center"><%= persona.getDireccion()%></td>  
                           
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                   

            
        </div>
    </body>
</html>
