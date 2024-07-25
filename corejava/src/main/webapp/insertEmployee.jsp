<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Employee</title>
</head>
<body>
    <h2>Insert Employee</h2>
    <form action="EmployeeInsertServlet" method="post">
        <label for="eid">Employee ID:</label><br>
        <input type="number" id="eid" name="eid"><br>
        <label for="fname">First Name:</label><br>
        <input type="text" id="fname" name="fname"><br>
        <label for="lname">Last Name:</label><br>
        <input type="text" id="lname" name="lname"><br>
        <label for="dept">Department ID:</label><br>
        <input type="number" id="dept" name="dept"><br>
        <input type="submit" value="Insert Employee">
    </form>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p><%= message %></p>
    <%
        }
    %>
</body>
</html>
