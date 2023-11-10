package com.example.demo.service.impl;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements UserService<Admin, Long> {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;


    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public int update(Long id , String newPassword) {
        return adminRepository.updatePasswordByid(id,newPassword);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findUserByEmail(email);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @PostConstruct
    public void test(){
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println(userRepository.findUserByEmail("ahmadmolla1@gmail.com"));
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
        System.out.println("hereliiiiiiiiiiiii");
    }
}
