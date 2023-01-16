package com.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnection;
import com.dao.EmpDao;

import com.entity.Emp;


@WebServlet("/searchservlet")
public class searchservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Get the search term from the form
        String searchname = req.getParameter("searchname");
        
        // Validate the search term 
        if(searchname == null){
            req.setAttribute("error", "Search term is required");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        
        EmpDao dao = new EmpDao(DBConnection.getconn());
        
       
		HttpSession session= req.getSession();
		List<Emp> status=Collections.emptyList();
		try {
			 status=dao.getEmployeeByName(searchname);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		if(!status.isEmpty()){
			
			req.setAttribute("employees", status);

	        // Forward the request to the JSP page
	        req.getRequestDispatcher("search.jsp").forward(req, resp);
			
			//session.setAttribute("record", status);
			//resp.sendRedirect("search.jsp");
			
			//out.print("<p>Record saved successfully!</p>");
			//req.getRequestDispatcher("index.html").include(request,response);
			}else{
				System.out.println("some thing went wrong!");
				session.setAttribute("errormsg", "some thing went wrong!");
				resp.sendRedirect("view_Emp.jsp");
				
				
			//out.println("Sorry! unable to save record");		
		
	}
        
    }



		
		
		
		
	}

	
	

