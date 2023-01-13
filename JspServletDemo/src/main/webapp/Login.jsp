<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="LoginServlet" method="post">

     <p>
      <label>Username : <input type="text" name="usr" /></label>
    </p>
  
     <p>
      <label>Password : <input type="password" name="pwd"/></label>
    </p>
  
     <p>
       <button type="submit">Submit</button>
    </p>
 
 
  </form>

</body>
</html>