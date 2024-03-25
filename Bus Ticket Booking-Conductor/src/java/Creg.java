import java.io.IOException;
import java.lang.Class;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Creg extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PreparedStatement pstmt;
        ResultSet rs;
        response.setContentType("text/html ");
        PrintWriter out = response.getWriter();
        try 
        {
            String id = UUID.randomUUID().toString();
            String a_id = id.substring(0,8);
            String a_fname=request.getParameter("rafname");
            String a_lname=request.getParameter("ralname");
            String a_gen=request.getParameter("ragender");
            String a_gmail=request.getParameter("ragmail");
            String a_pass=request.getParameter("rapass");
            String a_rpass=request.getParameter("rartpass");
            String a_mob=request.getParameter("ramob");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/obtr","root","ramesh");
            
            if(!a_pass.equals(a_rpass) || a_mob.length()!=10)
            {
                if(!a_pass.equals(a_rpass))
                {
                    out.println("<script>");
                    out.println("alert('Confirmation Password Not Matched')");
                    out.println("</script>"); 
                } 
                if(a_mob.length()!=10)
                {
                    out.println("<script>");
                    out.println("alert('Phone number must contain 10 digit only')");
                    out.println("</script>"); 
                }
                
                out.println("<script>");
                    out.println("top.location.href='index.html'");
                    out.println("</script>");
            }
            
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from  Conductor where c_gmail='"+a_gmail+"' ");
            rs.last();
            int size = rs.getRow();
            rs.first();    
            
            if(size>0)
            {
                out.println("<script>");
                out.println("alert('Gmail ID Exist, Please Change it !')\n"
                        + "top.location.href='index.html'");
                out.println("</script>");
            }
            else
            {
                pstmt = con.prepareStatement("insert into conductor values(?,?,?,?,?,?,?)");
                pstmt.setString(1, a_id);
                pstmt.setString(2, a_fname);
                pstmt.setString(3, a_lname);
                pstmt.setString(4, a_gen);
                pstmt.setString(5, a_gmail);
                pstmt.setString(6, a_pass);
                pstmt.setString(7, a_mob);

                int count = pstmt.executeUpdate();
                if(count>0)
                {
                    HttpSession session=request.getSession();  
                    session.setAttribute("cid",a_id);

                    out.println("<script>");
                    out.println("alert('Register Successfull')\n"
                            + "top.location.href='Conductor'");
                    out.println("</script>");

                }
                else
                {
                    out.println("<script>");
                    out.println("alert('Register Unsuccessful!')\n"
                            + "top.location.href='index.html'");
                    out.println("</script>");      
                }
            }
  
                                   
            con.close();                                     
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

    private int ParseInt(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
