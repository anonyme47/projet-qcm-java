/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import exception.ExpiredSessionException;
import exception.UnauthorizedActionException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.helper.MesResultatsHelper;
import servlet.helper.RequestHelper;

/**
 *
 * @author marya
 */
public class MesResultats extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         String forward = "index.jsp";
        try {

            MesResultatsHelper helper = new MesResultatsHelper(request);


            String action = request.getParameter("action").toString();

            if (action != null) {
                if (action.equals("getQuestionnairesPasseByUser")) {
                    helper.setAttributeQuestionnairesPasses();
                    forward = "mesResultats.jsp";
                } else if(action.equals("getCorrection")){
                    System.out.println("correction");
                    helper.setAttributeCorrectionQuestionnaire();
                    forward = "afficherInfoQuestionnaire.jsp";
                }
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "error.jsp";
        } catch (NullPointerException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "error.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "error.jsp";
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "error.jsp";
        } catch (ExpiredSessionException e) {
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (UnauthorizedActionException e) {
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "error.jsp";
        }
        request.getRequestDispatcher(forward).forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
