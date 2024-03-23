package com.myproperty.propertymanagement.converter;


import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Port;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe=new PropertyEntity();
        //this is Adapter design pattern in which we change the layers


        pe.setDescription(propertyDTO.getDescription());
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO=new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setPrice(propertyEntity.getPrice());
        return propertyDTO;
    }
}
