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
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoUsuario;
import org.models.USUARIO;
import org.models.LOGIN;

@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

    String prime="Plantilla.jsp", ingreso = "usuarioConsultaAdmin.jsp",ver ="usuarioConsulta.jsp", exit = "index.jsp", modify = "/Mantenimientos/Modificacion/Modifmodulo.jsp";

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
        LOGIN log = new LOGIN();
        DaoUsuario daoUSUARIO = new DaoUsuario();

        switch (action) {

            case "login":
                boolean logeado = false;
                String us = "";
                log = new LOGIN();
                log.setUSUARIO(request.getParameter("USUARIO"));
                log.setPASSWORD(request.getParameter("PASSWORD"));

                DaoUsuario daoUsuario = new DaoUsuario();
                List<LOGIN> lstLogin = daoUsuario.login(log);
                Iterator<LOGIN> iteratorLogin = lstLogin.iterator();
                LOGIN login = null;
                
                if (iteratorLogin.hasNext()) {
                    login = iteratorLogin.next();

                    if (login.getUSUARIO() != null && login.getPASSWORD() != null ) {
                        if (login.getUSUARIO().equals(request.getParameter("USUARIO")) && login.getPASSWORD().equals(request.getParameter("PASSWORD")) 
                                && login.getACTIVO()==1 && login.getRol()==2) {
                            
                            log.setEncendido(1);
                            acceso = prime;
                            break;
                        }
                        if (login.getUSUARIO().equals(request.getParameter("USUARIO")) && login.getPASSWORD().equals(request.getParameter("PASSWORD")) 
                                && login.getACTIVO()==1  && login.getRol()==1) {
                            
                            log.setEncendido(1);
                            acceso = prime;
                            break;
                        }
                    }
                }else{
                    
                    acceso = exit;
                }

                break;

            case "vista":
                acceso = ver;
                break;
            case "eliminar":
                usuario = new USUARIO();
                int id = 0;
                id = Integer.parseInt(request.getParameter("id"));
                usuario.setID_USUARIO(id);
                daoUSUARIO.eliminar(usuario);
                acceso = ver;
                break;
            case "modificar":
                usuario = new USUARIO();
                usuario.setNOMBRE(request.getParameter("NOMBRE"));
                usuario.setAPELLIDO(request.getParameter("APELLIDO"));
                usuario.setUSUARIO(request.getParameter("USUARIO"));
                usuario.setPASSWORD(request.getParameter("PASSWORD"));
                usuario.setID_ROL(Integer.parseInt(request.getParameter("ID_ROL")));
                usuario.setCODIGO(Integer.parseInt(request.getParameter("CODIGO")));
                usuario.setACTIVO(Integer.parseInt(request.getParameter("ACTIVO")));
                usuario.setFECHA_CREA(request.getParameter("FECHA_CREA"));
                usuario.setFECHA_MOD(request.getParameter("FECHA_MOD"));
                daoUSUARIO.modificar(usuario);
                acceso = modify;
                break;
            case "create":
                usuario = new USUARIO();
                usuario.setNOMBRE(request.getParameter("NOMBRE"));
                usuario.setAPELLIDO(request.getParameter("APELLIDO"));
                usuario.setUSUARIO(request.getParameter("USUARIO"));
                usuario.setPASSWORD(request.getParameter("PASSWORD"));
                usuario.setID_ROL(Integer.parseInt(request.getParameter("ID_ROL")));
                usuario.setCODIGO(Integer.parseInt(request.getParameter("CODIGO")));
                usuario.setACTIVO(Integer.parseInt(request.getParameter("ACTIVO")));
                usuario.setFECHA_CREA(request.getParameter("FECHA_CREA"));
                usuario.setFECHA_MOD(request.getParameter("FECHA_MOD"));
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
