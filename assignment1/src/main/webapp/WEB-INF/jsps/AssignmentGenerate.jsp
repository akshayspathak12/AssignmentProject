<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="GenerateAssignment" method="POST" enctype="multipart/form-data">
            <center>
                <h2>Assignment</h2>
                Enter the Assignment topic <input type="text" name="topic" required/><br><br>
                  Enter the Start Date:<input type="date" name="startDate" required/><br><br>
                Enter the End Date:<input type="date" name="endDate" required/><br><br>
                Please Upload the Assignment file:<input type="file" name="file" required/><br><br>
                <input type="submit" value="submit"/>
                
            </center>   
        </form>
</body>
</html>