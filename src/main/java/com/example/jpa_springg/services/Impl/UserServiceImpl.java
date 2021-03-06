package com.example.jpa_springg.services.Impl;

import com.example.jpa_springg.Repository.UserRepository.UserRepository;
import com.example.jpa_springg.model.User;
import com.example.jpa_springg.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository users;
    UserServiceImpl(UserRepository users){
        this.users = users;
    }
//    UserRepository users = new UserRepositoryImpl();
    public User save(User u){
        return users.save(u);
    }
    public Optional<User> findById(Integer id){
        return users.findById(id);
    }
    public List<User> findAll(){
        return users.findAll();
    }
    public User delete(User u){
        return users.delete(u);
    }
    public Optional<User> findByUsername(String uname){
        return users.findByUsername(uname);
    }
}
