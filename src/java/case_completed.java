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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sathish
 */
@WebServlet(urlPatterns = {"/case_completed"})
public class case_completed extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet case_completed</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet case_completed at " + request.getContextPath() + "</h1>");
            
            String cin = request.getParameter("cin");
            String final_judgement_date = request.getParameter("final_judgement_date");
            String case_status = request.getParameter("case_status");
            String judge = request.getParameter("judge");
            String final_case_summary = request.getParameter("final_case_summary");
            
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
            
            
            PreparedStatement ps = con.prepareStatement("insert into CaseCompleted values(?,?,?,?,?)");
                
            ps.setString(1,cin);
            ps.setString(2,final_judgement_date);
            ps.setString(3,case_status);
            ps.setString(4,judge);
            ps.setString(5,final_case_summary);
            
            
            int s = ps.executeUpdate();            
            if(s>0)
            {
                out.println("<h1> data inserted </h1>");
//                String query = "select * from t;";
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery(query);
//                //display
//                while(rs.next())
//                {
//                    String names = rs.getString("uname");
//                    out.println(names);
//                }
//                response.sendRedirect("new.html");
            }
            else{
                out.println("<h1> no data  </h1>");
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
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest((HttpServletRequest) request, response);
        } catch (SQLException ex) {
            Logger.getLogger(old_case_update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(old_case_update.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest((HttpServletRequest) request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(case_completed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(case_completed.class.getName()).log(Level.SEVERE, null, ex);
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
