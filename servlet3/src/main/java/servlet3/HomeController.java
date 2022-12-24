package servlet3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HomeController extends HttpServlet{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        
       /* PrintWriter out=res.getWriter();
        out.print("<body> welcome to home controller </body>");
        */
        
        RequestDispatcher rd=req.getRequestDispatcher("/index.html");
                rd.forward(req, res);
    }



}
