<%@page import="com.Model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin|Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
String acheck = (String)request.getAttribute("acheck");
String msg = (String)request.getAttribute("msg");
List<Candidate> cl = (List<Candidate>)session.getAttribute("cl");
if(acheck!=null){
%>
<div class="container w-75">
<h2 class="text-center text-decoration-underline">WelCome to Home Page <%=acheck%></h2>
<a href="alogout" class="btn btn-danger">Logout</a>
</div>

 <div class="container w-75">
 <%
 if(msg!=null){
%>
<h5 class="text-success text-center"><%=msg %></h5>
<%
 }
 %>
        <div class="row justify-content-center align-items-center" style="height: 50vh;">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Add Candidate Details</h3>
                        <form action="addc" method="post">
                            <div class="form-group">
	                            <div class="form-group">
	                                <label for="cid">Candidate ID:</label>
	                                <input type="text" class="form-control" id="cid" name="cid" required="required" placeholder="Enter candidate id">
	                            </div>
                                	<label for="fullName">Full Name:</label>
                                	<input type="text" class="form-control" id="fullName" placeholder="Enter full name" name="fullname" required="required">
	                            </div>
	                            <div class="form-group">
	                                <label for="email">Email address:</label>
	                                <input type="email" class="form-control" id="email" placeholder="Enter email" name="cemail" required="required">
	                            </div>
	                            <div class="form-group">
	                                <label for="cparty">Party Name:</label>
	                                <input type="text" class="form-control mb-2" id="cparty" placeholder="Enter party name" name="pname" required="required">
	                            </div>
	                            <input type="hidden" name="acheck" value="<%=acheck%>">
                            <button type="submit" class="btn btn-primary btn-block">ADD</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>    
<div class="container w-75">
<form action="showc">
<input type="hidden" name="aname" value="<%=acheck%>">
<button class="btn btn-info align-right">Show Candidate</button>
</form>
</div>
<div class="container w-75">
<table class="table">
<tr>
	<th>Candidate Id</th>
	<th>Candidate Name</th>
	<th>Candidate Party</th>
	<th>Candidate Email</th>
	<th>Total Votes</th>
	<th>Delete Candidate</th>
</tr>
<%
if(cl!=null){
	for(Candidate c:cl){	
%>
<tr>
<form action="delete" method="post">
	<input type="hidden" name="aname" value="<%=acheck%>">
	<input type="hidden" value="<%=c.getCid()%>" name="cid">
	<td><%=c.getCid() %></td>
	<td><%=c.getName() %></td>
	<td><%=c.getCparty() %></td>
	<td><%=c.getEmail() %></td>
	<td><%=c.getVotes() %></td>
	<td><button class="btn btn-outline-danger">Delete</button></td>	
</form>	
</tr>

<%}} %>
</table>

</div>
<%		
}
else{
	response.sendRedirect("admin.jsp");	
}
%>
</body>
</html>