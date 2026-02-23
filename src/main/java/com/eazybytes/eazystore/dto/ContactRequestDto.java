package com.eazybytes.eazystore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequestDto {
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "Name must be between 5 to 30 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Mobile Number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number cannot be less than 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Message cannot be empty")
    @Size(min = 5, max = 300, message = "Message cannot be less than 5 characters")
    private String message;

}
