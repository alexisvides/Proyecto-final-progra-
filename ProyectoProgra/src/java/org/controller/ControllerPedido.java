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
import org.dao.DaoPedido;
import org.models.Pedido;

/**
 *
 * @author vides
 */
@WebServlet(name = "ControllerPedido", urlPatterns = {"/ControllerPedido"})
public class ControllerPedido extends HttpServlet {
     String ingreso="index.jsp";
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
            out.println("<title>Servlet ControllerPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPedido at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NullPointerException {
        //processRequest(request, response);
         String acceso="";        
        String action = request.getParameter("accion");        
        
        Pedido pedido = new Pedido();
        DaoPedido daoPedido = new DaoPedido();
        
        switch (action){
            
            case "reload":
              acceso = ingreso;
            break;
            case "eliminar":
              pedido = new Pedido();
              pedido.setIdPedido(Integer.parseInt(request.getParameter("id")));
              daoPedido.eliminar(pedido);
              acceso = ingreso;
            break;
            case "modificar":
                
                pedido = new Pedido();
                pedido.setIdPedido(Integer.parseInt(request.getParameter("id")));
                pedido.setIdMunicipio(Integer.parseInt(request.getParameter("idmunicipio")));
                pedido.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
                pedido.setObservacion(request.getParameter("observacion"));
                pedido.setIdDepartamento(Integer.parseInt(request.getParameter("precio")));
                pedido.setEstado(Integer.parseInt(request.getParameter("precio")));
                pedido.setTotal(Float.parseFloat(request.getParameter("precio")));
                pedido.setTotal_usd(Float.parseFloat(request.getParameter("precio")));
                
                
                daoPedido.modificar(pedido);
                acceso = ingreso;
            break;
            case "create":
                 pedido = new Pedido();
                pedido.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
                pedido.setIdProducto(Integer.parseInt(request.getParameter("idproducto")));
                pedido.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                pedido.setObservacion(request.getParameter("observacion"));
                pedido.setIdDepartamento(Integer.parseInt(request.getParameter("iddepartamento")));
                pedido.setIdMunicipio(Integer.parseInt(request.getParameter("idmunicipio")));
                daoPedido.insertar(pedido);
                acceso = ingreso;
            break;
            
            
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
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

}
