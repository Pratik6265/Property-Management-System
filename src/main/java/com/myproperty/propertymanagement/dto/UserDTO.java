package com.myproperty.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private  Long id;
private String OwnerName;
private String OwnerEmail;

private String phone;

private  String password;
}
