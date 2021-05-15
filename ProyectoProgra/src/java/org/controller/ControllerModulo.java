package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoModulo;
import org.models.MODULO;


@WebServlet(name = "ControllerModulo", urlPatterns = {"/ControllerModulo"})
public class ControllerModulo extends HttpServlet {

    String prime="Plantilla.jsp",  vista1= "moduloConsultaAdmin.jsp", ingreso="moduloConsulta.jsp", agregar = "moduloIngreso.jsp";
    String modificar = "", modify = "/Mantenimientos/Modificacion/ModificarModulo.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerLibro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerLibro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        //processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");

        MODULO modulo = new MODULO();
        DaoModulo daoModulo = new DaoModulo();

        switch (action) {

            case "vistaN":
                acceso = ingreso;
                break;
            case "vista":
                acceso = vista1;
                break;
            case "index":
                acceso = prime;            
                break;
            case "eliminar":
                modulo = new MODULO();
                modulo.setID_MODULO(Integer.parseInt(request.getParameter("id")));
                daoModulo.eliminar(modulo);
                acceso = vista1;
                break;
            case "editar":
                request.setAttribute("id_Cliente",request.getParameter("id"));
                acceso = modify;
                break;
            case "modificar":
                modulo = new MODULO();
                modulo.setNOMBRE(request.getParameter("nombre"));
                modulo.setDESCRIPCION(request.getParameter("descripcion"));
                modulo.setID_MODULO_PADRE(Integer.parseInt(request.getParameter("modulo_padre")));
                modulo.setID_MODULO(Integer.parseInt(request.getParameter("id1")));
                modulo.setUSUARIO_CREA(request.getParameter("usuario_crea"));
                modulo.setUSUARIO_MOD(request.getParameter("usuario_mod"));
                daoModulo.modificar(modulo);
                acceso = vista1;
                break;
            case "agregar": 
                acceso = agregar;
                break;
            case "add":
                modulo = new MODULO();
                modulo.setNOMBRE(request.getParameter("nombre"));
                modulo.setDESCRIPCION(request.getParameter("descripcion"));
                modulo.setID_MODULO_PADRE(Integer.parseInt(request.getParameter("modulo_padre")));
                modulo.setUSUARIO_CREA(request.getParameter("usuario_crea"));
                modulo.setUSUARIO_MOD(request.getParameter("usuario_mod"));
                daoModulo.insertar(modulo);
                acceso = vista1;
                break;

        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = (Date) formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

}
