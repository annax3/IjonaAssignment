package com.employee.ecommerceapi_UsingJwt.dao;


import com.employee.ecommerceapi_UsingJwt.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDaoRepository extends JpaRepository<Employee,Integer>{
}
