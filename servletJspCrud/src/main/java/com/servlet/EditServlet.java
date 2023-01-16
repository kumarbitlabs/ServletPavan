package com.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnection;
import com.dao.EmpDao;
import com.entity.Emp;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eid=req.getParameter("id"); 
		 int id=Integer.parseInt(eid); 
		
		String name= req.getParameter("name");
		String address= req.getParameter("address");
		String contact= req.getParameter("contact");
		String email= req.getParameter("email");
		
		
		EmpDao dao = new EmpDao(DBConnection.getconn());
		
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setAddress(address);
		e.setContact(contact);
		e.setEmail(email);
		
		int status=0;
		HttpSession session= req.getSession();
		
		try {
			status=dao.update(e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		if(status>0){
			System.out.println("Record saved successfully!");
			session.setAttribute("succmsg", "Record saved successfully!");
			resp.sendRedirect("view_Emp.jsp");
			
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
