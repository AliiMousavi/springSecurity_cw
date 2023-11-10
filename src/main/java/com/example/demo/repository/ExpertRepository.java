package com.example.demo.repository;

import com.example.demo.entity.Expert;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findUserByEmail(String email);
    @Query("UPDATE Expert a SET a.password=:newPassword WHERE a.id=:id")
    @Modifying
    int updatePasswordByid(Long id , String newPassword);
}
