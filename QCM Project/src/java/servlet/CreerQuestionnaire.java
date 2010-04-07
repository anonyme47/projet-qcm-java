package servlet;

import java.io.IOException;
import java.sql.SQLException;
import servlet.helper.RequestHelper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.helper.CreerQuestionnaireHelper;

/**
 *
 * @author marya
 */
public class CreerQuestionnaire extends HttpServlet {
   
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
        String forward = "error.jsp";
        try {

            RequestHelper helper = new RequestHelper(request);
            
           
            String action = request.getParameter("action").toString();

            if (action != null) {
                if (action.equals("applyToCreate")) {
                    helper.setAttributeThemesAndNiveaux();
                    forward = "creerQuestionnaire.jsp";
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
        } catch (Exception e) {
            e.printStackTrace();
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
        response.setContentType("text/html;charset=UTF-8");
        String forward = "error.jsp";
        try {
            CreerQuestionnaireHelper helper = new CreerQuestionnaireHelper(request);
            String action = request.getParameter("action").toString();
            if (action != null) {
                if (action.equals("createQuestionnaire")) {
                    helper.setSessionAttributeNewQuestionnaire();
                    forward = "listeQuestionsByTheme.jsp";
                }else if(action.equals("applyToAddQuestionByTheme")){
                    helper.applyToAddQuestionByTheme();
                    forward = "listeQuestionsByTheme.jsp";
                }else{
                    forward = "creerQuestionnaire.jsp";
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        }
        request.getRequestDispatcher(forward).forward(request, response);
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
