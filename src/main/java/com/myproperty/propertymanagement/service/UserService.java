package com.myproperty.propertymanagement.service;

import com.myproperty.propertymanagement.dto.UserDTO;

public interface UserService {
   UserDTO register(UserDTO userDTO);
   UserDTO login(String email,String password);

}
