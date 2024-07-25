<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Employee</title>
</head>
<body>
    <h2>Delete Employee</h2>
    <form action="EmployeeDeleteServlet" method="post">
        <label for="eid">Employee ID:</label><br>
        <input type="number" id="eid" name="eid"><br>
        <input type="submit" value="Delete Employee">
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
