package com.myproperty.propertymanagement.service;

import com.myproperty.propertymanagement.dto.PropertyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO propertyDTO,Long id);

     PropertyDTO updatePropertyDesc(PropertyDTO propertyDTO,Long propertyId);

     PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO,Long propertyId);


     PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyID);

     PropertyDTO updatePropertyOwnerName(PropertyDTO propertyDTO, Long propertyID);

     PropertyDTO updatePropertyOwnerEmail(PropertyDTO propertyDTO, Long propertyID);

     PropertyDTO updatePropertyOwnerAddress(PropertyDTO propertyDTO, Long propertyID);

     public void deleteProperty(Long propertyId);

}
