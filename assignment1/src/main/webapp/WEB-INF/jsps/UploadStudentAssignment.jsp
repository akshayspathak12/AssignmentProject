<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		  <form action="UploadAssignment" method="POST" enctype="multipart/form-data">
           <center>
            <h2>Kindly Submit Your Assignment</h2><br><br>
            Enter the File Name:<input type="text" name="name"><br><br>
             <input type="file" name="file" required/><br><br>
              <input type="hidden" name="find"  value = "${find}"required/><br><br>
             <input type="submit" value="Upload">
              <input type="hidden" name="student"  value = "${student}"required/><br><br>
           </center>
       </form>
</body>
</html>