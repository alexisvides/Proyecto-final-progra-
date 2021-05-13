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
import org.dao.DaoUsuario;
import org.models.USUARIO;


@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

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

        USUARIO usuario = new USUARIO();
        DaoUsuario daoUSUARIO = new DaoUsuario();

        switch (action) {

            case "read":
                acceso = ingreso;
                break;
            case "eliminar":
                usuario = new USUARIO();
                usuario.setID_USUARIO(Integer.parseInt(request.getParameter("ID_USUARIO")));
                daoUSUARIO.eliminar(usuario);
                acceso = ingreso;
                break;
            case "modificar":
                usuario = new USUARIO();
                usuario.setNOMBRE(request.getParameter("NOMBRE"));
                usuario.setAPELLIDO(request.getParameter("APELLIDO"));
                usuario.setUSUARIO(request.getParameter("USUARIO"));
                usuario.setPASSWORD(request.getParameter("PASSWORD"));
                usuario.setUSUARIO_CREA(request.getParameter("USUARIO_CREA"));
                usuario.setUSUARIO_MOD(request.getParameter("USUARIO_MOD"));
                usuario.setID_ROL(Integer.parseInt(request.getParameter("ID_ROL")));
                usuario.setCODIGO(Integer.parseInt(request.getParameter("CODIGO")));
                usuario.setACTIVO(Integer.parseInt(request.getParameter("ACTIVO")));
                usuario.setFECHA_CREA(ParseFecha(request.getParameter("FECHA_CREA")));
                usuario.setFECHA_MOD(ParseFecha(request.getParameter("FECHA_MOD")));
                daoUSUARIO.modificar(usuario);
                acceso = ingreso;
                break;
            case "create":
                usuario = new USUARIO();
                usuario.setNOMBRE(request.getParameter("NOMBRE"));
                usuario.setAPELLIDO(request.getParameter("APELLIDO"));
                usuario.setUSUARIO(request.getParameter("USUARIO"));
                usuario.setPASSWORD(request.getParameter("PASSWORD"));
                usuario.setUSUARIO_CREA(request.getParameter("USUARIO_CREA"));
                usuario.setUSUARIO_MOD(request.getParameter("USUARIO_MOD"));
                usuario.setID_ROL(Integer.parseInt(request.getParameter("ID_ROL")));
                usuario.setCODIGO(Integer.parseInt(request.getParameter("CODIGO")));
                usuario.setACTIVO(Integer.parseInt(request.getParameter("ACTIVO")));
                usuario.setFECHA_CREA(ParseFecha(request.getParameter("FECHA_CREA")));
                usuario.setFECHA_MOD(ParseFecha(request.getParameter("FECHA_MOD")));
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
