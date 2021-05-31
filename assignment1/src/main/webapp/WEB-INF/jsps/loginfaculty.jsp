<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

		 <form action="FacultyLogin" method="POST">
            <h2>Faculty Login </h2><br><br>
                Enter the email:<input type="text" name="email" required/><br><br>
                Enter the password:<input type="password" name="password" required/><br><br>
            <input type="submit" value="Login"/>
        </form>
${msg}
</center>
</body>
</html>