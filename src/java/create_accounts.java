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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sathish
 */
@WebServlet(urlPatterns = {"/create_accounts"})
public class create_accounts extends HttpServlet {

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
            out.println("<title>Servlet create_accounts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet create_accounts at " + request.getContextPath() + "</h1>");
            
            String name = request.getParameter("name");
            
            String username = request.getParameter("username");
            String hidden_name = request.getParameter("hidden_name");  
            String password = request.getParameter("password");
            
            
            
            out.println(name+" "+username+" "+password+" "+hidden_name);
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
            
//            String query1 = "select Registrar_Password from RegistrarTable";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query1);
            
            if("lawyer".equals(hidden_name))
            {
               PreparedStatement ps = con.prepareStatement("insert into LawyerTable values(?,?,?)");
            
                ps.setString(1,name);
                ps.setString(2,username);
                ps.setString(3,password);
                

                int h = ps.executeUpdate();
                
                if(h>0)
                {
                    out.println("data inserted into lawyer table");
                    //redirect to the lawyer home page
                }
                else{
                    out.println("data not inserted");
                } 
            }
            if("judge".equals(hidden_name))
            {
                 PreparedStatement ps1 = con.prepareStatement("insert into JudgeTable values(?,?,?)");
                 ps1.setString(1,name);
                 ps1.setString(2,username);
                 ps1.setString(3,password);
                 int h1 = ps1.executeUpdate();
                 if(h1>0)
                 {
                     out.println("data inserted into judge table");
                     //redirected to the judge home page
                 }
                 else{
                     out.println("data not inserted");
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
            Logger.getLogger(create_accounts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(create_accounts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(create_accounts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(create_accounts.class.getName()).log(Level.SEVERE, null, ex);
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
