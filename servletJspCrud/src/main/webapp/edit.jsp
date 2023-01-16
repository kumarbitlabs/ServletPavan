<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.conn.DBConnection" %>
<%@ page import="com.dao.EmpDao" %>
<%@ page import="com.entity.Emp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="css.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp"%>

<div class="container  p-5">
     <div class="row">
         <div class="col-md-6 offset-md-3">
               <div class="card">
                    <div class="card-body">
                      
                        <p class="fs-3 text-center"> Edit Employee</p>
                       <%  
                        
                       String eid=request.getParameter("id"); 
                       int id=Integer.parseInt(eid);
                       EmpDao dao = new EmpDao(DBConnection.getconn());
                       Emp e=dao.getEmployeeById(id); 
    
    %>
                        
                        <form action="EditServlet"  method="post">
                        
                        <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Full Name</label>
    <input type="text" class="form-control" name="name" value="<%=e.getName() %>" >
    
  </div>
  
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">address</label>
    <input type="text" class="form-control" name="address" value="<%=e.getAddress() %>">
    
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">contact</label>
    <input type="number" class="form-control" name="contact" value="<%=e.getContact() %>"  >
    
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email </label>
    <input type="email" class="form-control" name="email"  value="<%=e.getEmail() %>" >
    
  </div>
 
 <input type="hidden" name="id" value="<%=e.getId()%>">
  
  <button type="submit" class="btn btn-primary">Update</button>
</form>
                    
                    
                    </div>
               
               
               
               </div>
         
         
         
         </div>
       
     
     
     
     </div>




</div>


</body>
</html>