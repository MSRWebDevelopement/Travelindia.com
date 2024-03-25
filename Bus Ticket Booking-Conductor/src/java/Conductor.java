
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Conductor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession(false);  
        String cid=(String)session.getAttribute("cid");
        
        HttpSession session1=request.getSession();  
        session1.setAttribute("cid",cid);
                
        try
        {
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/obtr","root","ramesh");
           
            String lag=request.getParameter("lagmail");
            String lap=request.getParameter("lapass"); 

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from  conductor where c_id='"+cid+"' ");
            rs.last();
            int size = rs.getRow();
            rs.first();    
            
            if(size==1)
            {
                String fn=rs.getString("c_fname");
                String ln=rs.getString("c_lname");
                
                out.println("<html>\n" +
    "	<head>\n" +
    "	<meta charset=\"utf-8\">\n" +
    "	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
    "	<title>TRAVEL INDIA</title>\n" +
    "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
    "	<meta name=\"description\" content=\"Free HTML5 Website Template by FreeHTML5.co\" />\n" +
    "	<meta name=\"keywords\" content=\"free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive\" />\n" +
    "	<meta name=\"author\" content=\"FreeHTML5.co\" />\n" +
    "\n" +
    "  	<!-- Facebook and Twitter integration -->\n" +
    "	<meta property=\"og:title\" content=\"\"/>\n" +
    "	<meta property=\"og:image\" content=\"\"/>\n" +
    "	<meta property=\"og:url\" content=\"\"/>\n" +
    "	<meta property=\"og:site_name\" content=\"\"/>\n" +
    "	<meta property=\"og:description\" content=\"\"/>\n" +
    "	<meta name=\"twitter:title\" content=\"\" />\n" +
    "	<meta name=\"twitter:image\" content=\"\" />\n" +
    "	<meta name=\"twitter:url\" content=\"\" />\n" +
    "	<meta name=\"twitter:card\" content=\"\" />\n" +
    "\n" +
    "	\n" +
    "	<!-- Animate.css -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/animate.css\">\n" +
    "	<!-- Icomoon Icon Fonts-->\n" +
    "	<link rel=\"stylesheet\" href=\"css/icomoon.css\">\n" +
    "	<!-- Themify Icons-->\n" +
    "	<link rel=\"stylesheet\" href=\"css/themify-icons.css\">\n" +
    "	<!-- Bootstrap  -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
    "\n" +
    "	<!-- Magnific Popup -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n" +
    "\n" +
    "	<!-- Magnific Popup -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.min.css\">\n" +
    "\n" +
    "	<!-- Owl Carousel  -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n" +
    "	<link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n" +
    "\n" +
    "	<!-- Theme style  -->\n" +
    "	<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
    "\n"+
    
    "	<!-- Modernizr JS -->\n" +
    "	<script src=\"js/modernizr-2.6.2.min.js\"></script>\n" +
    "	<!-- FOR IE9 below -->\n" +
    "	<!--[if lt IE 9]>\n" +
    "	<script src=\"js/respond.min.js\"></script>\n" +
    "	<![endif]-->\n" +
    "	<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
    "        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n" +
    "        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n" +
    "\n" +
    "	</head>\n" +
    "	<body>\n"+
                        "<div id=\"google_translate_element\"></div>"+
    "		\n" +
    "	<div class=\"gtco-loader\"></div>\n" +
    "	\n" +
    "	<div id=\"page\">\n" +
    "\n" +
    "	\n" +
"	<!-- <div class=\"page-inner\"> -->\n" +
"	<nav class=\"gtco-nav\" role=\"navigation\">\n" +
"		<div class=\"gtco-container\">\n" +
"			\n" +
"			<div class=\"row\">\n" +
"				<div class=\"col-sm-4 col-xs-12\">\n" +
"					<div id=\"gtco-logo\"><img height=\"40px\" width=\"40px\" src=\"https://img.icons8.com/dusk/64/000000/bus--v2.png\"/><a href=\"User\">TRAVEL INDIA </a></div>\n" +
"				</div>\n" +
"				<div class=\"col-xs-8 text-right menu-1\">\n" +
"					<ul>\n" +	
"                                            <li><a href=\"Conductor\" title='Home'>Home</a></li>\n" +                        
"                                            <li><a href=\"cprof\" title='My Profile'>"+fn+" "+ln+"</a></li>\n" +                    
"                                            <li><a href=\"Logout\" title='Logout'>Logout</a></li>\n" +
"					</ul>	\n" +
"				</div>\n" +
"			</div>\n" +
"			\n" +
"		</div>\n" +
"	</nav>\n" +
    "	\n" +
    "	<header id=\"gtco-header\" class=\"gtco-cover gtco-cover-md\" role=\"banner\" style=\"background-image: url(images/admin_login.jpg)\">\n" +
    "		<br><br><br><br><br><br>"

        + "<div class=\"overlay\"></div>\n" +
    "		<div class=\"gtco-container\">\n" +
    "			<div class=\"row\">\n" +
    "				<div class=\"col-md-12 col-md-offset-0 text-left\">\n" +
    "					\n" +
    "\n" +
    "					<div class=\"row\">\n" +
    "						<div class=\"col-md-4 col-md-push-1 animate-box\" data-animate-effect=\"fadeInRight\">\n" );
                
                out.println("<div class='form-wrap'><div class='tab'><div class='tab-content'><div class='tab-content-inner active' data-content='signup'><h3>Verify Ticket</h3><form action='vt' method='post'><br><div class='row form-group'><div class='col-md-12'><label for='activities'>Enter Bus Number</label><input id='bid' type='text' name='bid' class='form-control' required></div></div>      <div class='row form-group'><div class='col-md-12'><label for='activities'>Enter Ticket ID</label><input id='tid' type='text' name='tid' class='form-control' required></div></div>       <div class='row form-group'><div class='col-md-12'><input type='submit' class='btn btn-primary btn-block' value='VERIFY'></div></div></form></div></div></div></div>");
                
                out.println(
"						</div>\n" +
            
    "                                            \n" +
    "                                                <div id='opt' class='col-md-4 col-md-push-1 animate-box' data-animate-effect='fadeInRight'>\n" +
    "                                                </div>  \n" +
    "                                            \n" +
    "                                                <div id='opt1' class='col-md-4 col-md-push-1 animate-box' data-animate-effect='fadeInRight'>\n" +
    "                                                </div>\n" +
    "                                            \n" +
    "					</div>\n" +
    "							\n" +
    "					\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</header>\n" +
    "	\n" +
    "\n" +
    "\n" +
    "	</div>\n" +
    "\n" +
    "	<div class=\"gototop js-top\">\n" +
    "		<a href=\"#\" class=\"js-gotop\"><i class=\"icon-arrow-up\"></i></a>\n" +
    "	</div>\n" +
    "	\n" +
    "	<!-- jQuery -->\n" +
    "	<script src=\"js/jquery.min.js\"></script>\n" +
    "	<!-- jQuery Easing -->\n" +
    "	<script src=\"js/jquery.easing.1.3.js\"></script>\n" +
    "	<!-- Bootstrap -->\n" +
    "	<script src=\"js/bootstrap.min.js\"></script>\n" +
    "	<!-- Waypoints -->\n" +
    "	<script src=\"js/jquery.waypoints.min.js\"></script>\n" +
    "	<!-- Carousel -->\n" +
    "	<script src=\"js/owl.carousel.min.js\"></script>\n" +
    "	<!-- countTo -->\n" +
    "	<script src=\"js/jquery.countTo.js\"></script>\n" +
    "\n" +
    "	<!-- Stellar Parallax -->\n" +
    "	<script src=\"js/jquery.stellar.min.js\"></script>\n" +
    "\n" +
    "	<!-- Magnific Popup -->\n" +
    "	<script src=\"js/jquery.magnific-popup.min.js\"></script>\n" +
    "	<script src=\"js/magnific-popup-options.js\"></script>\n" +
    "	\n" +
    "	<!-- Datepicker -->\n" +
    "	<script src=\"js/bootstrap-datepicker.min.js\"></script>\n" +
    "	\n" +
    "\n" +
    "	<!-- Main -->\n" +
    "	<script src=\"js/main.js\"></script>\n"+
    "\n"
        + "<script type=\"text/javascript\">\n" +
"function googleTranslateElementInit() {\n" +
"  new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element');\n" +
"}\n" +
"</script>\n" +
"\n" +
"<script type=\"text/javascript\" src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>");

                out.println("<script>");
                out.println("$(\"#ab\").click(function(event) {");
                out.println("$('#opt').val('ab');");
                out.println("}); ");
                out.println("</script>"); 

                out.println("<script>");
                out.println("$(\"#ub\").click(function(event) {");
                out.println("$('#opt').val('ub');");
                out.println("}); ");
                out.println("</script>"); 

                out.println("<script>");
                out.println("$(\"#db\").click(function(event) {");
                out.println("$('#opt').val('db');");
                out.println("}); ");
                out.println("</script>"); 

                out.println("<script>");
                out.println("$(\"#mb\").click(function(event) {");
                out.println("$('#opt').val('mb');");
                out.println("}); ");
                out.println("</script>"); 

                out.println("<script>");
                out.println("$(\"#vt\").click(function(event) {");
                out.println("$('#opt').val('vt');");
                out.println("}); ");
                out.println("</script>"); 

                out.println("</body></html>");
            }

        }
        catch(Exception e)
        {
            out.println(e);
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
