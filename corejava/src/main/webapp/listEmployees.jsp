<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dn.week1.a1.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Department ID</th>
        </tr>
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
                for (Employee employee : employees) {
                    %>
                    <tr>
                        <td><%= employee.getEmployeeID() %></td>
                        <td><%= employee.getFirstName() %></td>
                        <td><%= employee.getLastName() %></td>
                        <td><%= employee.getDepartmentID() %></td>
                    </tr>
                    <%
                }
            }
        %>
    </table>
</body>
</html>
