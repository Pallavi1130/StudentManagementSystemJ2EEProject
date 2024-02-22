<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"  %>
    <%@ page import="com.model.Student" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Student Page</title>
</head>
<body>
<h1>STUDNET DETAILS</h1>
<table  class="table table-striped table-dark">
<thead >
<tr>
<th>SID</th>
<th>Name</th>
<th>EMAIL</th>
<th>SUBJECT</th>
<th>GENDER</th>
<th>EDUCATION</th>
</tr>
</thead>
<tbody>
<%ArrayList<Student> al=(ArrayList<Student>)(request.getAttribute("display")); %>
       <% for(Student s:al){%> 
          
     <tr>
     <td><%=s.getSid() %></td>
     <td><%=s.getSname() %></td>
     <td><%=s.getSemail() %></td>
     <td><%=s.getSub() %></td>
     <td><%=s.getGender() %></td>
     <td><%=s.getEducation() %></td>
     
     </tr>
        
<% 
}
%> 
</tbody> 




</table>
</body>
</html>