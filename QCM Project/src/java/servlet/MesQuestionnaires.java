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
import servlet.helper.MesQuestionnairesHelper;
import servlet.helper.RequestHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marya
 */
public class MesQuestionnaires extends HttpServlet {
   
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
         String forward = "error.jsp";
        try {

            MesQuestionnairesHelper helper = new MesQuestionnairesHelper(request);


            String action = request.getParameter("action").toString();

            if (action != null) {
                if (action.equals("getCreatedQuestionnaires")) {
                    helper.setAttributeCreatedQuestionnairesByUser();
                    forward = "mesQuestionnaires.jsp";
                }else if(action.equals("getCreadtedQuestionnaire")){
                    helper.setAttributeEditableQuestionnaire();
                    forward = "afficherInfoQuestionnaire.jsp";
                }
            }





            
        } catch (IllegalStateException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (NullPointerException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (SQLException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (IOException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (ExpiredSessionException e) {
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "index.jsp";
        } catch (NumberFormatException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (UnauthorizedActionException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
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
         String forward = "error.jsp";
        try {

           MesQuestionnairesHelper helper = new MesQuestionnairesHelper(request);


            String action = request.getParameter("action").toString();

            if (action != null) {
                if (action.equals("getInfoCreatedQuestionnaire")) {
                    helper.setAttributeInfoQuestionnaire();
                    forward = "afficherInfoQuestionnaire.jsp";
                }
            }

        } catch (IllegalStateException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (NullPointerException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (SQLException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (IOException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        } catch (ExpiredSessionException e) {
            Logger.getLogger(MesQuestionnaires.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
            forward = "index.jsp";
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
