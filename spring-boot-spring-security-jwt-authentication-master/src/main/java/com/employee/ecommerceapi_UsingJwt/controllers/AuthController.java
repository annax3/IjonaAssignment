package com.employee.ecommerceapi_UsingJwt.controllers;

import com.employee.ecommerceapi_UsingJwt.entities.EmployeeRole;
import com.employee.ecommerceapi_UsingJwt.entities.Role_Master;
import com.employee.ecommerceapi_UsingJwt.entities.System_User;
import com.employee.ecommerceapi_UsingJwt.payload.request.LoginRequest;
import com.employee.ecommerceapi_UsingJwt.payload.request.SignupRequest;
import com.employee.ecommerceapi_UsingJwt.payload.response.JwtResponse;
import com.employee.ecommerceapi_UsingJwt.payload.response.MessageResponse;
import com.employee.ecommerceapi_UsingJwt.repository.RoleRepository;
import com.employee.ecommerceapi_UsingJwt.repository.UserRepository;
import com.employee.ecommerceapi_UsingJwt.security.jwt.JwtUtils;
import com.employee.ecommerceapi_UsingJwt.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Employee/api/v1")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    System_User user = new System_User(signUpRequest.getUsername(),
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));
    System.out.println(signUpRequest.getUsername()+""+signUpRequest.getEmail());

    Set<String> strRoles = signUpRequest.getRole();
    System.out.println(signUpRequest.getRole());
    Set<Role_Master> roles = new HashSet<>();
    System.out.println(roles);
    if (strRoles == null) {
      Role_Master userRole = roleRepository.findByName(EmployeeRole.EMPLOYEE_ADMIN)
          .orElseThrow(() -> new RuntimeException("Error: Role_Master SA1 is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "SUPER_ADMIN":
          Role_Master suAdminRole = roleRepository.findByName(EmployeeRole.EMPLOYEE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role_Master SA2 is not found."));
          roles.add(suAdminRole);

          break;
        case "ADMIN_FRONTEND":
          Role_Master adminFrontRole = roleRepository.findByName(EmployeeRole.EMPLOYEE_FRONTEND)
              .orElseThrow(() -> new RuntimeException("Error: Role_Master AF is not found."));
          roles.add(adminFrontRole);

          break;
        case "USERS_BACKEND":
            Role_Master userBckndRole = roleRepository.findByName(EmployeeRole.EMPLOYEE_BACKEND)
                .orElseThrow(() -> new RuntimeException("Error: Role_Master UB is not found."));
            roles.add(userBckndRole);

            break;
			default: Role_Master userRole = roleRepository.findByName(EmployeeRole.EMPLOYEE_ADMIN)
			 .orElseThrow(() -> new RuntimeException("Error: Role_Master is SA3 not found."));
			 roles.add(userRole);
			}
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("System_User registered successfully!"));
  }
}
