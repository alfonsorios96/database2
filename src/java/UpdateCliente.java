/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 0264ARIOS
 */
public class UpdateCliente extends HttpServlet {

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
        String nombre = (String) request.getParameter("nombre");
        String ap = (String) request.getParameter("ap");
        String am = (String) request.getParameter("am");
        long id;
        long credito;
        long deuda;
        try {
            id = Long.parseLong(request.getParameter("id"));
            credito = Long.parseLong(request.getParameter("credito"));
            deuda = Long.parseLong(request.getParameter("deuda"));
        } catch (NullPointerException e) {
            id = 0;
            credito = 0;
            deuda = 0;
            e.printStackTrace();
        }
        if (updCliente(id, nombre, ap, am, credito, deuda) == 1) {
            response.sendRedirect("index.jsp?upd='1'");
        } else {
            response.sendRedirect("index.jsp?upd='0'");
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
            throws ServletException, IOException {
        processRequest(request, response);
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

    private static int updCliente(long id, java.lang.String nombre, java.lang.String ap, java.lang.String am, long credito, long deuda) {
        webservices.ClientesWS_Service service = new webservices.ClientesWS_Service();
        webservices.ClientesWS port = service.getClientesWSPort();
        return port.updCliente(id, nombre, ap, am, credito, deuda);
    }

}
