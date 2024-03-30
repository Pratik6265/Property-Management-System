package com.myproperty.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;

    private String OwnerName;

    @NotNull(message = "Owner email should not be null")
    @NotEmpty(message = "Owner email should not be Empty")
    @Size(min = 1, max = 50, message = "owner email characters must be b/w 1 to 50")
    private String OwnerEmail;

    private String phone;

    @NotNull(message = "Owner password should not be null")
    @NotEmpty(message = "Owner password should not be Empty")
    private String password;
}
