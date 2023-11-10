package com.example.demo.controller;

import com.example.demo.dto.AdminResponse;
import com.example.demo.dto.RegisterAdminRequest;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Customer;
import com.example.demo.service.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping("/save")
    public ResponseEntity<?> registerCustomer(@RequestBody @Valid RegisterAdminRequest registerAdminRequest){
        Customer admin = customerService.save(new Customer(registerAdminRequest.firstName(),
                registerAdminRequest.lastName(),
                registerAdminRequest.email(),
                registerAdminRequest.password()));
        return ResponseEntity.ok(adminsResponseMapper(admin));
    }

    private AdminResponse adminsResponseMapper(Customer admin) {
        return new AdminResponse(admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail());
    }
}
