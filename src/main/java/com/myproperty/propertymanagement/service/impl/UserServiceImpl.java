package com.myproperty.propertymanagement.service.impl;

import com.myproperty.propertymanagement.converter.UserConvertor;
import com.myproperty.propertymanagement.dto.UserDTO;
import com.myproperty.propertymanagement.entity.UserEntity;
import com.myproperty.propertymanagement.repository.UserRepository;
import com.myproperty.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity=userConvertor.convertDTOtoEntity(userDTO);
        userEntity =userRepository.save(userEntity);
        userDTO = userConvertor.convertEntitytoDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
