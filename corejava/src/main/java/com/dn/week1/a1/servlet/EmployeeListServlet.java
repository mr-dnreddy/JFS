package com.dn.week1.a1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dn.week1.a1.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empl", "root", "Jambalakadijm@43");

            // SQL query to retrieve employees
            String sql = "SELECT EmployeeID, FirstName, LastName, DepartmentID FROM Employee";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Process result set
            while (rs.next()) {
                int eid = rs.getInt("EmployeeID");
                String fname = rs.getString("FirstName");
                String lname = rs.getString("LastName");
                int dept = rs.getInt("DepartmentID");

                employees.add(new Employee(eid, fname, lname, dept));
            }

            // Set employees as request attribute
            request.setAttribute("employees", employees);

            // Forward to JSP
            request.getRequestDispatcher("listEmployees.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}