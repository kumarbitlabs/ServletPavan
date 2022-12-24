package com.bitlabs;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class getController extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException {
	
    PrintWriter out = res. getWriter();
	String str1=req.getParameter("uname");
	String str2=req.getParameter("upwd");
	
	out.println(str1);
	out.println(str2);
	
	//System.out.println(str1);
	//System.out.println(str2);
}
}