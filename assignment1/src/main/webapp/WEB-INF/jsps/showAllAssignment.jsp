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
                    <th>Assignment Topic</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Question File</th>
                    <th>Upload the Assignment</th>
                </tr>
					
					

                <c:forEach items="${find}" var="find">
               
               
               
  				
              
                    <tr>
                        <td>${find.topic}</td>
                        <td>${find.startDate}</td>
                        <td>${find.endDate}</td>
                      
                        <td>
                            
                            
                            <a href="dwoloadAssignment?fileUploadId=${find.fileUpload.id}">Download Assignment File<a/><br>
                            
                                    
                        </td>
                        <td><a href="UploadStudentAssignment?find=${find.id}">Upload the Answer sheet</a></td>
                   
                    </tr>
                 
                </c:forEach>
            </table>

</body>
</html>