/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import exception.QcmException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.User;
import util.UserDAO;

/**
 *
 * @author marya
 */
public class Accueil extends HttpServlet {

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
        try {
            String action = request.getParameter("action");
            if (action.equals("logout")) {
                request.getSession().invalidate();
            } else if (request.getSession().getAttribute("user") != null) {
                request.getRequestDispatcher("accueil.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Vous n'êtes pas authentifié");
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Erreur : " + e.getMessage());
        }
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
        System.out.println("Trace: doPost§");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String errorMessage = null;
        String page = "error.jsp";
        try {
            String action = request.getParameter("action");
            if (action.equals("authentification")) {
                System.out.println("Avant le check user");
                page = checkUser(request);
                System.out.println("Après le check user");
            }
        } catch (SQLException e) {
            errorMessage = e.getMessage();
        } catch (IllegalStateException e) {
            errorMessage = e.getMessage();
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        } catch (NullPointerException e) {
            errorMessage = e.getMessage();
        } catch (Exception e) {
            errorMessage = e.getMessage();
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
        return "Short description : " + this.getServletInfo();
    }// </editor-fold>

    public String checkUser(HttpServletRequest request) throws SQLException , Exception{
        String page = "error.jsp";
        User user = null;
        String login = request.getParameter("login").toString();
        String password = request.getParameter("password").toString();
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Veuillez renseigner votre login");
        } else if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Veuillez renseigner votre mot de passe");
        }
        user = UserDAO.getByLoginAndPassword(login, password);
        if (user == null) {
            throw QcmException.UnknownUserException;
        } 
        request.getSession().setAttribute("user", user);
        page = "accueil.jsp";
        
        return page;
    }
}

