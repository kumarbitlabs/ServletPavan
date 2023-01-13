package com.bitlabs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")  //annontation another way to use in web.xml
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			 if(con!=null) {
			    	System.out.println("Done");
			    }
			String n=request.getParameter("usr");
			String p=request.getParameter("pwd");
			PreparedStatement pstmt= con.prepareStatement ("select * from Login where username=? and passwd=?");//database field names
		     pstmt.setString(1, n);
		     pstmt.setString(2, p);
		     ResultSet rs= pstmt.executeQuery();
		     //out.println("connected to servlet");
		     if(rs.next())
		     {
		    	 if(n.equals("pavan"))
			            
		          {          
		             RequestDispatcher rd=request.getRequestDispatcher("Welcome");  //calling Welcome servlet       
		             rd.forward(request, response);      
		          }
		     }
		         
		     /*
		     if(rs.next())
		     {
		    	 RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		    	 rd.forward(request, response);
		     }
		     */
		     else {
		    	 out.println("<font color='red' size=10> Login failed");
		    	 out.println("<a href='Login.jsp'>Try Again</a>");
		     }
		} catch (Exception e) {
						
			out.println(e);
		}
	}

}
