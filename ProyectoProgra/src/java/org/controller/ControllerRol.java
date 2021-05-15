/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoRol;
import org.models.ROL;

@WebServlet(name = "ControllerRol", urlPatterns = {"/ControllerRol"})
public class ControllerRol extends HttpServlet {

    String prime = "Plantilla.jsp", vista1 = "rolConsultaAdmin.jsp", ingreso = "rolConsulta.jsp", agregar = "rolIngreso.jsp";
    String modificar = "", modify = "/Mantenimientos/Modificacion/ModRol.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerRol</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerRol at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        ROL rol = new ROL();
        DaoRol daoRol = new DaoRol();

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
                rol = new ROL();
                rol.setID_ROL(Integer.parseInt(request.getParameter("id")));
                daoRol.eliminar(rol);
                acceso = vista1;
                break;
            case "editar":
                request.setAttribute("id_Cliente", request.getParameter("id"));
                acceso = modify;
                break;
            case "modificar":
                rol = new ROL();
                rol.setNOMBRE(request.getParameter("nombre"));
                rol.setDESCRIPCION(request.getParameter("descripcion"));
                rol.setUSUARIO_CREA(request.getParameter("usuario_crea"));
                rol.setUSUARIO_MOD(request.getParameter("usuario_mod"));
                rol.setID_ROL(Integer.parseInt(request.getParameter("id1")));

                daoRol.modificar(rol);
                acceso = vista1;
                break;
            case "agregar":
                acceso = agregar;
                break;
            case "add":
                rol = new ROL();
                rol.setNOMBRE(request.getParameter("nombre"));
                rol.setDESCRIPCION(request.getParameter("descripcion"));
                rol.setUSUARIO_CREA(request.getParameter("usuario_crea"));
                rol.setUSUARIO_MOD(request.getParameter("usuario_mod"));

                daoRol.insertar(rol);
                acceso = vista1;
                break;

        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
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
    }

}
