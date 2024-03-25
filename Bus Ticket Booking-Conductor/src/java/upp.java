import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class upp extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        PreparedStatement pstmt;
        ResultSet rs;
        response.setContentType("text/html ");
        PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession(false);  
        String cid=(String)session.getAttribute("cid");

        HttpSession session1=request.getSession();  
        session1.setAttribute("cid",cid);
        
        try 
        {                      
            String agmail=request.getParameter("agmail");
            String amob=request.getParameter("amob");
            String apass=request.getParameter("apass");
            

            
            /*out.println(b_id);
            out.println(aid);
            out.println(b_name);
            out.println(schdate);
            out.println(sp);
            out.println(ep);
            out.println(dt);
            out.println(at);
            out.println(nos);
            out.println(nost);
            out.println(fare);*/
            
                    

            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/obtr","root","ramesh");
  
            
            
            pstmt = con.prepareStatement("Update Conductor set c_gmail='"+agmail+"', c_phone='"+amob+"', c_pass='"+apass+"' where c_id='"+cid+"' ");
                        
            int count = pstmt.executeUpdate();
            if(count>0)
            {
                
                out.println("<script>");
                out.println("alert('Details Update Successfully !')\n"
                        + "top.location.href='Conductor'");
                out.println("</script>"); 
            }
            else
            {
                out.println("<script>");
                out.println("alert('Unknown Error !')\n"
                        + "top.location.href='conductor'");
                out.println("</script>");
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
