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
	 <form action="studentData" method="POST">
           
                <h2>Add Student</h2>     
            Enter the Student name:<input type="text" name="sname" required/><br><br>
            Enter the Student mail:<input type="text" name="email" required/><br><br>
             Enter the Student password:<input type="text" name="spassword" required/><br><br>
            Enter the Student Rollno:<input type="text" name="rollNo" required/><br><br>
            <input type="submit" value="Add">
            
        </form>
        </center>
</body>
</html>