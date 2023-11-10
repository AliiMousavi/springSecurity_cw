package com.example.demo.service.impl;

import com.example.demo.entity.Expert;
import com.example.demo.repository.ExpertRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpertServiceImpl implements UserService<Expert, Long> {
    private final ExpertRepository expertRepository;

    @Override
    public Expert save(Expert expert) {
        return expertRepository.save(expert);
    }

    @Override
    public int update(Long id , String newPassword) {
        return expertRepository.updatePasswordByid(id,newPassword);
    }

    @Override
    public Optional<Expert> findById(Long id) {
        return expertRepository.findById(id);
    }

    @Override
    public Optional<Expert> findByEmail(String email) {
        return expertRepository.findUserByEmail(email);
    }

    @Override
    public List<Expert> findAll() {
        return expertRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        expertRepository.deleteById(id);
    }
}
