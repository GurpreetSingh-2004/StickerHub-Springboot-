package com.eazybytes.eazystore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private Long username;
    private String name;
    private String email;
    private String mobileNumber;

}
