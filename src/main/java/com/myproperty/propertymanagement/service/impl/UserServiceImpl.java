package com.myproperty.propertymanagement.service.impl;

import com.myproperty.propertymanagement.converter.UserConvertor;
import com.myproperty.propertymanagement.dto.UserDTO;
import com.myproperty.propertymanagement.entity.UserEntity;
import com.myproperty.propertymanagement.exception.BusinessException;
import com.myproperty.propertymanagement.exception.ErrorModel;
import com.myproperty.propertymanagement.repository.UserRepository;
import com.myproperty.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> optionalUser= userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUser.isPresent()){
            List<ErrorModel> errorModels=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("DUPLICATE_EMAIL");
            errorModel.setMessage("Email is already registered with this account...");
            errorModels.add(errorModel);
            throw new BusinessException(errorModels);
        }

        UserEntity userEntity=userConvertor.convertDTOtoEntity(userDTO);
        userEntity =userRepository.save(userEntity);
        userDTO = userConvertor.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO=null;
       Optional<UserEntity> optionalUserEntity= userRepository.findByOwnerEmailAndPassword(email,password);
       if(optionalUserEntity.isPresent()){
           userDTO=userConvertor.convertEntitytoDTO(optionalUserEntity.get());
       }

       else{
           List<ErrorModel> errorModels=new ArrayList<>();
           ErrorModel errorModel=new ErrorModel();
           errorModel.setCode("INVALID REQUEST");
           errorModel.setMessage("Something went wrong");
           errorModels.add(errorModel);
           throw new BusinessException(errorModels);
       }
        return userDTO;
    }

}
