<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User | Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: cyan;">
<div class="container">
        <div class="row justify-content-center align-items-center" style="height: 75vh;">
            <div class="col-4">
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null){
%>
<h6 class="text-center text-danger"><%=msg %></h6>
<%
}
%>            
                <div class="card shadow-lg p-3 mb-5 bg-body-tertiary rounded-4">
                    <div class="card-body">
                        <h3 class="card-title text-center">Voter Login</h3>
                        <form action="ulogin" method="post">
                            <div class="form-group">
                                <label for="uname">Username</label>
                                <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter username" required="required">
                            </div>
                            <div class="form-group">
                                <label for="upass">Password</label>
                                <input type="password" class="form-control mb-2" id="upass" name="upass" placeholder="Password" required="required">
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                        </form>
                		<hr>
                        <a href="signup.jsp" class="btn btn-outline-secondary">Sign Up</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>