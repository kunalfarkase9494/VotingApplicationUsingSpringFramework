<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User | SignUp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: cyan;">
<%
String msg = (String)request.getAttribute("msg");
String msg1 =(String)request.getAttribute("msg1");
%>

<div class="container">
        <div class="row justify-content-center align-items-center" style="height: 75vh;">
            <div class="col-4">
<%
if(msg!=null){
%>
<h6 class="text-danger text-center"><%=msg %></h6>
<% 
}if(msg1!=null){	
%>
<h6 class="text-danger text-center"><%=msg1 %></h6>
<%
}
%>
                <div class="card shadow-lg p-3 mb-5 bg-body-tertiary rounded-5">
                    <div class="card-body">
                        <h3 class="card-title text-center">Voter Registration</h3>
                        <form action="signup" method="post">
                            <div class="form-group">
                                <label for="uname">Username</label>
                                <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter username" required="required">
                            </div>
                            <div class="form-group">
                                <label for="upass"> Password</label>
                                <input type="password" class="form-control" id="upass" name="upass" placeholder="Create password" required="required">
                            </div>
                            <div class="form-group">
                                <label for="uage">Age</label>
                                <input type="text" class="form-control mb-2" id="uage" name="uage" placeholder="Ex:-18" required="required">
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Sign Up</button>
                        </form>
                		<hr>
                        <a href="userlogin.jsp" class="btn btn-outline-secondary">Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>