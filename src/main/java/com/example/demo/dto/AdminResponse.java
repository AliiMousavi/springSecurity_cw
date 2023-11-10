package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminResponse(String firstName,
                            String lastName,

                            String email) {
}
