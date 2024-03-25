import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Clogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/obtr","root","ramesh");
           
            String lag=request.getParameter("lagmail");
            String lap=request.getParameter("lapass"); 
                        
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from  conductor where c_gmail='"+lag+"' and c_pass='"+lap+"'");
            rs.last();
            int size = rs.getRow();
            rs.first();    
            
            if(size==1)
            {
                HttpSession session=request.getSession();  
                session.setAttribute("cid",rs.getString("c_id"));
                out.println("<script>");
                out.println("alert('Login Successfull')\n"
                        + "top.location.href='Conductor'");
                out.println("</script>");   
            }
            else
            {
                out.println("<script>");
                out.println("alert('Invalid User')\n"         
                        + "top.location.href='index.html'");
                out.println("</script>"); 
  
            }                       
        }
        catch(Exception e)
        {
            out.println(e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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