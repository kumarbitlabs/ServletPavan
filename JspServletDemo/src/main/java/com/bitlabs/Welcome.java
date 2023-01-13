package com.bitlabs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")  //another way instead of using in web.xml
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
	    PrintWriter pwriter = response.getWriter(); 
	 
	    String name=request.getParameter("usr"); //form field name
	    pwriter.print("Hello "+name+"!");
	    pwriter.print(" <a href='https://www.bitlabs.in/'> Welcome to bitlabs</a>"); 
	}

	

}
