package com.dn.week1.a1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String message = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empl", "root", "Jambalakadijm@43");

            // Get employee details from request
            int eid = Integer.parseInt(request.getParameter("eid"));
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            int dept = Integer.parseInt(request.getParameter("dept"));

            // SQL query to insert employee
            String sql = "INSERT INTO Employee (EmployeeID, FirstName, LastName, DepartmentID) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eid);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setInt(4, dept);

            // Execute update
            stmt.executeUpdate();
            message = "Employee inserted successfully";

        } catch (ClassNotFoundException | SQLException e) {
            message = "Error inserting employee: " + e.getMessage();
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set message attribute and forward to JSP
        request.setAttribute("message", message);
        request.getRequestDispatcher("insertEmployee.jsp").forward(request, response);
    }
}
