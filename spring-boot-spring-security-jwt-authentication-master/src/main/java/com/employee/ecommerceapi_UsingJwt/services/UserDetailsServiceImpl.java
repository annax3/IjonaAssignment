package com.employee.ecommerceapi_UsingJwt.services;

import com.employee.ecommerceapi_UsingJwt.entities.System_User;
import com.employee.ecommerceapi_UsingJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System_User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("System_User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

}
