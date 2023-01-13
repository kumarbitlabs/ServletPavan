package sessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("welcome to first name: "+fname);
		out.println("welcome to last name: "+lname);
		
		//now we want to make another request through servlet2
		
		
		out.println("<a href='servlet2'>servlet2 </a>");//href is always get request
		
		//now without using HttpSession these are not available in servlet2
		//in servlet2 override doGet() method
		
		HttpSession session = req.getSession();
		session.setAttribute("firstname", fname);
		session.setAttribute("lastname", lname);
		
	   // req.setAttribute("n", fname);
		
		//RequestDispatcher rd=req.getRequestDispatcher("servlet2");
		//rd.forward(req,resp);
		
			
	}
	
	

}
