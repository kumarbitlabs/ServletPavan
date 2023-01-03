package servlet6;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
      
		String driver = getServletConfig().getServletContext().getInitParameter("driver");
		String user = getServletConfig().getServletContext().getInitParameter("user");
		String upwd = getServletConfig().getServletContext().getInitParameter("pwd");
		DaoImpl dao=new DaoImpl(driver,user,upwd);
         
        
         dao.viewAllUsers();
         
         
    }
}


