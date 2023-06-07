package com.employee.ecommerceapi_UsingJwt.repository;

import com.employee.ecommerceapi_UsingJwt.entities.EmployeeRole;
import com.employee.ecommerceapi_UsingJwt.entities.Role_Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role_Master, Long> {
  Optional<Role_Master> findByName(EmployeeRole name);
}
