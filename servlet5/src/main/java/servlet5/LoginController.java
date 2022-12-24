package servlet5;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
      
		
				
		String driver = getServletConfig().getInitParameter("driver");
		String user = getServletConfig().getInitParameter("user");
		String upwd = getServletConfig().getInitParameter("pwd");
		
		PrintWriter out=res.getWriter();
         String uname=req.getParameter("uname");
         String pwd=req.getParameter("upwd");
         
         DaoImpl dao=new DaoImpl(driver,user,upwd);
         
         
         boolean b=dao.validate(uname, pwd);
         
         if(b) {
               RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
               rd.forward(req, res);
                }
         else{
               RequestDispatcher rd=req.getRequestDispatcher("/index.html");
               rd.include(req, res);
               out.println("<body> Invalid username/password</body>");
               System.out.println("invalid username");
         }
    }
}