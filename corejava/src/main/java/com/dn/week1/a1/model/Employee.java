package com.dn.week1.a1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Employee {
	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private int DepartmentID;
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	public Employee(int employeeID, String firstName, String lastName, int departmentID) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		DepartmentID = departmentID;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", DepartmentID=" + DepartmentID + "]";
	}
	
	

}
