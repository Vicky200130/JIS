/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sathish
 */
@WebServlet(urlPatterns = {"/search_cases"})
public class search_cases extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>\n" +
"        <title>updating old case</title>\n" +
"        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n" +
"        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\n" +
"        <link rel=\"stylesheet\" href=\"JIS.css\" >\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"      <nav class=\"navbar navbar-expand-lg navbar-dark NAVBAR\">\n" +
"        <a class=\"navbar-brand\" href=\"#\">\n" +
"            <img src=\"/home/apiiit-rkv/Pictures/highcourt_logo.jpeg\" width=\"50\" height=\"50\" class=\"d-inline-block align-top\" alt=\"\" loading=\"lazy\">\n" +
"\n" +
"        </a>\n" +
"        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"          <span class=\"navbar-toggler-icon\"></span>\n" +
"        </button>\n" +
"        <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n" +
"          <div class=\"navbar-nav ml-auto\">\n" +
"            <ul class=\"navbar-nav mr-auto\">\n" +
"                <li class=\"nav-item mr-3\">\n" +
"                    <a class=\"nav-link NAVLINK\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" +
"                </li>\n" +
"                <li class=\"nav-item dropdown mr-3\">\n" +
"                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
"                      Cases\n" +
"                    </a>\n" +
"                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
"                      <a class=\"dropdown-item \" href=\"#\">New Case File</a>\n" +
"                      <a class=\"dropdown-item active\" href=\"#\">Update old case</a>\n" +
"                      \n" +
"                      <a class=\"dropdown-item \" href=\"#\">Case completion</a>\n" +
"                    </div>\n" +
"                  </li>\n" +
"                <li class=\"nav-item mr-3\">\n" +
"                    <a class=\"nav-link NAVLINK\" href=\"#\">Case Status</a>\n" +
"                  </li>\n" +
"                  <li class=\"nav-item mr-3\">\n" +
"                    <a class=\"nav-link NAVLINK\" href=\"#\">Calender</a>\n" +
"                  </li>\n" +
"                  <li class=\"nav-item dropdown mr-3\">\n" +
"                    <a class=\"nav-link dropdown-toggle NAVLINK\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
"                      Account Management\n" +
"                    </a>\n" +
"                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
"                      <a class=\"dropdown-item\" href=\"#\">Account Creation</a>\n" +
"                      <a class=\"dropdown-item\" href=\"#\">Delete Account</a>\n" +
"                      <div class=\"dropdown-divider\"></div>\n" +
"                      <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n" +
"                    </div>\n" +
"                  </li>\n" +
"                  <li class=\"nav-item mr-3\">\n" +
"                    <a class=\"nav-link NAVLINK\" href=\"#\">print</a>\n" +
"                  </li>\n" +
"               </ul>\n" +
"            \n" +
"\n" +
"            \n" +
"          </div>\n" +
"        </div>\n" +
"      </nav>");
            
            out.println("<br><br><h1 align='center'>***Result***</h1>");
            out.println("<table align='center' class='case-pending-table' border='1' cellpadding='3'> <tr><th>");
            out.println("CIN </th><th>");
            out.println("Case Summary </th></tr>");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
            String search_case = "%"+request.getParameter("search_case")+"%";
            out.println("<br>"+search_case);
            
            String query = "select CIN,Final_Case_Summary from CaseCompleted where Final_Case_Summary LIKE '"+search_case+"' ;";
            
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            // form to send cin number to show case result
            
            int count_cases = 0;
            
            while(rs.next())
                {
                    count_cases++ ;
                    out.println("<form action='case_result' method='get'>");
                    int cin = rs.getInt("CIN");
                    String case_summary = rs.getString("Final_Case_Summary");
                    out.println("<input type='hidden' name='case_cin' value='"+cin+"'>");
                    out.println("<tr><td><button type='submit'>"+cin+"</button></td><td>");
                    out.println(case_summary+"</td></tr>"
                            + "</form>");
                        
                }
            if(count_cases == 0)
            {
                out.println("<tr><td  colspan='2'> No Case Found based on the Keyword</td></tr>");
            }
            
            out.println("</table></body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(search_cases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search_cases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(search_cases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search_cases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
