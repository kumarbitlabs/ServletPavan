package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnection;
import com.dao.EmpDao;
import com.entity.Emp;


@WebServlet("/delete")
public class deleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id"); 
		 int id=Integer.parseInt(sid); 
		 EmpDao dao = new EmpDao(DBConnection.getconn());
		 dao.delete(id); 
		 resp.sendRedirect("view_Emp.jsp");
	}
	
	

}
