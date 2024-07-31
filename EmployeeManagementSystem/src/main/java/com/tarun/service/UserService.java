package com.tarun.service;

import com.tarun.dto.UserRegistrationDto;
import com.tarun.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {
  User save(UserRegistrationDto userRegistrationDto);
}
