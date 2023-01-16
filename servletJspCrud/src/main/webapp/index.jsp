<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false"%>
   
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
                      
                        <p class="fs-3 text-center"> Add Employee</p>
                        
                        <c:if test="${succmsg}">
                        
                        <p class="text-center test-success">${succmsg}</p>
                        </c:if>
                        <c:if test=""></c:if>
                        
                        
                        
                        <form action="Registration"  method="post">
                        
                        <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Full Name</label>
    <input type="text" class="form-control" name="name">
    
  </div>
  
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">address</label>
    <input type="text" class="form-control" name="address">
    
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">contact</label>
    <input type="number" class="form-control" name="contact">
    
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email </label>
    <input type="email" class="form-control" name="email">
    
  </div>
 
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
                    
                    
                    </div>
               
               
               
               </div>
         
         
         
         </div>
       
     
     
     
     </div>




</div>


</body>
</html>