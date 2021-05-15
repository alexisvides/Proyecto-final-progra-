
package Controlador;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModeloDAO.DaoCliente;
import Modelo.Cliente;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "ControladorCliente", urlPatterns = {"/ControladorCliente"})
public class ControladorCliente extends HttpServlet {
    String index = "index.jsp";
    String listar="Mantenimientos/Cliente/clienteConsultas.jsp";
    String add="Mantenimientos/Cliente/clienteIngreso.jsp";
    String edit="Mantenimientos/Cliente/clienteEdicion.jsp";
    Cliente c = new Cliente();   
    DaoCliente dao = new DaoCliente();
    
    int id = 0;
    float f;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        
        switch (action){
        case "index":
            acceso = index;            
            break;
            
        case "listar":
            acceso = listar;            
            break;
        
        case "add":
            acceso = add;
            break;
            
        case "agregar":
            c = new Cliente();
            c.setNombre(request.getParameter("nombre"));
            c.setApellido(request.getParameter("apellido"));
            c.setNit(request.getParameter("nit"));
            c.setTelefono(request.getParameter("telefono"));
            c.setDireccion(request.getParameter("direccion"));

            dao.add(c);
            acceso = listar;
        break;
        
        case "editar": 
            request.setAttribute("id_Cliente",request.getParameter("id"));
            acceso=edit;
        break;
            
        case "eliminar":
            id=Integer.parseInt(request.getParameter("id"));
            c.setIdCliente(id);
            dao.eliminar(id);
            acceso=listar;
        break;
    }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
