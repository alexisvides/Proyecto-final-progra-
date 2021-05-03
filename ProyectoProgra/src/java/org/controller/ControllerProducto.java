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
import org.dao.DaoProducto;
import org.models.Producto;

/**
 *
 * @author Joseph
 */
@WebServlet(name = "ControllerProducto", urlPatterns = {"/ControllerProducto"})
public class ControllerProducto extends HttpServlet {
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
        String acceso="";        
        String action = request.getParameter("accion");        
        
        Producto producto = new Producto();
        DaoProducto daoProducto = new DaoProducto();
        
        switch (action){
            
            case "reload":
              acceso = ingreso;
            break;
            case "eliminar":
              producto = new Producto();
              producto.setIdProducto(Integer.parseInt(request.getParameter("id")));
              daoProducto.eliminar(producto);
              acceso = ingreso;
            break;
            case "modificar":
                
                producto = new Producto();
                producto.setIdProducto(Integer.parseInt(request.getParameter("id")));
                producto.setDescripcion(request.getParameter("descripcion"));
                producto.setExistencia(Integer.parseInt(request.getParameter("existencia")));
                producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
                
                
                daoProducto.modificar(producto);
                acceso = ingreso;
            break;
            case "create":
                producto = new Producto();
                producto.setDescripcion(request.getParameter("descripcion"));
                producto.setExistencia(Integer.parseInt(request.getParameter("existencia")));
                producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
                
                daoProducto.insertar(producto);
                acceso = ingreso;
                
            break;
            
            
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
        
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
            throws ServletException, IOException {
        //processRequest(request, response);
        
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
