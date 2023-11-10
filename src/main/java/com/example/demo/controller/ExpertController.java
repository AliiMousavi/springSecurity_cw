package com.example.demo.controller;

import com.example.demo.dto.RegisterAdminRequest;
import com.example.demo.entity.Customer;
import com.example.demo.service.impl.ExpertServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/expert")
public class ExpertController {

    @PostMapping("/save")
    public ResponseEntity<?> registerCustomer(){
        System.out.println("Expert");
        System.out.println("Expert");
        System.out.println("Expert");
        System.out.println("Expert");
        System.out.println("Expert");
        System.out.println("Expert");
        return ResponseEntity.ok("Expert");
    }
}
