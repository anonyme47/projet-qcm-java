/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Questionnaire;
import util.NiveauDAO;
import util.QuestionnaireDAO;
import util.ThemeDAO;

/**
 *
 * @author Lou
 */
public class PasserQuestionnaire extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String forward = "choix_questionnaire.jsp";
        try {
            String action = request.getParameter("action");
            if (action != null) {
                request.setAttribute("themes", ThemeDAO.getAll());
                request.setAttribute("niveaux", NiveauDAO.getAll());
                forward = "choix_questionnaire.jsp";
            } else if (action.equals("afficherInfoQuestionnaire")) {
                Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
                request.setAttribute("questionnaire", questionnaire);
                request.setAttribute("theme", ThemeDAO.getById(questionnaire.getIdTheme()).getLibelle());
                request.setAttribute("niveau", NiveauDAO.getById(questionnaire.getIdNiveau()).getLibelle());
                forward = "warning.jsp";
            }
        } catch (NullPointerException e) {
            Logger.getLogger(PasserQuestionnaire.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
//            request.getRequestDispatcher("warning.jsp").forward(request, response);
        } catch (SQLException e) {
            Logger.getLogger(PasserQuestionnaire.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
//            request.getRequestDispatcher("warning.jsp").forward(request, response);
        } finally {
            out.close();
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
