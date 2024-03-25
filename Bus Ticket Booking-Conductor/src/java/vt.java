import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class vt extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        
        ResultSet rs,rs1,rs2;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {   
            HttpSession session=request.getSession(false);  
            String cid=(String)session.getAttribute("cid");

            HttpSession session1=request.getSession();  
            session1.setAttribute("cid",cid);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/obtr","root","ramesh");
            
            String tid=request.getParameter("tid");
            String bid=request.getParameter("bid");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from ticket where t_id='"+tid+"' ");
            rs.last();
            int size = rs.getRow();
            rs.first();    
            
            if(size>0)
            {                                
                rs1 = stmt.executeQuery("select * from payment where py_id='"+rs.getString("py_id")+"' ");
                rs1.last();
                int size1 = rs1.getRow();
                rs1.first();    

                if(size1>0)
                {
                    
                    rs2 = stmt.executeQuery("select * from booking where bo_id='"+rs1.getString("bo_id")+"' and b_id='"+bid+"' ");
                    rs2.last();
                    int size2 = rs2.getRow();
                    rs2.first();    

                    if(size2>0)
                    {
                        out.println("<script>");
                        out.println("alert('Valid Ticket !')\n"
                                + "top.location.href='Conductor'");
                        out.println("</script>");                        
                    }                    
                }                
            }
           else
            {
                out.println("<script>");
                out.println("alert('Ticket Id Not found !')\n"
                        + "top.location.href='Conductor'");
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