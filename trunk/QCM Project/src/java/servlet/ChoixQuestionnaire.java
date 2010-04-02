/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.QuestionnaireDAO;
import util.ThemeDAO;
import util.NiveauDAO;

/**
 *
 * @author marya
 */
public class ChoixQuestionnaire extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException , SQLException{
        request.setAttribute("themes", ThemeDAO.getAll());
        request.setAttribute("niveaux", NiveauDAO.getAll());
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try{
           if(request.getSession().getAttribute("user")!=null){
                processRequest(request, response);
                request.getRequestDispatcher("choix_questionnaire.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(SQLException e){
            request.setAttribute("errorMessage", "Erreur interne :"+e.getMessage());
        }catch(NullPointerException e){
            request.setAttribute("errorMessage", "Vous n'êtes pas authentifié");
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<Integer, String> questionnaires = null;
        String page= "index.jsp";
        String errorMessage=null;
        try {
            Integer theme = Integer.parseInt(request.getParameter("theme").toString());
            Integer niveau = Integer.parseInt(request.getParameter("niveau").toString());
            if(theme==null || theme<0 || niveau==null || niveau<0){
                throw new IllegalArgumentException("Veuillez corrigez vos choix");
            }
            
            if(theme==0){
                request.setAttribute("niveau",niveau);
                questionnaires = QuestionnaireDAO.getQuestionnairesByNiveau(niveau);
            }else if(niveau==0){
                request.setAttribute("theme", theme);
                questionnaires = QuestionnaireDAO.getQuestionnairesByTheme(theme);
            }else {
                request.setAttribute("theme", theme);
                request.setAttribute("niveau",niveau);
                questionnaires = QuestionnaireDAO.getQuestionnairesByThemeAndNiveau(theme, niveau);
            }
            request.setAttribute("questionnaires", questionnaires);
            page="choix_questionnaire.jsp";
            
            
        }catch(SQLException e){
            errorMessage = e.getMessage();
        }catch(IllegalStateException e){
            errorMessage=e.getMessage();
        }catch(IllegalArgumentException e){
            errorMessage=e.getMessage();
        }catch(NullPointerException e){
            errorMessage=e.getMessage();
        } finally {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description : "+this.getServletInfo();
    }// </editor-fold>

}
