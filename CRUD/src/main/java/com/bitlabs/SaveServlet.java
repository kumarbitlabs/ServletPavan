package com.bitlabs;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String name=request.getParameter("name");
String password=request.getParameter("password");
String email=request.getParameter("email");
String country=request.getParameter("country");

EmpDao dao= new EmpDao();
Emp e=new Emp();
e.setName(name);
e.setPassword(password);
e.setEmail(email);
e.setCountry(country);
//e.setId(id);
int status=0;
try {
	status = dao.save(e);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
if(status>0){
out.print("<p>Record saved successfully!</p>");
request.getRequestDispatcher("index.html").include(request,response);
}else{
out.println("Sorry! unable to save record");
}

out.close();
}

}