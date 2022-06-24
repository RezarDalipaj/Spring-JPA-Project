package com.example.jpa_springg.Repository.FlightRepository;

import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    public Flight save(Flight f);
    public Optional<Flight> findById(Integer id);
    public List<Flight> findAll();
    public Flight delete(Flight f);
    public List<User> allUsers(int x);
}
