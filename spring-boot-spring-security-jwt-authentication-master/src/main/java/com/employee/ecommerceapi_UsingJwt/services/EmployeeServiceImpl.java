package com.employee.ecommerceapi_UsingJwt.services;

import com.employee.ecommerceapi_UsingJwt.dao.EmployeeDaoRepository;
import com.employee.ecommerceapi_UsingJwt.entities.Employee;
import com.employee.ecommerceapi_UsingJwt.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoRepository employeeDaoRepository;

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optionalCustomerMaster = employeeDaoRepository.findById(id);
        return optionalCustomerMaster.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDaoRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDaoRepository.save(employee);

    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeDaoRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
            existingEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
            return employeeDaoRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDaoRepository.deleteById(id);
    }
}
