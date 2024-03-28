package com.myproperty.propertymanagement.service.impl;

import com.myproperty.propertymanagement.converter.PropertyConverter;
import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.entity.PropertyEntity;
import com.myproperty.propertymanagement.repository.PropertyRepository;
import com.myproperty.propertymanagement.service.PropertyService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe=propertyConverter.convertDTOtoEntity(propertyDTO);

        pe=propertyRepository.save(pe);

        propertyDTO=propertyConverter.convertEntitytoDTO(pe);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyEntityList= (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOS=new ArrayList<>();
        for(PropertyEntity pe:propertyEntityList){
            PropertyDTO propertyDTO=propertyConverter.convertEntitytoDTO(pe);
            propertyDTOS.add(propertyDTO);


        }
        return propertyDTOS;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO,Long id) {

        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(id);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
            pe.setDescription(propertyDTO.getDescription());
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());

            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }


        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDesc(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(propertyID);
        PropertyDTO dto=null;
        if (optionalProperty.isPresent()) {
            PropertyEntity pe = optionalProperty.get();
            pe.setTitle(propertyDTO.getTitle());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyOwnerName(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(propertyID);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyOwnerEmail(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(propertyID);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
             dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return  dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(propertyId);
        if (optionalProperty.isPresent()) {
            propertyRepository.deleteById(propertyId);
        }
    }


    @Override
    public PropertyDTO updatePropertyOwnerAddress(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optionalProperty=propertyRepository.findById(propertyID);
        PropertyDTO dto=null;
        if(optionalProperty.isPresent()){
            PropertyEntity pe=optionalProperty.get();
            pe.setAddress(propertyDTO.getAddress());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return  dto;
    }



}
