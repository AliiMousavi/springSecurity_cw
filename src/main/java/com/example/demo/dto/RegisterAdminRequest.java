package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterAdminRequest(@NotBlank
                                   String firstName,
                                   @NotBlank
                                   String lastName,
                                   @NotBlank
                                   @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%^&+=])(?=\\S+$).{8,}$")
                                   String password,
                                   @Email
                                   String email) {
}
