package com.example.jpa_springg.Repository.UserDetailsRepository;

import com.example.jpa_springg.model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepository {
    public UserDetails save(UserDetails u);
    public Optional<UserDetails> findById(Integer id);
    public List<UserDetails> findAll();
    public UserDetails delete(UserDetails u);
}
