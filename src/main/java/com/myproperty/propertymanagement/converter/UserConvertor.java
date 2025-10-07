package com.myproperty.propertymanagement.converter;

import com.myproperty.propertymanagement.dto.UserDTO;
import com.myproperty.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());
        return userEntity;
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO=new UserDTO();
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setId(userEntity.getId());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}
