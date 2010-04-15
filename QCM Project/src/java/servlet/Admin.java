package servlet;

import exception.ExpiredSessionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.helper.AdminHelper;
import servlet.helper.RequestHelper;

/**
 *
 * @author Lou
 */
public class Admin extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String forward = "index.jsp";
        try {
            AdminHelper helper = new AdminHelper(request);
            RequestHelper requestHelper = new RequestHelper(request);
            String action = request.getParameter("action").toString();
            if (action != null) {
                if (action.equals("gererThemes")) {
                    requestHelper.setAttributeThemes();
                    forward = "gererThemes.jsp";
                } else if (action.equals("gererNiveaux")) {
                    requestHelper.setAttributeNiveaux();
                    forward = "gererNiveaux.jsp";
                } else if (action.equals("gererUtilisateurs")) {
                    helper.setUsers();
                    forward = "gererUtilisateurs.jsp";
                } else if (action.equals("gererQuestionnaires")) {
                    helper.setQuestionnaires();
                    forward = "gererQuestionnaires.jsp";
                } else if (action.equals("editNiveau")) {
                    helper.setAttributeNiveau();
                    forward = "editNiveau.jsp";
                } else if (action.equals("editTheme")) {
                    helper.setAttributeTheme();
                    forward = "editTheme.jsp";
                }
            } else {
                forward = "index.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExpiredSessionException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Vous n'êtes pas authentifié");
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String forward = "index.jsp";
        try {
            AdminHelper helper = new AdminHelper(request);
            RequestHelper requestHelper = new RequestHelper(request);
            String action = request.getParameter("action").toString();
            if (action != null) {
                if (action.equals("controleQuestionnaire")) {
                    helper.controleQuestionnaire();
                    helper.setQuestionnaires();
                    forward = "gererQuestionnaires.jsp";
                } else if (action.equals("controleNiveau")) {
                    helper.controleNiveau();
                    requestHelper.setAttributeNiveaux();
                    forward = "gererNiveaux.jsp";
                } else if (action.equals("controleTheme")) {
                    helper.controleTheme();
                    requestHelper.setAttributeThemes();
                    forward = "gererThemes.jsp";
                } else if (action.equals("editTheme")) {
                    helper.editTheme();
                    helper.setAttributeThemes();
                    forward = "gererThemes.jsp";
                } else if (action.equals("editNiveau")) {
                    helper.editNiveau();
                    helper.setAttributeNiveaux();
                    forward = "gererNiveaux.jsp";
                } else if (action.equals("controleUser")) {
                    helper.controleUser();
                    helper.setUsers();
                    forward = "gererUtilisateurs.jsp";
                }
            } else {
                forward = "index.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExpiredSessionException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Vous n'êtes pas authentifié");
        } catch (IllegalArgumentException e) {
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
