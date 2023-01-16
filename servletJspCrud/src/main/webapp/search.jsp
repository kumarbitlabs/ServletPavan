<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.conn.DBConnection" %>
<%@ page import="com.dao.EmpDao" %>
<%@ page import="com.entity.Emp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="css.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp"%>

<%-- 
<%
Connection conn=DBConnection.getconn();
out.print(conn);
%>

 --%>

<div class="container p-5">

<div class="card">

<div class="card-body">


<p class="text-center fs-1 p-5"> All Employee Data</p>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">contact</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
    <% 
    List<Emp> list = (List<Emp>) request.getAttribute("employees");
    
    for(Emp e:list){
    
    %>
    	
      <tr>
      <th scope="row"> <%=e.getName() %>   </th>
       <td>  <%=e.getAddress() %>   </td>
       <td>  <%=e.getContact() %>   </td>
       <td>  <%=e.getEmail() %>   </td>
      
      <td>
      <a href="edit.jsp?id=<%=e.getId() %>" class="btn btn-sm btn-primary"> Edit</a>
      <a href="delete?id=<%=e.getId() %>" class="btn btn-sm btn-danger"> Delete</a>
      </td>
      
    </tr>
    <% }  
     %>
    
  </tbody>
</table>

</div>


</div>


</div>


</body>
</html>