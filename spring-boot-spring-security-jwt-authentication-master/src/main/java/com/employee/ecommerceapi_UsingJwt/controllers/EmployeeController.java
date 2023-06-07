package com.employee.ecommerceapi_UsingJwt.controllers;

import com.employee.ecommerceapi_UsingJwt.entities.Employee;
import com.employee.ecommerceapi_UsingJwt.exception.EmployeeException;
import com.employee.ecommerceapi_UsingJwt.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployeeById/{id}")
    @PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("Customer not found with ID: " + id);
        }
        return employee;
    }

    @GetMapping("/getAllEmployees")
    @PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveemployee")
    @PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    @PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee == null) {
            throw new EmployeeException("Customer not found with ID: " + id);
        }
        return updatedEmployee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
