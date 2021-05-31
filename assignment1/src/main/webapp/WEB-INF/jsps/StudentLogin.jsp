<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Student Login </title>
</head>
<body>
${msg}
<form action="StudentLogin" method="POST">
            <center>
                <h2>Student Login </h2><br><br>
                Enter the Email id:<input type="text" name="email" required/><br><br>
                Enter the Password:<input type="password" name="spassword" required/><br><br>
            <input type="submit" value="Login"/>
            <center>
        </form>

</body>
</html>