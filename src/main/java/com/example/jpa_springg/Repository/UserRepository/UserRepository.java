package com.example.jpa_springg.Repository.UserRepository;

import com.example.jpa_springg.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    public User save(User u);
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public User delete(User u);
    public Optional<User> findByUsername (String uname);
}
