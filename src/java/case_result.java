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
@WebServlet(urlPatterns = {"/case_result"})
public class case_result extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
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
            
            //getting form data
            String case_cin_str = request.getParameter("case_cin");
            int case_cin = Integer.parseInt(case_cin_str);
            out.println(case_cin);
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
           
            String query = "select * from CaseDetails;";
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
           
             while(rs.next())
             {
                int cin = rs.getInt("CIN");
                if(cin == case_cin)
                {    
                    
                    String defendant_name = rs.getString("Defendant_Name");
                    String defendant_address = rs.getString("Defendant_Address");
                    String crime_type = rs.getString("Crime_Type");
                    String crime_date = rs.getString("Crime_Date");
                    String crime_location = rs.getString("Crime_Location");
                    String officer = rs.getString("Officer_Name");
                    String arrest_date = rs.getString("Arrest_Date");
                    String judge = rs.getString("Judge_Name");
                    String lawyer = rs.getString("Lawyer_Name");
                    String starting_date = rs.getString("Starting_Date");
                    String judgement_date = rs.getString("Judgement_Date");
                    String case_summary = rs.getString("Case_Summary");
                    
                    //printing case result
                    out.println(cin);
                    out.println(defendant_name);
                    out.println(defendant_address);
                    out.println(crime_type);
                    out.println(crime_date);
                    out.println(crime_location);
                    out.println(officer);
                    out.println(arrest_date);
                    out.println(judge);
                    out.println(lawyer);
                    out.println(starting_date);
                    out.println(judgement_date);
                    out.println(case_summary);
                    
                }
             }
            
            out.println("</body>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(case_result.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(case_result.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(case_result.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(case_result.class.getName()).log(Level.SEVERE, null, ex);
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
