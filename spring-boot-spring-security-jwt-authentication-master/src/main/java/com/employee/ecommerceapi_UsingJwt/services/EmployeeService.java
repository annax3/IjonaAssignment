package com.employee.ecommerceapi_UsingJwt.services;

import com.employee.ecommerceapi_UsingJwt.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
}
