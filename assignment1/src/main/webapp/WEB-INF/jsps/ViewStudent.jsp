<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <table border="1">
            <tr>
                <th>Student Roll No</th>
                <th>Student Name</th>
                 <th>Assignment Topic</th>
                <th>Answer sheet</th>
                
            </tr>
           <c:forEach items="${findAll}" var="findAll">
               
                <tr>
                <td>${findAll.getStudent().rollNo}</td>
                <td>${findAll.getStudent().sname}</td>
                <td>${findAll.getAssignment().topic}</td>
                <td>
               <a href="DownloadAnswerSheet?file=${findAll.fileUpload.id}">Download Student AnswerSheet File</a><br>
                    </c:forEach>
                </td>
              
                </tr>
          
</body>
</html>