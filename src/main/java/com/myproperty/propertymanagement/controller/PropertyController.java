package com.myproperty.propertymanagement.controller;

import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/hello")
    public double say(@RequestParam("n") double n, @RequestParam("n2") double n2) {
        return n + n2;
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);


        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;

    }

    @PutMapping("/properties/{propertyID}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {
        propertyService.updateProperty(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);


        return responseEntity;


    }

    @PatchMapping("/properties/updatedesc/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyDesc(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {
        propertyService.updatePropertyDesc(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;

    }
    @PatchMapping("/properties/updateprice/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {

        propertyService.updatePropertyPrice(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/updatetitle/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyTiltle(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {

        propertyService.updatePropertyTitle(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/updateownername/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyOwnerName(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {

        propertyService.updatePropertyOwnerName(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/updateowneremail/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyOwnerEmail(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {

        propertyService.updatePropertyOwnerEmail(propertyDTO, propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/updateowneraddress/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyAddress(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {

        propertyService.updatePropertyOwnerAddress(propertyDTO, propertyID);
//        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
//        return responseEntity;
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }


    @DeleteMapping("/properties/delete/{propertyId}")
    public ResponseEntity<Void> propertyDelete(@PathVariable Long propertyId) {
        //another method of deleting a row from the table
//        propertyService.deleteProperty(propertyId);
//        return ResponseEntity.ok().build();


        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }




}
