/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import exception.ExpiredSessionException;
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
import util.QuestionnaireDAO;
import servlet.helper.*;

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
        String forward = "choix_questionnaire.jsp";
        RequestHelper helper = null;
        try {
            helper = new RequestHelper(request);
            String action = request.getParameter("action").toString();
            if (action != null) {
                if(action.equals("afficher_choix_themes_niveau")){
                    helper.setAttributeThemesAndNiveaux();
                    forward = "choix_questionnaire.jsp";
                } else if (action.equals("afficher_info_questionnaire")) {
                    Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
                    request.setAttribute("questionnaire", questionnaire);
                    helper.setAttributeThemeAndNiveau(questionnaire.getIdTheme(), questionnaire.getIdNiveau());
                    forward = "warning.jsp";
                }



            }
                
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
        } catch (ExpiredSessionException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
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
        response.setContentType("text/html;charset=UTF-8");
        String forward = "choix_questionnaire.jsp";
        PasserQuestionnaireHelper helper = null;
        try{
            helper = new PasserQuestionnaireHelper(request);
            String action = request.getParameter("action").toString();
            if (action != null) {
                if(action.equals("choix_questionnaire")){
                    helper.setAttributeQuestionnairesByChoice();
                    forward = "choix_questionnaire.jsp";
                }else if(action.equals("question_validee")){
                    //On avance le compteur => à mettre en session
                }else if(action.equals("question_modifiee")){
                    //On n'avance pas le compteur, on garde celui qui est en session
                }else if(action.equals("modifier_reponses")){
                    //On met en attribut
                }
            }
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
        } catch (ExpiredSessionException e) {
            request.setAttribute("errorMessage", "Erreur :" + e.getMessage());
        }
        request.getRequestDispatcher(forward).forward(request, response);
        //setAttributeQuestionnairesByChoice(
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