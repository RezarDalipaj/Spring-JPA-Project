package com.example.jpa_springg.services;

import com.example.jpa_springg.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User save(User u);
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public User delete(User u);
    public Optional<User> findByUsername(String uname);
}
