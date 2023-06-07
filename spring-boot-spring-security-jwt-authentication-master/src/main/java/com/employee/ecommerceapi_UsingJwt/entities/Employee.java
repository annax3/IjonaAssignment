package com.employee.ecommerceapi_UsingJwt.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmployeeId;

    private String EmployeeName;

    private  String EmployeeEmail;

    private String EmployeeDepartment;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeeDepartment() {
        return EmployeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        EmployeeDepartment = employeeDepartment;
    }

    public Employee(Integer employeeId, String employeeName, String employeeEmail, String employeeDepartment) {
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        EmployeeEmail = employeeEmail;
        EmployeeDepartment = employeeDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmployeeId +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeEmail='" + EmployeeEmail + '\'' +
                ", EmployeeDepartment='" + EmployeeDepartment + '\'' +
                '}';
    }
}
