<%@page import="com.Model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Page</title>
<style>
	#rd{
		transform: scale(2);
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
String check = (String)request.getAttribute("check");
if(check!=null){
String msg = (String)request.getAttribute("msg");
String msg1=(String)request.getAttribute("msg1");
%>
<div class="container w-75 my-3">
<h2 class="text-center text-decoration-underline"><%=check %> Vote For Your Candidate</h2>
	<%
	if(msg!=null){
	%>
	<br>
	<h3 class="text-center text-success"><%=msg %></h3>
	<%	
	}
	%>
	<%
	if(msg1!=null){
	%>
	<br>
	<h3 class="text-center text-danger"><%=msg1 %></h3>
	<%	
	}
	%>
</div>		
<div class="container w-75 my-4">
<a href="ulogout" class="btn btn-danger">Logout</a>
</div>
	<%
	List<Candidate> list =(List<Candidate>)session.getAttribute("list");
	if(list!=null){
	%>
	<div class="container w-50 shadow-lg p-3 mb-5 bg-body-tertiary rounded">
	<form action="votedone" method="post">
	<input type="hidden" name="uname" value="<%=check%>">
		<% 	
			for(Candidate cd:list){
		%>
	<input type="radio" name="candidateid" value="<%=cd.getCid()%>" class="form-check" id="rd">
	<label class="form-label mb-3"><h5><%=cd.getCparty() %></h5>(<%=cd.getName() %>)</label>
	
		<% 
			}
		%>
	<br>
	<input type="submit" value="Vote" class="btn btn-primary mb-3">
	</form>
	</div>
	<%	
	}
	else{
	%>
	<div class="container w-50">
		<h3 class="text-center text-danger">There is No Candidate !!</h3>
	</div>
	<%	
	}
%>

<%
}
else
{
	response.sendRedirect("userlogin.jsp");
}
%>	
</body>
</html>