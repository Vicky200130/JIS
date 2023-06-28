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
@WebServlet(urlPatterns = {"/new_case_update"})
public class new_case_update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet new_case_update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet new_case_update at " + request.getContextPath() + "</h1>");
            
            String cin = request.getParameter("cin");
            String defendant = request.getParameter("defendant");
            out.println(cin);

            String defendant_address = request.getParameter("defendant_address");
            
            String crime_type = request.getParameter("crime_type");
            String crime_date = request.getParameter("crime_date");
            out.println(crime_date);
            String crime_location = request.getParameter("crime_location");
            String officer = request.getParameter("officer");
            String arrest_date = request.getParameter("arrest_date");
            String judge = request.getParameter("judge");
            String lawyer = request.getParameter("lawyer");
            String starting_date = request.getParameter("starting_date");
            String judgement_date = request.getParameter("judgement_date");
            String case_summary = request.getParameter("case_summary");

            
            out.println("<br></br>");
            
            
            
            
           

            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
            
            PreparedStatement ps = con.prepareStatement("insert into CaseDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            
            ps.setString(1,cin);
            ps.setString(2,defendant);
            ps.setString(3,defendant_address);
            ps.setString(4,crime_type);
            ps.setString(5,crime_date);
            ps.setString(6,crime_location);
            ps.setString(7,officer);
            ps.setString(8,arrest_date);
            ps.setString(9,judge);
            ps.setString(10,lawyer);
            ps.setString(11,starting_date);
            ps.setString(12,judgement_date);
            ps.setString(13,case_summary);
            ps.setString(14,"pending");
            
            
            
            int v = ps.executeUpdate();
            if(v>0)
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
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(new_case_update.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(new_case_update.class.getName()).log(Level.SEVERE, null, ex);
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
