package com.example.demo.repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findUserByEmail(String email);
    @Query("UPDATE Admin a SET a.password=:newPassword WHERE a.id=:id")
    @Modifying
    int updatePasswordByid(Long id , String newPassword);
}
