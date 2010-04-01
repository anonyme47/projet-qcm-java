/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

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
        try{
           if(request.getSession().getAttribute("user")!=null){
                request.getRequestDispatcher("accueil.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            request.setAttribute("errorMessage", "Vous n'êtes pas authentifié");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        User user= null;
        String errorMessage = null;
        String page = "index.jsp";
        try {
            int authentification = Integer.parseInt(request.getParameter("authentification").toString());
            if(authentification != 1){
                errorMessage = "Authentification non initialisée";
            }else{
                String login=request.getParameter("login").toString();
                String password=request.getParameter("password").toString();
                if(login==null || login.trim().isEmpty()){
                    throw new IllegalArgumentException("Veuillez renseigner votre login");
                }else if(password==null || password.trim().isEmpty()){
                    throw new IllegalArgumentException("Veuillez renseigner votre mot de passe");
                }
                user= UserDAO.getByLoginAndPassword(login, password);
                if(user==null){
                    errorMessage = "Echec de l'authentification, login ou mot de passe incorrecte.";
                }else{
                    request.getSession().setAttribute("user",user);
                    page="accueil.jsp";
                }
            }
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
/*
 * TODO
 * rajouter la page error_authentification
 * qu'est ce qu'il y a à mettre dans la variable de session concernant l'utilisateur?
 */
