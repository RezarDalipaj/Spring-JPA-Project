package com.example.jpa_springg.services.UserDetailsService;

import com.example.jpa_springg.Repository.UserDetailsRepository.UserDetailsRepository;
import com.example.jpa_springg.model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    UserDetailsRepository users;
    UserDetailsServiceImpl(UserDetailsRepository users){
        this.users = users;
    }
//    UserDetailsRepository users = new UserDetailsRepositoryImpl();
    public UserDetails save(UserDetails u){
        return users.save(u);
    }
    public Optional<UserDetails> findById(Integer id){
        return users.findById(id);
    }
    public List<UserDetails> findAll(){
        return users.findAll();
    }
    public UserDetails delete(UserDetails u){
        return users.delete(u);
    }
}
