package servlet4;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DivController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		String n1=req.getParameter("num1");
		String n2=req.getParameter("num2");
		
		int a =Integer.parseInt(n1);
		int b =Integer.parseInt(n2);
		
		
		try {
			PrintWriter out = null;
			out = res.getWriter();
			out.println("<body><h1>division is:"+(a/b)+"</h1></body> ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}

