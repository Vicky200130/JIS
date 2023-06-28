/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String hidden_name = request.getParameter("hidden_name");
            
            out.println(username);
            out.println(password);
            out.println(hidden_name);
            
            //session variables needed to add here....
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis","root","Sathish@123");
          
            
            
            if("registrar".equals(hidden_name))
            {
                out.println("11111");
                String query1 ="select * from RegistrarTable"; 
                Statement st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery(query1);
                while(rs1.next())
                {
                    String registrar_username = rs1.getString("Registrar_Username");
                    String registrar_password = rs1.getString("Registrar_Password");
                    if(username.equals(registrar_username))
                    {
                        if(password.equals(registrar_password))
                        {
                            //redirect page
                            out.println("entered into registrar login page");
                            response.sendRedirect("home.html");
                        }
                        else{
                            out.println("registrar Password not correct");
                        }
                    }
                    
                }
                out.println("----");
                
            }
            else if("lawyer".equals(hidden_name))
            {
                out.println("222222");
                String query2 ="select * from LawyerTable";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                while(rs2.next())
                {
                    String lawyer_username = rs2.getString("Lawyer_Username");
                    String lawyer_password = rs2.getString("Lawyer_Password");
                    if(username.equals(lawyer_username))
                    {
                        if(password.equals(lawyer_password))
                        {
                            //redirect page
                            out.println("entered into Lawyer login page //redirected");
                            break;
                        }
                        else{
                            out.println("Lawyer Password not correct");
                        }
                    }
                    
                }
            }
            else if("judge".equals(hidden_name))
            {
                out.println("3333333");
                String query3 ="select * from JudgeTable";
                Statement st3 = con.createStatement();
                out.println("3333333");
                ResultSet rs3 = st3.executeQuery(query3);
                while(rs3.next())
                {
                    String judge_username = rs3.getString("Judge_Username");
                    String judge_password = rs3.getString("Judge_Password");
                    if(username.equals(judge_username))
                    {
                        if(password.equals(judge_password))
                        {
                            //redirect page
                            out.println("entered into Judge login page //redirected");
                            break;
                        }
                        else{
                            out.println("Judge Password not correct");
                        }
                    }
                    
                }
            }
            
            out.println("Please Register");
            
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
