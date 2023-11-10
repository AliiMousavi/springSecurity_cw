package com.example.demo.controller;

import com.example.demo.dto.RegisterAdminRequest;
import com.example.demo.dto.AdminResponse;
import com.example.demo.entity.Admin;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserService<Admin,Long> adminService;

    @PostMapping("/save")
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid RegisterAdminRequest registerAdminRequest){
        Admin admin = adminService.save(new Admin(registerAdminRequest.firstName(),
                        registerAdminRequest.lastName(),
                        registerAdminRequest.email(),
                        registerAdminRequest.password()));
        return ResponseEntity.ok(adminsResponseMapper(admin));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AdminResponse> findById(@PathVariable("id") Long adminId){
        Admin admin = adminService.findById(adminId).orElseThrow(
                () -> new NotFoundException("Admin not found")
        );
        return ResponseEntity.ok(adminsResponseMapper(admin));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AdminResponse>> findAll(){
        List<Admin> admin = adminService.findAll();
        List<AdminResponse> list = admin.stream().map(this::adminsResponseMapper)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Integer> update(@PathVariable Long id , @RequestParam(name = "newPassword") String newPassword ){

        int affectedRows = adminService.update(id,newPassword);
        return ResponseEntity.ok(affectedRows);
    }

    @DeleteMapping("/deletById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long adminId){
        adminService.deleteById(adminId);
        return ResponseEntity.ok("delete successfully.");
    }



    private AdminResponse adminsResponseMapper(Admin admin) {
        return new AdminResponse(admin.getFirstName(),
                                admin.getLastName(),
                                admin.getEmail());
    }


}
