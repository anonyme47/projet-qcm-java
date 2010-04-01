/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Questionnaire;
import util.QuestionnaireDAO;
import util.ThemeDAO;

/**
 *
 * @author marya
 */
public class Warning extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Questionnaire</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Questionnaire at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally {
            out.close();
        }
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
               System.out.println("Avant appel DAO");
                Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
                request.setAttribute("questionnaire", questionnaire);
                //request.setAttribute("theme",ThemeDAO.getById(questionnaire.getIdTheme()).getLibelle());
                //request.setAttribute("theme",NiveauDAO.getById(questionnaire.getIdNiveau()).getLibelle());
                System.out.println("questionnaire"+questionnaire.toString());
                request.setAttribute("theme","Theme");
                request.setAttribute("niveau","niveau");
                request.getRequestDispatcher("warning.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(SQLException e){
            request.setAttribute("errorMessage", "Erreur interne :"+e.getMessage());
            request.getRequestDispatcher("warning.jsp").forward(request, response);
        }catch(NullPointerException e){
            request.setAttribute("errorMessage", "Erreur :"+e.getMessage());
            request.getRequestDispatcher("warning.jsp").forward(request, response);
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
