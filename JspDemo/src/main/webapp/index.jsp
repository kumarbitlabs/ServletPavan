<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:red">
<h1> hello JSP</h1>
<h1>Declaration tag:</h1>
<%! int a=10 ; String name="pavan"; %>

<h1>Expression tag:</h1>

a=<%=a %>
name=<%=name%>

<h1>scriptlet tag:</h1>
<%
//java code
int a=10,b=20;
out.println(a+b);
%>
</body>
</html>