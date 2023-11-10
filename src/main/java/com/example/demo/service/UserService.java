package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface UserService<T,ID> {
    T save(T t);
    int update(ID id , String newPassword);
    Optional<T> findById(ID id);
    Optional<T> findByEmail(String email);
    List<T> findAll();
    void deleteById(ID id);
}
