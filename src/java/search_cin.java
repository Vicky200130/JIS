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
@WebServlet(urlPatterns = {"/search_cin"})
public class search_cin extends HttpServlet {

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
            out.println("<head>");
            out.println("<title>Servlet search_cin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search_cin at " + request.getContextPath() + "</h1>");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
            String cin_str = request.getParameter("search_cin");
            int cin_no = Integer.parseInt(cin_str);
            
            String query = "select CIN,Case_Status,judgement_Date from CaseDetails;";
            String query2 = "select CIN,Case_Status,Final_Judgement_Date from CaseCompleted;";
            
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query2);
            int count = 0;
            
            while(rs2.next())
            {
                int cin2 = rs2.getInt("CIN");
                String case_status2 = rs2.getString("Case_Status");
                String Final_Judgement_Date2 = rs2.getString("Final_Judgement_Date");
                if(cin2 == cin_no)
                {
                    count = 1;
                    out.println(cin2);
                    out.println(case_status2);
                    out.println("Final Judgement Date : "+Final_Judgement_Date2);
                }
            }    
            if(count == 0)
            {
                while(rs.next())
                {
                    int cin = rs.getInt("CIN");
                    String case_status = rs.getString("Case_Status");
                    String Judgement_Date = rs.getString("judgement_Date");
                    if(cin == cin_no)
                    {
                        count = 1;
                        out.println(cin);
                        out.println(case_status);
                        out.println("Judgement Date : "+Judgement_Date);
                    }
                }
            }
            if(count == 0)
            {
                out.println("no case found");
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
  protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest((HttpServletRequest) request, response);
        } catch (SQLException ex) {
            Logger.getLogger(old_case_update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search_cin.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest((HttpServletRequest) request, response);
        } catch (SQLException ex) {
            Logger.getLogger(old_case_update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search_cin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
