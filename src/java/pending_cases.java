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
@WebServlet(urlPatterns = {"/pending_cases"})
public class pending_cases extends HttpServlet {

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
            
            
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
            String query = "select Distinct CaseDetails.CIN,CaseDetails.Defendant_Name,CaseDetails.Defendant_Address,CaseDetails.Crime_Type,CaseDetails.Crime_Date,CaseDetails.Crime_Location,CaseDetails.Officer_Name,CaseDetails.Arrest_Date,CaseDetails.Judge_Name,CaseDetails.Lawyer_Name,CaseDetails.Starting_Date,CaseDetails.judgement_Date,CaseDetails.Case_Summary from CaseDetails join CaseDetailsUpdating where CaseDetails.CIN = CaseDetailsUpdating.CIN;";
            
            Statement st = con.createStatement();
            out.println("<br><br><h1 align='center'>Pending Cases</h1>");
            ResultSet rs = st.executeQuery(query);
            out.println("<table class='case-pending-table' border='1' cellpadding='3'> <tr><th>");
            
            out.println("CIN </th><th>");
            out.println("Defendant Name </th><th>");
            out.println("defendant Address </th><th>");
            out.println("crime Type </th><th>");
            out.println("crime Date </th><th>");
            out.println("crim Location </th><th>");
            out.println("Officer Name </th><th>");
            out.println("Arrest Date </th><th>");
            out.println("Judge </th><th>");
            out.println("Lawyer </th><th>");
            out.println("Starting Date </th><th>");
            out.println("Judgement Date </th><th>");
            out.println("Case Summary </th></tr>");
            
            
                while(rs.next())
                {
                    int cin = rs.getInt("CaseDetails.CIN");
                    String defendant_name = rs.getString("CaseDetails.Defendant_Name");
                    String defendant_address = rs.getString("CaseDetails.Defendant_Address");
                    String crime_type = rs.getString("CaseDetails.Crime_Type");
                    String crime_date = rs.getString("CaseDetails.Crime_Date");
                    String crime_location = rs.getString("CaseDetails.Crime_Location");
                    String officer = rs.getString("CaseDetails.Officer_Name");
                    String arrest_date = rs.getString("CaseDetails.Arrest_Date");
                    String judge = rs.getString("CaseDetails.Judge_Name");
                    String lawyer = rs.getString("CaseDetails.Lawyer_Name");
                    String starting_date = rs.getString("CaseDetails.Starting_Date");
                    String judgement_date = rs.getString("CaseDetails.Judgement_Date");
                    String case_summary = rs.getString("CaseDetails.Case_Summary");
                    
                    out.println("<tr><td>"+cin+"</td><td>");
                    out.println(defendant_name+"</td><td>");
                    out.println(defendant_address+"</td><td>");
                    out.println(crime_type+"</td><td>");
                    out.println(crime_date+"</td><td>");
                    out.println(crime_location+"</td><td>");
                    out.println(officer+"</td><td>");
                    out.println(arrest_date+"</td><td>");
                    out.println(judge+"</td><td>");
                    out.println(lawyer+"</td><td>");
                    out.println(starting_date+"</td><td>");
                    out.println(judgement_date+"</td><td>");
                    out.println(case_summary+"</td></tr>");
                }
            
            
            out.println("</table></div></body>");
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
            Logger.getLogger(pending_cases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pending_cases.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pending_cases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pending_cases.class.getName()).log(Level.SEVERE, null, ex);
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
