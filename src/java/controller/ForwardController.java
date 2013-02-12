
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Server;

/**
 *
 * @author Jenni Burgmeier
 */
@WebServlet(name = "ForwardController", urlPatterns = {"/FwdControl.do"})
public class ForwardController extends HttpServlet {
private static final String destination = "/result.jsp";
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Server server = new Server();
        
        server.setEntree(request.getParameter("entree"));
        server.setSide(request.getParameter("side"));
        server.setDrink(request.getParameter("drink"));
        
        server.calculateOrder();
        
        request.setAttribute("entree", server.getEntree());
        request.setAttribute("entreeCost", 
                String.valueOf(server.getEntreeCost()));
        request.setAttribute("side", server.getSide());
        request.setAttribute("sideCost", 
                String.valueOf(server.getSideCost()));
        request.setAttribute("drink", server.getDrink());
        request.setAttribute("drinkCost", 
                String.valueOf(server.getDrinkCost()));
        request.setAttribute("totalCost", 
                String.valueOf(server.getTotalOrder()));
        request.setAttribute("tax", String.valueOf (server.getTax()));
        request.setAttribute("suggestedTip", 
                String.valueOf(server.getSuggestedTip())); 
//        
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
}
