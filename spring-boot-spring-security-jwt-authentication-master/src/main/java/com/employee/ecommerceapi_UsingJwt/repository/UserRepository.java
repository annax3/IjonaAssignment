package com.employee.ecommerceapi_UsingJwt.repository;

import com.employee.ecommerceapi_UsingJwt.entities.System_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<System_User, Long> {
  Optional<System_User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
