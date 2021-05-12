/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.dao.DaoPERMISO;
import org.models.PERMISO;


@WebServlet(name = "ControllerPermiso", urlPatterns = {"/ControllerPermiso"})
public class ControllerPermiso extends HttpServlet {

    String ingreso = "index.jsp";

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

        PERMISO permiso = new PERMISO();
        DaoPERMISO daoPERMISO = new DaoPERMISO();

        switch (action) {

            case "read":
                acceso = ingreso;
                break;
            case "eliminar":
                permiso = new PERMISO();
                permiso.setID_PERMISO(Integer.parseInt(request.getParameter("ID_PERMISO")));
                daoPERMISO.eliminar(permiso);
                acceso = ingreso;
                break;
            case "modificar":
                permiso = new PERMISO();
                permiso.setUSUARIO_CREA(request.getParameter("USUARIO_CREA"));
                permiso.setUSUARIO_MOD(request.getParameter("USUARIO_MOD"));
                permiso.setID_MODULO(Integer.parseInt(request.getParameter("ID_MODULO")));
                permiso.setID_ROL(Integer.parseInt(request.getParameter("ID_ROL")));
                permiso.setACTIVO(Integer.parseInt(request.getParameter("ACTIVO")));
                permiso.setFECHA_CREA(ParseFecha(request.getParameter("FECHA_CREA")));
                permiso.setFECHA_MOD(ParseFecha(request.getParameter("FECHA_MOD")));
                daoPERMISO.modificar(permiso);
                acceso = ingreso;
                break;
            case "create":
                permiso = new PERMISO();
                permiso.setUSUARIO_CREA(request.getParameter("NOMBRE"));
                permiso.setUSUARIO_MOD(request.getParameter("DESCRIPCION"));
                permiso.setID_MODULO(Integer.parseInt(request.getParameter("NIVEL")));
                permiso.setID_ROL(Integer.parseInt(request.getParameter("ORDEN")));
                permiso.setACTIVO(Integer.parseInt(request.getParameter("ID_PERMISO_PADRE")));
                permiso.setFECHA_CREA(ParseFecha(request.getParameter("FECHA_CREA")));
                permiso.setFECHA_MOD(ParseFecha(request.getParameter("FECHA_MOD")));
                daoPERMISO.crear(permiso);
                acceso = ingreso;
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
